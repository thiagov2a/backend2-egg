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
    
}
