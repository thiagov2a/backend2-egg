/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ex02.service;

import guia11ex02.entity.Asiento;
import guia11ex02.entity.Pelicula;
import guia11ex02.entity.Sala;
import guia11ex02.enums.Columna;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class CineService {

    private final Scanner input;
    private final List<Sala> salas;

    public CineService() {
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.salas = new ArrayList<>();
    }

    public void crearSala() {
        Asiento[][] asientos = generarAsientos();
        Pelicula pelicula = generarPelicula();
        
        System.out.print("Ingrese precio de la sala.\n> $");
        Double precio = validarDouble();
        
        salas.add(new Sala(asientos, pelicula, precio));
    }
    
    private Asiento[][] generarAsientos() {
        Asiento[][] asientos = new Asiento[8][6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                String ubicacion = (8 - i) + Columna.values()[j].toString();
                asientos[i][j] = new Asiento(ubicacion);
            }
        }
        return asientos;
    }
    
    private Pelicula generarPelicula() {
        System.out.print("Ingrese titulo de la pelicula.\n> ");
        String titulo = validarString();
        
        System.out.print("Ingrese duracion de la pelicula en horas.\n> ");
        Integer duracion = validarEntero();
        
        System.out.print("Ingresar edad minima de la pelicula.\n> ");
        Integer edadMinima = validarEntero();
        
        System.out.print("Ingrese nombre del director de la pelicula.\n> ");
        String director = validarString();
        
        return new Pelicula(titulo, duracion, edadMinima, director);
    }
    
    
    
    private int validarEntero() {
        while (true) {
            try {
                return Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número entero válido.\n> ");
            }
        }
    }

    private double validarDouble() {
        while (true) {
            try {
                String entrada = input.next().replace(",", ".");
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido.\n> ");
            }
        }
    }

    private String validarString() {
        String entrada = input.next();
        while (entrada.isEmpty()) {
            System.out.print("Ingrese un valor válido.\n> ");
            entrada = input.next();
        }
        return entrada;
    }

}
