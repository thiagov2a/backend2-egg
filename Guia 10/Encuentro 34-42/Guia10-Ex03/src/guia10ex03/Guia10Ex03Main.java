/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ex03;

import guia10ex03.service.LibroService;

/**
 *
 * @author Thiago
 */
public class Guia10Ex03Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LibroService service = new LibroService();
        service.mostrarMenu();
    }
    
}
