/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package guia11ej03.enums;

/**
 *
 * @author Thiago
 */
public enum Palo {
    COPA(1, "Copa"), ORO(2, "Oro"), ESPADA(3, "Espada"), BASTO(4, "Basto");
    
    private final Integer codigo;
    private final String valor;

    private Palo(Integer codigo, String valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getValor() {
        return valor;
    }
    
}
