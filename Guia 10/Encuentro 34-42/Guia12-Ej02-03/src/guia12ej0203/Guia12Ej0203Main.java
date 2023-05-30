/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia12ej0203;

import guia12ej0203.entity.Lavadora;
import guia12ej0203.entity.Televisor;

/**
 *
 * @author Thiago
 */
public class Guia12Ej0203Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lavadora l = new Lavadora();
        System.out.println("----- LAVADORA -----");
        l.crearLavadora();
        l.precioFinal();
        
        System.out.println();
        
        Televisor t = new Televisor();
        System.out.println("----- TELEVISOR -----");
        t.crearTelevisor();
        t.precioFinal();
    }
    
}
