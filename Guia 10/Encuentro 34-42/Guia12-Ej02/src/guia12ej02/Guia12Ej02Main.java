/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia12ej02;

import guia12ej02.entity.Electrodomestico;
import guia12ej02.entity.Lavadora;
import guia12ej02.entity.Televisor;
import guia12ej02.enums.Color;
import guia12ej02.enums.Consumo;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class Guia12Ej02Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Electrodomestico e = new Electrodomestico();
        Lavadora l = new Lavadora();
        Televisor t = new Televisor();
        
        System.out.println("===== LAVADORA =====");
        l.crearLavadora();
        l.precioFinal();
        System.out.println("Precio final de la lavadora: " + l.getPrecio());
        
        System.out.println("------------------------------");
        
        System.out.println("===== TELEVISOR =====");
        t.crearTelevisor();
        t.precioFinal();
        System.out.println("Precio final del televisor: " + t.getPrecio());
    }
    
}
