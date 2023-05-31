/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia12ej04;

import guia12ej04.entity.Circulo;
import guia12ej04.entity.Rectangulo;

/**
 *
 * @author Thiago
 */
public class Guia12Ej04Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circulo c = new Circulo(5d);
        Rectangulo r = new Rectangulo(5d, 10d);
        
        System.out.println("===== CIRCULO =====");
        System.out.println("Área del circulo: " + c.calcularArea());
        System.out.println("Perimetro del circulo: " + c.calcularPerimetro());
        
        System.out.println("");
        
        System.out.println("===== RECTANGULO =====");
        System.out.println("Área del rectangulo: " + r.calcularArea());
        System.out.println("Perimetro del rectangulo: " + r.calcularPerimetro());
    }
    
}
