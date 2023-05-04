/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparadores;

import Entidad.Pelicula;
import java.util.Comparator;

/**
 *
 * @author Thiago
 */
public class Comparador {

    public static Comparator<Pelicula> ordenarDuracionMayorAMenor = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p2.getHoras().compareTo(p1.getHoras());
        }
    };

    public static Comparator<Pelicula> ordenarDuracionMenorAMayor = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getHoras().compareTo(p2.getHoras());
        }
    };

    public static Comparator<Pelicula> ordenarAlfabeticamenteTitulo = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getTitulo().compareTo(p2.getTitulo());
        }
    };

    public static Comparator<Pelicula> ordenarAlfabeticamenteDirector = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getDirector().compareTo(p2.getDirector());
        }
    };

}
