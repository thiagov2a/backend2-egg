/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ex01;

import guia10ex01.service.Guia10Ex01Service;

/**
 *
 * @author Thiago
 */
public class Guia10Ex01Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Guia10Ex01Service service = new Guia10Ex01Service();
        service.crearLista();
        service.mostrarLista();
    }
    
}
