/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ex02.service;

/**
 *
 * @author Thiago
 */
public class CantanteFamosoService {

    private String nombre;
    private String discoConMasVentas;

    public CantanteFamosoService() {
    }

    public CantanteFamosoService(String nombre, String discoConMasVentas) {
        this.nombre = nombre;
        this.discoConMasVentas = discoConMasVentas;
    }

    public String getDiscoConMasVentas() {
        return discoConMasVentas;
    }

    public void setDiscoConMasVentas(String discoConMasVentas) {
        this.discoConMasVentas = discoConMasVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CantanteFamosoService{" + "nombre=" + nombre + ", discoConMasVentas=" + discoConMasVentas + '}';
    }

}
