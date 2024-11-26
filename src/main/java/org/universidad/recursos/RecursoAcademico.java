package org.universidad.recursos;

import org.universidad.gestores.Evaluador;

import java.time.LocalDate;

public abstract class RecursoAcademico {
    private String id;
    private String titulo;
    private LocalDate fechaCreacion;
    private String autor;
    protected String categoria;
    protected int cantidadCitas;
    protected Evaluador evaluador;

    public RecursoAcademico(String id, String titulo, LocalDate fechaCreacion, String autor, int cantidadCitas, Evaluador evaluador) {
        this.id = id;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
        this.categoria = "";
        this.cantidadCitas = cantidadCitas;
        this.evaluador = evaluador;
    }
    public String getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public String getAutor() {
        return autor;
    }
    public String getCategoria() {
        return categoria;
    }
    protected void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getCantidadCitas() {
        return cantidadCitas;
    }
    public abstract double CalcularRelevancia();
    public abstract void MostrarDetalles();
    public abstract void realizarEvaluacion(Evaluador evaluador);
}
