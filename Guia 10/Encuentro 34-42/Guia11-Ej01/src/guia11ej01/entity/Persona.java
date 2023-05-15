/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ej01.entity;

/**
 *
 * @author Thiago
 */
public class Persona {
    
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer documento;
    private Perro perro;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Integer edad, Integer documento, Perro perro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perro = perro;
    }

    public Perro getPerros() {
        return perro;
    }

    public void setPerros(Perro perro) {
        this.perro = perro;
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

    @Override
    public String toString() {
        return "Persona. Nombre: " + nombre + " " + apellido + " | Edad: " + edad + " | Documento: " + documento + "\nPerro. " + perro;
    }
    
}
