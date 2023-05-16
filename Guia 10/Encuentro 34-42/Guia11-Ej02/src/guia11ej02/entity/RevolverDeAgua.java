/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ej02.entity;

/**
 *
 * @author Thiago
 */
public class RevolverDeAgua {

    private int posicionActual;
    private int posicionAgua;

    public void llenarRevolver() {
        this.posicionActual = posicionAleatoria();
        this.posicionAgua = posicionAleatoria();
    }

    public int posicionAleatoria() {
        return (int) (Math.random() * 6) + 1;
    }

    public boolean mojar() {
        return posicionActual == posicionAgua;
    }

    public void siguienteChorro() {
        posicionActual = (posicionActual % 6) + 1;
    }

    @Override
    public String toString() {
        return "Revolver De Agua - " + "Posicion Actual: " + posicionActual + " | Posicion Agua: " + posicionAgua;
    }

}
