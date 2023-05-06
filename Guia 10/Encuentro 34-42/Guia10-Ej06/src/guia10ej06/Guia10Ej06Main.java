/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ej06;

import guia10ej06.service.NegocioService;

/**
 *
 * @author Thiago
 */
public class Guia10Ej06Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NegocioService service = new NegocioService();
        service.mostrarMenu();
    }
    
}
