/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ex02.abstracts;

/**
 *
 * @author Thiago
 */
public abstract class Edificio {

    protected Double ancho;
    protected Double alto;
    protected Double largo;

    public Edificio() {
    }

    public Edificio(Double ancho, Double alto, Double largo) {
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
    }

    public abstract void calcularSuperficie();

    public abstract void calcularVolumen();

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

}
