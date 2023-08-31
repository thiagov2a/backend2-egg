/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ej04;

import guia10ej04.service.PeliculaService;

/**
 *
 * @author Thiago
 */
public class Guia10Ej04Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PeliculaService service = new PeliculaService();
        service.crearPeliculas();
        service.mostrarPeliculas();
        service.mostrarPeliculasMayorHora();
        service.mostrarPeliculasDuracionMayorAMenor();
        service.mostrarPeliculasDuracionMenorAMayor();
        service.mostrarPeliculasAlfabeticamenteTitulo();
        service.mostrarPeliculasAlfabeticamenteDirector();
    }

}
