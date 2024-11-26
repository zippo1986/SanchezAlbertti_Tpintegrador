package org.universidad.gestores;

import org.universidad.interfaces.FiltroRecurso;
import org.universidad.recursos.RecursoAcademico;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

public class GestorRecursos {

    private ArrayList<RecursoAcademico> recursos;
    private String nombre_Evaluador;

    public GestorRecursos(ArrayList<RecursoAcademico> recursos,String nombreEvaluador) {
        this.recursos = recursos;
        this.nombre_Evaluador = nombreEvaluador;
    }

    public ArrayList<RecursoAcademico> getRecursos() {
        return recursos;
    }
    public List<RecursoAcademico> FiltrarRecursos(FiltroRecurso filtro) {
        return recursos.stream()
                .filter(filtro::evaluar)
                .collect(Collectors.toList());
    }
    public void OrdenarPorFechaCreacion() {
        recursos.sort(Comparator.comparing(RecursoAcademico::getFechaCreacion).reversed());

    }
    public void OrdenarPorRelevancia() {
        recursos.sort(Comparator.comparing(RecursoAcademico::CalcularRelevancia).reversed());
    }

    public void mostrarRecursos() {
        recursos.forEach(RecursoAcademico::MostrarDetalles);
    }

    public void calcularPorcentajesPorCategoria() {
        int totalRecursos = recursos.size();
        if (totalRecursos == 0) {
            System.out.println("No hay recursos disponibles.");
            return;
        }

        Map<String, Long> conteoPorCategoria = recursos.stream()
                .collect(Collectors.groupingBy(RecursoAcademico::getCategoria, Collectors.counting()));

        conteoPorCategoria.forEach((categoria, conteo) -> {
            double porcentaje = (conteo * 100.0) / totalRecursos;
            System.out.printf("Categoría: %s - Porcentaje: %.2f%%\n", categoria, porcentaje);
        });
    }

    public void generarReporteEstadisticas( String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Nombre del Evaluador: " + this.nombre_Evaluador + "\n");
            writer.write("Cantidad de recursos: " + recursos.size() + "\n");
            writer.write("Cantidad de recursos por categoria: \n");

            List<String> categorias = new ArrayList<>();
            for (RecursoAcademico recurso : recursos) {
                if (!categorias.contains(recurso.getCategoria())) {
                    categorias.add(recurso.getCategoria());
                }
            }
            for (String categoria : categorias) {
                int cantidad = 0;
                for (RecursoAcademico recurso : recursos) {
                    if (recurso.getCategoria().equals(categoria)) {
                        cantidad++;
                    }
                }
                writer.write(categoria + ": " + cantidad + "\n");
            }

            writer.write("Porcentajes por categoria: \n");
            int totalRecursos = recursos.size();
            if (totalRecursos == 0) {
                writer.write("No hay recursos disponibles.\n");
            } else {
                Map<String, Long> conteoPorCategoria = recursos.stream()
                        .collect(Collectors.groupingBy(RecursoAcademico::getCategoria, Collectors.counting()));

                conteoPorCategoria.forEach((categoria, conteo) -> {
                    double porcentaje = (conteo * 100.0) / totalRecursos;
                    try {
                        writer.write("Categoría: " + categoria + " - Porcentaje: " + String.format("%.2f", porcentaje) + "%\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}