/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ej02.service;

import guia11ej02.entity.Juego;
import guia11ej02.entity.Jugador;
import guia11ej02.entity.RevolverDeAgua;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class JuegoService {

    private final Scanner input;

    public JuegoService() {
        this.input = new Scanner(System.in).useDelimiter("\n");
    }

    public void jugarRuletaRusa() {
        System.out.print("Ingrese el número de jugadores (entre 1 y 6): ");
        int numJugadores = input.nextInt();
        if (numJugadores < 1 || numJugadores > 6) {
            numJugadores = 6; // Por defecto, si el número está fuera del rango permitido
        }

        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 1; i <= numJugadores; i++) {
            jugadores.add(new Jugador(i));
        }

        RevolverDeAgua revolver = new RevolverDeAgua();
        revolver.llenarRevolver();

        Juego juego = new Juego();
        juego.llenarJuego(jugadores, revolver);

        while (true) {
            juego.ronda();
            System.out.println("Presione enter para continuar...");
            input.nextLine();
            input.nextLine();
        }
    }

}
