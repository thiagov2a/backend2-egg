/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ej01.entity;

/**
 *
 * @author Thiago
 */
public final class Gato extends Animal {

    public Gato() {
    }
    
    public Gato(String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
    }
    
    @Override
    public void Alimentarse() {
        System.out.println("El gato se alimenta de " + alimento);
    }
    
}
