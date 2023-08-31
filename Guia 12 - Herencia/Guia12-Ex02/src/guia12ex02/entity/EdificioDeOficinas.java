/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ex02.entity;

import guia12ex02.abstracts.Edificio;

/**
 *
 * @author Thiago
 */
public final class EdificioDeOficinas extends Edificio {

    private Integer numOficinas;
    private Integer cantPersonasPiso;
    private Integer numPisos;

    public EdificioDeOficinas() {
    }

    public EdificioDeOficinas(Integer numOficinas, Integer cantPersonasPiso, Integer numPisos, Double ancho, Double alto, Double largo) {
        super(ancho, alto, largo);
        this.numOficinas = numOficinas;
        this.cantPersonasPiso = cantPersonasPiso;
        this.numPisos = numPisos;
    }

    @Override
    public void calcularSuperficie() {
    }

    @Override
    public void calcularVolumen() {
    }

    public Integer getNumOficinas() {
        return numOficinas;
    }

    public void setNumOficinas(Integer numOficinas) {
        this.numOficinas = numOficinas;
    }

    public Integer getCantPersonasPiso() {
        return cantPersonasPiso;
    }

    public void setCantPersonasPiso(Integer cantPersonasPiso) {
        this.cantPersonasPiso = cantPersonasPiso;
    }

    public Integer getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(Integer numPisos) {
        this.numPisos = numPisos;
    }

}
