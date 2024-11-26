package org.universidad.recursos;

import org.universidad.gestores.Evaluador;
import org.universidad.interfaces.Clasificable;
import org.universidad.interfaces.Evaluable;

import java.time.LocalDate;

public class Libro extends RecursoAcademico implements Clasificable, Evaluable {
    private int numPaginas;
    private String editorial;
    private boolean libroDigital;



    public Libro(String id, String titulo, LocalDate fechaCreacion, String autor,String categoria,int cantidadCitas, Evaluador evaluador,int numPaginas, String editorial, String libroDigital) {
        super(id, titulo, fechaCreacion, autor, cantidadCitas, evaluador);
        this.numPaginas = numPaginas;
        this.editorial = editorial;
        if ("a".equals(libroDigital)) {
            this.libroDigital = true;
        } else if ("b".equals(libroDigital)) {
            this.libroDigital = false;
        } else {
            throw new IllegalArgumentException("Valor inválido para libroDigital. Solo se permiten 'a' o 'b'.");
        }
        this.evaluador = evaluador;
    }
    public int getNumPaginas() {
        return numPaginas;
    }

    public String getEditorial() {
        return editorial;
    }
    public  boolean EsLibroDigital(){
        return libroDigital;
    }
    @Override
    public void AsignarCategoria(String categoria) {
        this.setCategoria(categoria);
    }
    @Override
    public double ObtenerPuntaje(){
        return cantidadCitas * 0.1;
    }
    @Override
    public double CalcularRelevancia() {

        return ObtenerPuntaje();


    }

    @Override
    public void MostrarDetalles() {
        System.out.println("ID: " + getId());
        System.out.println("Fecha de creacion: " + getFechaCreacion());
        System.out.println("Evaluador: " + evaluador.getNombre());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Autor " + getAutor());
        System.out.println("Categoria: " + getCategoria());
        System.out.println("Puntaje: " + ObtenerPuntaje());
        System.out.println("Numero de paginas: " + getNumPaginas());
        System.out.println("Editorial: " + getEditorial());
        if (EsLibroDigital()) {
            System.out.println("Libro Digital: Si");
        } else {
            System.out.println("Libro Digital: No");
        }
        System.out.println("Cantidad de Citas: " + getCantidadCitas());
        System.out.println("Relevancia: " + CalcularRelevancia());

    }


    @Override
    public String ObtenerCategoriasClasificacion(){
        return getCategoria();
    }


    public void realizarEvaluacion(Evaluador evaluador) {
        double puntaje = ObtenerPuntaje();
        //imprimir en pantalla el nombre del evaluador, el titulo, la categoria y el puntaje

        System.out.println("Evaluador: " + evaluador.getNombre());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Evaluador: " + evaluador.getNombre());

        System.out.println("Categoria: " + getCategoria());
        System.out.println("Puntaje: " + puntaje);

    }
}
