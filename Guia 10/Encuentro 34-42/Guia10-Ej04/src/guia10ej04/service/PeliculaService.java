/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ej04.service;

import static guia10ej04.utilidades.Comparadores.ordenarAlfabeticamenteDirector;
import static guia10ej04.utilidades.Comparadores.ordenarAlfabeticamenteTitulo;
import static guia10ej04.utilidades.Comparadores.ordenarDuracionMayorAMenor;
import static guia10ej04.utilidades.Comparadores.ordenarDuracionMenorAMayor;
import guia10ej04.entidad.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class PeliculaService {

    private final Scanner input;
    private final ArrayList<Pelicula> peliculas;

    public PeliculaService() {
        this.peliculas = new ArrayList();
        this.input = new Scanner(System.in).useDelimiter("\n");
    }

    public void crearPeliculas() {

        String opc;
        do {
            Pelicula pelicula = new Pelicula();

            System.out.println("Ingrese nombre de la pelicula:");
            pelicula.setTitulo(input.next());

            System.out.println("Ingrese director de la pelicula: ");
            pelicula.setDirector(input.next());

            System.out.println("Ingrese duracion de la pelicula: ");
            pelicula.setHoras(input.nextDouble());

            peliculas.add(pelicula);

            System.out.println("¿Desea ingresar otra pelicula? s/n");
            opc = input.next();
        } while (!opc.equalsIgnoreCase("n"));
    }

    public void mostrarPeliculas() {

        System.out.println("\nPELICULAS.");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void mostrarPeliculasMayorHora() {

        System.out.println("\nPELICULAS MAYOR A 1 HORA.");
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getHoras() > 1) {
                System.out.println(pelicula);
            }
        }
    }

    public void mostrarPeliculasDuracionMayorAMenor() {

        Collections.sort(peliculas, ordenarDuracionMayorAMenor);
        System.out.println("\nPELICULAS DE DURACIÓN MAYOR A MENOR.");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void mostrarPeliculasDuracionMenorAMayor() {

        Collections.sort(peliculas, ordenarDuracionMenorAMayor);
        System.out.println("\nPELICULAS DE DURACIÓN MENOR A MAYOR.");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void mostrarPeliculasAlfabeticamenteTitulo() {

        Collections.sort(peliculas, ordenarAlfabeticamenteTitulo);
        System.out.println("\nPELICULAS ALFABETICAMENTE POR TÍTULO.");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void mostrarPeliculasAlfabeticamenteDirector() {

        Collections.sort(peliculas, ordenarAlfabeticamenteDirector);
        System.out.println("\nPELICULAS ALFABETICAMENTE POR DIRECTOR.");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }
}
