/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11m01;

import guia11m01.entity.DNI;
import guia11m01.entity.Persona;

/**
 *
 * @author Thiago
 */
public class Guia11M01Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DNI dni1 = new DNI('1', 45815384);
        Persona p1 = new Persona("Thiago", "Vildosa", dni1);
        System.out.println(p1.getDni().toString());
    }
    
}
