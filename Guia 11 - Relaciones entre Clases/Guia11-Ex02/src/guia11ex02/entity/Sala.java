/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ex02.entity;

/**
 *
 * @author Thiago
 */
public class Sala {

    private Asiento[][] asientos;
    private Pelicula pelicula;
    private Double precio;

    public Sala() {
    }

    public Sala(Asiento[][] asientos, Pelicula pelicula, Double precio) {
        this.asientos = asientos;
        this.pelicula = pelicula;
        this.precio = precio;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Precio: $" + precio;
    }

}
