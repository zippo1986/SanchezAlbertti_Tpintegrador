package org.universidad.recursos;

import org.universidad.gestores.Evaluador;
import org.universidad.interfaces.Clasificable;
import org.universidad.interfaces.Evaluable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrabajoInvestigacion extends RecursoAcademico implements Clasificable, Evaluable {
    private ArrayList<String> autores;
    private String lineaInvestigacion;
    private boolean financiamiento;
    public TrabajoInvestigacion(String id, String titulo, LocalDate fechaCreacion, String autor, String categoria, int cantidadCitas, Evaluador evaluador, String lineaInvestigacion) {
        super(id, titulo, fechaCreacion, autor, cantidadCitas, evaluador);
        this.autores = new ArrayList<>();
        this.autores.add(autor);

        this.lineaInvestigacion = lineaInvestigacion;
    }

    public void agregarAutor(String autor) {
        autores.add(autor);
    }
    public List<String> getAutores() {
        return autores;
    }
    public String getLineaInvestigacion() {
        return lineaInvestigacion;
    }
    public boolean TieneFinanciamiento() {
        return financiamiento;
    }

    @Override
    public double CalcularRelevancia() {
        return cantidadCitas * 0.1;
    }

    @Override
    public void MostrarDetalles() {
        System.out.println("ID: " + getId());
        System.out.println("Fecha de creacion: " + getFechaCreacion());
        System.out.println("Evaluador: " + evaluador.getNombre());
        System.out.println("Categoria: " + getCategoria());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Linea de Investigacion: " + lineaInvestigacion);
        System.out.println("Cantidad de Citas: " + cantidadCitas);
        System.out.println("Autores: " + getAutores());
        System.out.println("Puntaje: " + ObtenerPuntaje());
        System.out.println(" Tiene financiamiento" + TieneFinanciamiento());
        System.out.println("Linea de investigacion: " + getLineaInvestigacion());

    }

    @Override
    public String ObtenerCategoriasClasificacion() {
        return getCategoria();
    }
    @Override
    public double ObtenerPuntaje() {
        return cantidadCitas * 0.1;
    }

    @Override
    public void AsignarCategoria(String categoria) {
        this.setCategoria(categoria);
    }
    @Override
    public void realizarEvaluacion(Evaluador evaluador) {
        double puntaje = ObtenerPuntaje();
        System.out.println("ID: " + getId());
        System.out.println("Evaluador: " + evaluador.getNombre());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Categoria: " + getCategoria());
        System.out.println("Puntaje: " + puntaje);

    }
}
