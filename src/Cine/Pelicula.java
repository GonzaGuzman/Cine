/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

/**
 *
 * @author Rem
 */
public class Pelicula <T> {

    private String titulo;
    private String director;
    private int duracion;
    private T clasificacion;
    private T genero;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, int duracion, T clasificacion, T genero) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public T getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(T clasificacion) {
        this.clasificacion = clasificacion;
    }

    public T getGenero() {
        return genero;
    }

    public void setGenero(T genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "TITULO: " + titulo + " - DIRECTOR: " + director + " - DURACION: " + duracion + " - CLASIFICACION: " + clasificacion+ " - GENERO: " + genero; 
    }



    

    
}
