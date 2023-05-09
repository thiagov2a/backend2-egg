/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ex03.entidad;

import java.util.Objects;

/**
 *
 * @author Thiago
 */
public class Libro implements Comparable<Libro> {

    private String titulo;
    private String autor;
    private int numEjemplares;
    private int numEjemPrestados;

    public Libro() {
    }

    public Libro(String titulo, String autor, int numEjemplares, int numEjemPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = numEjemplares;
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

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public int getNumEjemPrestados() {
        return numEjemPrestados;
    }

    public void setNumEjemPrestados(int numEjemPrestados) {
        this.numEjemPrestados = numEjemPrestados;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + " | Autor: " + autor + " | Ejemplares: " + numEjemplares + " | Prestados: " + numEjemPrestados;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.titulo);
        hash = 41 * hash + Objects.hashCode(this.autor);
        hash = 41 * hash + this.numEjemplares;
        hash = 41 * hash + this.numEjemPrestados;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (this.numEjemplares != other.numEjemplares) {
            return false;
        }
        if (this.numEjemPrestados != other.numEjemPrestados) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.autor, other.autor);
    }

    @Override
    public int compareTo(Libro t) {
        return this.titulo.compareToIgnoreCase(t.getTitulo());
    }

}
