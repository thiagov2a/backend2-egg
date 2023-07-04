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
public final class Polideportivo extends Edificio {

    private String nombre;
    private String tipoInstalacion;

    public Polideportivo() {
    }

    public Polideportivo(String nombre, String tipoInstalacion, Double ancho, Double alto, Double largo) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.tipoInstalacion = tipoInstalacion;
    }

    @Override
    public void calcularSuperficie() {
    }

    @Override
    public void calcularVolumen() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoInstalacion() {
        return tipoInstalacion;
    }

    public void setTipoInstalacion(String tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }

}
