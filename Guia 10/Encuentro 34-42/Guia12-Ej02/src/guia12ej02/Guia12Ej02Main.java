/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia12ej02;

import guia12ej02.entity.Electrodomestico;
import guia12ej02.entity.Lavadora;
import guia12ej02.entity.Televisor;

/**
 *
 * @author Thiago
 */
public class Guia12Ej02Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lavadora l = new Lavadora();
        System.out.println("----- LAVADORA -----");
        l.crearLavadora();
        l.precioFinal();
        System.out.println("===== PRECIO FINAL =====");
        System.out.println("El precio final de la lavadora es de $" + l.getPrecio());
        
        System.out.println();
        
        Televisor t = new Televisor();
        System.out.println("----- TELEVISOR -----");
        t.crearTelevisor();
        t.precioFinal();
        System.out.println("===== PRECIO FINAL =====");
        System.out.println("El precio final del televisor es de $" + t.getPrecio());
    }
    
}
