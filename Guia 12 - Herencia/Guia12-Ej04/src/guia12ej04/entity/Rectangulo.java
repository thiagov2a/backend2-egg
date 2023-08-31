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
public final class Rectangulo implements calculosFormas {

    private Double base;
    private Double altura;

    public Rectangulo() {
    }

    public Rectangulo(Double base, Double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
    
    @Override
    public Double calcularArea() {
        return base * altura;
    }

    @Override
    public Double calcularPerimetro() {
        return (base + altura) * 2;
    }
    
}
