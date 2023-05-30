/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ej0203.entity;

import guia12ej0203.enums.Consumo;

/**
 *
 * @author Thiago
 */
public final class Lavadora extends Electrodomestico {
    
    private Double carga;

    public Lavadora() {
    }

    public Lavadora(Double carga, String color, Consumo consumo, Double peso) {
        super(color, consumo, peso);
        this.carga = carga;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }
    
    public void crearLavadora() {
        super.crearElectrodomestico();
        
        System.out.println("===== CARGA =====");
        System.out.print("Ingrese carga de la lavadora.\n> ");
        this.carga = validarDouble();
    }
    
    @Override
    public void precioFinal() {
        super.precioFinal();
        if (carga > 30) {
            this.precio += 500d;
        }
        System.out.println("===== PRECIO FINAL =====");
        System.out.println("El precio final de la lavadora es de $" + this.precio);
    }
    
}
