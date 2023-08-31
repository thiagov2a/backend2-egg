/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ex01.entity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Thiago
 */
public class Alquiler {

    private String nombre;
    private Integer documento;
    private Date fechaAlquiler;
    private Date fechaDevolucion;
    private Integer posicionAmarre;
    private Barco barco;
    
    private Long diasOcupacion;
    
    private Double valorAlquiler;
    
    public Alquiler() {
    }

    public Alquiler(String nombre, Integer documento, Date fechaAlquiler, Date fechaDevolucion, Integer posicionAmarre, Barco barco) {
        this.nombre = nombre;
        this.documento = documento;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(Integer posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }
    
    public void calcularDiasOcupacion() {
        long dif = fechaDevolucion.getTime() - fechaAlquiler.getTime();
        this.diasOcupacion = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
        System.out.println(this.diasOcupacion);
    }
    
    public void calcularAlquiler() {
        this.valorAlquiler = this.diasOcupacion * this.barco.getValorModulo();
        System.out.println(this.valorAlquiler);
    }

}
