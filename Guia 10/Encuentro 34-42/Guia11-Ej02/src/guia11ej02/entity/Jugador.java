/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ej02.entity;

/**
 *
 * @author Thiago
 */
public class Jugador {

    private final int id;
    private final String nombre;
    private boolean mojado;

    public Jugador(int id) {
        this.id = id;
        this.nombre = "Jugador " + id;
        this.mojado = false;
    }

    public boolean disparo(RevolverDeAgua revolver) {
        revolver.siguienteChorro();
        if (revolver.mojar()) {
            this.mojado = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return nombre;
    }

}
