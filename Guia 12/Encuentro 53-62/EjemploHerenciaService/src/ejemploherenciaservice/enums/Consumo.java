/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ejemploherenciaservice.enums;

/**
 *
 * @author Thiago
 */
public enum Consumo {
    
    A(1000d), B(800d), C(600d), D(500d), E(300d), F(100d);
    
    private final Double precio;

    private Consumo(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }
    
}
