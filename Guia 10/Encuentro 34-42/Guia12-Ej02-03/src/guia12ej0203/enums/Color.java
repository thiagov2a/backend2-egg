/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package guia12ej0203.enums;

/**
 *
 * @author Thiago
 */
public enum Color {
    
    NEGRO("Negro"), ROJO("Rojo"), AZUL("Azul"), GRIS("Gris"), BLANCO("Blanco");
    
    private final String valor;

    private Color(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
