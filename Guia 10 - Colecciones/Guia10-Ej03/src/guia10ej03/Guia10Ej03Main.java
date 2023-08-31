/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ej03;

import guia10ej03.service.AlumnoService;

/**
 *
 * @author Thiago
 */
public class Guia10Ej03Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlumnoService service = new AlumnoService();
        service.mostrarMenu();
    }

}
