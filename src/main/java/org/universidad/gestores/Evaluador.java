package org.universidad.gestores;

import org.universidad.excepciones.RecursoNoEncontradoException;
import org.universidad.recursos.RecursoAcademico;

import java.util.ArrayList;
import java.util.List;

public class Evaluador {
    private String nombre;
    private String apellido;
    private GestorRecursos gestorRecursos;
    private ArrayList<RecursoAcademico> recursos;


    public Evaluador(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.recursos = new ArrayList<RecursoAcademico>();
        this.gestorRecursos = new GestorRecursos(recursos,nombre);

    }


    public Evaluador(String nombre, ArrayList<RecursoAcademico> recursos) {
        this.nombre = nombre;
        this.recursos = recursos;
        this.gestorRecursos = new GestorRecursos(recursos,nombre);

    }


    public String getNombre() {
        return nombre;
    }

    public void agregarRecurso(RecursoAcademico recurso) {

        this.recursos.add(recurso);
    }
    public GestorRecursos getGestoRecursos() {
        return gestorRecursos;
    }

    public void eliminarRecurso(String id) throws RecursoNoEncontradoException {
        for (RecursoAcademico recurso : recursos) {
            if (recurso.getId().equals(id)) {
                recursos.remove(recurso);
                return;
            }
        }
        throw new RecursoNoEncontradoException("Recurso con ID " + id + " no encontrado.");
    }
}



