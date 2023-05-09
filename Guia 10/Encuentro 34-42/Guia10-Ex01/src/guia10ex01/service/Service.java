/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ex01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class Service {

    private final Scanner input;
    private final List numeros;
    private double suma;
    
    public Service() {
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.numeros = new ArrayList();
        this.suma = 0;
    }

    public void crearLista() {
        System.out.println("LISTA DE NÚMEROS");
        int num;
        do {
            System.out.print("Ingrese número para agregar a la lista. Termina cuando se ingresa -99.\n> ");
            num = input.nextInt();
            if (num != -99) {
                numeros.add(num);
                suma += num;
            }
        } while (num != -99);
    }

    public void mostrarLista() {
        System.out.println("LISTA DE NÚMEROS");
        numeros.toString();
        System.out.println("Suma total: " + suma + "\nPromedio de números: " + (suma/numeros.size()));
    }
}
