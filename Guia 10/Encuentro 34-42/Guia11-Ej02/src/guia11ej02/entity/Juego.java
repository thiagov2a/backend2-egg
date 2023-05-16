/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ej02.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class Juego {
    
    private List<Jugador> jugadores;
    private RevolverDeAgua revolver;
    
    public Juego() {
        this.jugadores = new ArrayList<>();
        this.revolver = new RevolverDeAgua();
    }
    
    public void llenarJuego(ArrayList<Jugador> jugadores, RevolverDeAgua revolver) {
        this.jugadores = jugadores;
        this.revolver = revolver;
    }
    
    public void ronda() {
        for (Jugador jugador : jugadores) {
            if (jugador.disparo(revolver)) {
                System.out.println("El " + jugador.toString());
            }
        }
    }
    
}
