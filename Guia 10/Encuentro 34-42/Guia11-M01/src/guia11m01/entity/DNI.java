/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11m01.entity;

/**
 *
 * @author Thiago
 */
public class DNI {
    
    private char serie;
    private int numero;

    public DNI() {
    }

    public DNI(char serie, int numero) {
        this.serie = serie;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getSerie() {
        return serie;
    }

    public void setSerie(char serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "N° de Serie: " + serie + " | N° de identificación: " + numero;
    }
    
}
