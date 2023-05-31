/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia12ej0203;

import guia12ej0203.entity.Electrodomestico;
import guia12ej0203.entity.Lavadora;
import guia12ej0203.entity.Televisor;
import guia12ej0203.enums.Color;
import guia12ej0203.enums.Consumo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class Guia12Ej0203Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Electrodomestico> electrodomesticos = new ArrayList<>();

        Lavadora e1 = new Lavadora(35d, Color.AZUL.getValor(), Consumo.C, 42.5);
        Lavadora e2 = new Lavadora(40d, Color.ROJO.getValor(), Consumo.A, 80d);
        Televisor e3 = new Televisor(60d, true, Color.GRIS.getValor(), Consumo.B, 49d);
        Televisor e4 = new Televisor(20d, false, Color.BLANCO.getValor(), Consumo.F, 69d);

        electrodomesticos.add(e1);
        electrodomesticos.add(e2);
        electrodomesticos.add(e3);
        electrodomesticos.add(e4);

        Double sumaLavadora = 0d;
        Double sumaTelevisor = 0d;
        Double sumaTotal = 0d;

        for (Electrodomestico aux : electrodomesticos) {
            aux.precioFinal();
            sumaTotal += aux.getPrecio();

            if (aux instanceof Lavadora) {
                sumaLavadora += aux.getPrecio();
            }

            if (aux instanceof Televisor) {
                sumaTelevisor += aux.getPrecio();
            }

            System.out.println("");
        }
        System.out.println("El precio total de las lavadoras es de " + sumaLavadora);
        System.out.println("El precio total de los televisores es de " + sumaTelevisor);
        System.out.println("El precio total de los electrodomestricos es de " + sumaTotal);
    }

}
