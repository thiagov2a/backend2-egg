/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package guia11ex01.enums;

/**
 *
 * @author Thiago
 */
public enum Raza {

    LABRADOR(1, "Labrador"), PASTOR_ALEMAN(2, "Pastor Alemán"), BULLDOG(3, "Bulldog"), GOLDEN(4, "Golden"), OTRO(5, "Otro");

    private final Integer codigo;
    private final String valor;

    private Raza(Integer codigo, String valor) {
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
