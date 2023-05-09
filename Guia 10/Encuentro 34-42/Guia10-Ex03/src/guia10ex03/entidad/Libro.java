/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ex03.entidad;

/**
 *
 * @author Thiago
 */
public class Libro {
    
    private String titulo;
    private String autor;
    private int numEjem;
    private int numEjemPrestados;

    public Libro() {
    }

    public Libro(String titulo, String autor, int numEjem, int numEjemPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.numEjem = numEjem;
        this.numEjemPrestados = numEjemPrestados;
    }

    public int getNumEjemPrestados() {
        return numEjemPrestados;
    }

    public void setNumEjemPrestados(int numEjemPrestados) {
        this.numEjemPrestados = numEjemPrestados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumEjem() {
        return numEjem;
    }

    public void setNumEjem(int numEjem) {
        this.numEjem = numEjem;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + " | Autor: " + autor + " | Ejemplares: " + numEjem + " | Prestados: " + numEjemPrestados;
    }
    
}
