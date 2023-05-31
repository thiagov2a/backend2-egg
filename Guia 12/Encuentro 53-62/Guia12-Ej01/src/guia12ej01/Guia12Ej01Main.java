/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia12ej01;

import guia12ej01.entity.Animal;
import guia12ej01.entity.Caballo;
import guia12ej01.entity.Gato;
import guia12ej01.entity.Perro;

/**
 *
 * @author Thiago
 */
public class Guia12Ej01Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Declaracion del objeto Perro
        Animal perro1 = new Perro("Stich", "Carne", 15, "Doberman");
        perro1.Alimentarse();

        //Declaracion de otro objeto perro
        Animal perro2 = new Perro("Teddy", "Croquetas", 10, "Chihuahua");
        perro2.Alimentarse();

        //Declaracion del objeto Gato
        Animal gato1 = new Gato("Pelusa", "Galletas", 15, "Siames");
        gato1.Alimentarse();

        //Declaracion del objeto Caballo
        Animal caballo1 = new Caballo("Spark", "Pasto", 25, "Fino");
        caballo1.Alimentarse();

    }

}
