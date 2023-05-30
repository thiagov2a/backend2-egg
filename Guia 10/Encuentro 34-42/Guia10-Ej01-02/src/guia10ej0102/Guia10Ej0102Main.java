/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ej0102;

import guia10ej0102.service.PerroService;

/**
 *
 * @author Thiago
 */
public class Guia10Ej0102Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PerroService service = new PerroService();
        service.crearPerros();
        service.menuPerros();
    }

}
