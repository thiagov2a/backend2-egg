/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ej04.entity;

import guia12ej04.interfaces.calculosFormas;

/**
 *
 * @author Thiago
 */
public final class Circulo implements calculosFormas {

    private Double radio;

    public Circulo() {
    }

    public Circulo(Double radio) {
        this.radio = radio;
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }
    
    @Override
    public Double calcularArea() {
        return pi * radio * radio;
    }

    @Override
    public Double calcularPerimetro() {
        return pi * (radio + radio);
    }
    
}
