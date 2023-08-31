/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ej03.entidad;

import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class Alumno {

    private String nombre;
    private ArrayList<Integer> notas;

    public Alumno() {
    }

    public Alumno(String alumno, ArrayList<Integer> notas) {
        this.nombre = alumno;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Alumno: " + nombre + " | Notas: " + notas;
    }

}
