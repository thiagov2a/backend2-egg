/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package guia11ex01.enums;

/**
 *
 * @author Thiago
 */
public enum Sexo {

    F(1, "Femenino"), M(2, "Masculino"), O(3, "Otro");

    private Integer codigo;
    private String valor;

    private Sexo(Integer codigo, String valor) {
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
