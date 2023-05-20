/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ex01.entity;

import guia11ex01.enums.Raza;

/**
 *
 * @author Thiago
 */
public class Perro {
    
    private String nombre;
    private Integer edad;
    private Double tamano;
    private Raza raza;

    public Perro() {
    }

    public Perro(String nombre, Integer edad, Double tamano, Raza raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.tamano = tamano;
        this.raza = raza;
    }

    public Double getTamano() {
        return tamano;
    }

    public void setTamano(Double tamano) {
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " | Tamano: " + tamano + " | Raza: " + raza.getValor();
    }
    
}
