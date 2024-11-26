package org.universidad;

import org.universidad.gestores.Evaluador;
import org.universidad.gestores.GestorRecursos;
import org.universidad.recursos.Articulo;
import org.universidad.recursos.Libro;
import org.universidad.recursos.RecursoAcademico;
import org.universidad.recursos.TrabajoInvestigacion;
import org.universidad.excepciones.RecursoNoEncontradoException;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Evaluador evaluador1 = new Evaluador("Juan", "Perez");
        Evaluador evaluador2 = new Evaluador("Ana", "Gomez");


        Articulo articulo1 = new Articulo(
                "1",
                "La Estructura del ADN",
                LocalDate.of(1953, 4, 25),
                "James Watson y Francis Crick",
                10,
                evaluador1,
                Arrays.asList("ADN", "Biología", "Genética"),
                "Nature"
        );
        try {
            articulo1.AsignarCategoria("Ciencias naturales");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Articulo articulo2 = new Articulo(
                "2",
                "Teoría de la Relatividad Especial",
                LocalDate.of(1905, 6, 30),
                "Albert Einstein",
                15,
                evaluador1,
                Arrays.asList("Relatividad", "Física", "Espacio-Tiempo"),
                "Annalen der Physik"
        );
        articulo2.AsignarCategoria("Ciencias naturales");

        Articulo articulo3 = new Articulo(
                "3",
                "El Bosón de Higgs",
                LocalDate.of(2012, 7, 4),
                "CERN",
                20,
                evaluador2,
                Arrays.asList("Física", "Partículas", "Higgs"),
                "Physical Review Letters"
        );
        try {
            articulo3.AsignarCategoria("Ciencias naturales");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Libro libro1 = new Libro(
                "4",
                "El Origen de las Especies",
                LocalDate.of(1859, 11, 24),
                "Charles Darwin",
                "Biología Evolutiva",
                20,
                evaluador1,
                502,
                "John Murray",
                "b"
        );
        try {
            libro1.AsignarCategoria("Ciencias naturales");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Libro libro2 = new Libro(
                "5",
                "Una Breve Historia del Tiempo",
                LocalDate.of(1988, 4, 1),
                "Stephen Hawking",
                "Cosmología",
                25,
                evaluador1,
                256,
                "Bantam Books",
                "a"
        );
        try {
            libro2.AsignarCategoria("Ciencias sociales");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Libro libro3 = new Libro(
                "6",
                "El Universo en una Cáscara de Nuez",
                LocalDate.of(2001, 11, 6),
                "Stephen Hawking",
                "Cosmología",
                30,
                evaluador2,
                224,
                "Bantam Books",
                "a"
        );
        try {
            libro3.AsignarCategoria("Ciencias naturales");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }



        TrabajoInvestigacion trabajo1 = new TrabajoInvestigacion(
                "7",
                "La Descubrimiento de la Penicilina",
                LocalDate.of(1928, 9, 28),
                "Alexander Fleming",
                "Microbiología",
                30,
                evaluador1,
                "Antibióticos y Salud Pública"
        );
        try {
            trabajo1.AsignarCategoria("Ciencias naturales");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        TrabajoInvestigacion trabajo2 = new TrabajoInvestigacion(
                "8",
                "Investigaciones en Computación Cuántica",
                LocalDate.of(2019, 7, 15),
                "John Preskill",
                "Física Cuántica",
                40,
                evaluador1,
                "Procesamiento de Información Cuántica"
        );
        try {
            trabajo2.AsignarCategoria("Ciencias naturales");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        TrabajoInvestigacion trabajo3 = new TrabajoInvestigacion(
                "9",
                "El Genoma Humano",
                LocalDate.of(2003, 4, 14),
                "Proyecto Genoma Humano",
                "Genética",
                50,
                evaluador2,
                "Secuenciación del ADN"
        );
        try {
            trabajo3.AsignarCategoria("Ciencias naturales");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        evaluador1.agregarRecurso(articulo1);
        evaluador1.agregarRecurso(articulo2);
        evaluador1.agregarRecurso(libro1);
        evaluador1.agregarRecurso(libro2);
        evaluador1.agregarRecurso(trabajo1);
        evaluador1.agregarRecurso(trabajo2);

        evaluador2.agregarRecurso(articulo3);
        evaluador2.agregarRecurso(libro3);
        evaluador2.agregarRecurso(trabajo3);
        System.out.println("Recursos del Evaluador 1 ordenados por fecha:");
        evaluador1.getGestoRecursos().OrdenarPorFechaCreacion();
        evaluador1.getGestoRecursos().mostrarRecursos();
        System.out.println("--------------------------------------------");


        GestorRecursos gestorRecursos1 = evaluador1.getGestoRecursos();
        System.out.println("Recursos del Evaluador 1:");
        gestorRecursos1.mostrarRecursos();
        System.out.println("--------------------------------------------");
        List<RecursoAcademico> listaFiltradaPorCategoria= gestorRecursos1.FiltrarRecursos(recurso -> "Ciencias sociales".equals(recurso.getCategoria()));
        System.out.println("Recursos del Evaluador 1 filtrados por categoria Cs Sociales:");
        listaFiltradaPorCategoria.forEach(RecursoAcademico::MostrarDetalles);
        System.out.println("--------------------------------------------");

        GestorRecursos gestorRecursos2 = evaluador2.getGestoRecursos();

        System.out.println("\nRecursos del Evaluador 2:");
        gestorRecursos2.mostrarRecursos();
        System.out.println("--------------------------------------------");
        System.out.println("Lista de recursos del Evaluador 2 ordenados por relevancia:");

        gestorRecursos2.OrdenarPorRelevancia();
        gestorRecursos2.mostrarRecursos();
        System.out.println("--------------------------------------------");
        System.out.println("\nRecursos del Evaluador 2 Filtrados por titulo:El Universo en una Cáscara de Nuez");

        List<RecursoAcademico> listaFiltradaPorTitulo =gestorRecursos2.FiltrarRecursos(recurso ->"El Universo en una Cáscara de Nuez".equals(recurso.getTitulo()));

        listaFiltradaPorTitulo.forEach(RecursoAcademico::MostrarDetalles);
        System.out.println("--------------------------------------------");



        System.out.println("\nPorcentajes por categoría del Evaluador 1:");
        gestorRecursos1.calcularPorcentajesPorCategoria();
        System.out.println("--------------------------------------------");
        System.out.println("\nPorcentajes por categoría del Evaluador 2:");
        gestorRecursos2.calcularPorcentajesPorCategoria();
        System.out.println("--------------------------------------------");
        String filePath1 = "reporte_estadisticas_evaluador1.txt";
        String filePath2 = "reporte_estadisticas_evaluador2.txt";
        gestorRecursos1.generarReporteEstadisticas(filePath1);
        gestorRecursos2.generarReporteEstadisticas(filePath2);
        try {
            evaluador1.eliminarRecurso("2");

    }   catch (RecursoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}