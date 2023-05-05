/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ej02;

import guia10ej02.service.PerroService;

/**
 *
 * @author Thiago
 */
public class Guia10Ej02Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PerroService service = new PerroService();
        service.crearPerros();
        service.menuPerros();
    }

}
