package org.universidad.recursos;

import org.universidad.gestores.Evaluador;
import org.universidad.interfaces.Clasificable;
import org.universidad.interfaces.Evaluable;

import java.time.LocalDate;
import java.util.List;

public class Articulo extends RecursoAcademico implements Clasificable,Evaluable {
    private List<String> palabrasClave;
    private String revista;


    public Articulo(String id, String titulo, LocalDate fechaCreacion, String autor, int cantidadCitas, Evaluador evaluador, List<String> palabrasClave, String revista) {
        super(id, titulo, fechaCreacion, autor,  cantidadCitas, evaluador);
        this.palabrasClave = palabrasClave;
        this.revista = revista;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }

    public String getRevista() {
        return revista;
    }


    @Override
    public double CalcularRelevancia() {
        return palabrasClave.size() * 0.1;
    }

    @Override
    public void MostrarDetalles() {
        System.out.println("ID: " + getId());
        System.out.println("Fecha de creacion: " + getFechaCreacion());
        System.out.println("Revista: " + revista);
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Evaluador: " + evaluador.getNombre());
        System.out.println("Articulo: " + getTitulo() + " por " + getAutor());
        System.out.println("Categoria: " + getCategoria());
        System.out.println("Cantidad de Palabras clave: " + ContarPalabrasClave());
        System.out.println("palabras clave: " + getPalabrasClave());
        System.out.println("Puntaje: " + ObtenerPuntaje());

    }

    @Override
    public String ObtenerCategoriasClasificacion() {
        return getCategoria();
    }

    @Override
    public void AsignarCategoria(String categoria) {
        this.setCategoria(categoria);
    }

    public int ContarPalabrasClave() {
        return palabrasClave.size();
    }

    @Override
    public double ObtenerPuntaje() {
        return palabrasClave.size() * 0.1;
    }
    @Override
    public void realizarEvaluacion(Evaluador evaluador) {
        double puntaje = ObtenerPuntaje();
        System.out.println("ID: " + getId());
        System.out.println("Fecha de creacion: " + getFechaCreacion());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Articulo: " + getTitulo() + " por " + getAutor());
        System.out.println("Evaluador: " + evaluador.getNombre());
        System.out.println("Categoria: " + getCategoria());
        System.out.println("palabras clave: " + getPalabrasClave());
        System.out.println("Puntaje: " + puntaje);
        System.out.println("Relevancia: " + CalcularRelevancia());
        System.out.println("Cantidad de Citas: " + getCantidadCitas());


    }
}
