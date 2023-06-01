/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploherenciaservice.entity;

import ejemploherenciaservice.enums.Consumo;

/**
 *
 * @author Thiago
 */
public class Electrodomestico {

    protected Double precio;
    protected String color;
    protected Consumo consumo;
    protected Double peso;

    public Electrodomestico() {
    }

    public Electrodomestico(String color, Consumo consumo, Double peso) {
        this.precio = 1000d;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

}
