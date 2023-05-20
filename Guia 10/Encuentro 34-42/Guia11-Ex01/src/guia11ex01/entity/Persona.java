/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ex01.entity;

import guia11ex01.enums.Sexo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class Persona {

    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer documento;
    private Sexo sexo;
    private List<Perro> perros;

    public Persona() {
        this.perros = new ArrayList<>();
    }

    public Persona(String nombre, String apellido, Integer edad, Integer documento, Sexo sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public List<Perro> getPerro() {
        return perros;
    }

    public void setPerros(List<Perro> perros) {
        this.perros = perros;
    }

    public void addPerro(Perro perro) {
        this.perros.add(perro);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido + " | Edad: " + edad + " | Documento: " + documento + " | Sexo: " + sexo.getValor() + "\nPerro/os: " + perros;
    }

}
