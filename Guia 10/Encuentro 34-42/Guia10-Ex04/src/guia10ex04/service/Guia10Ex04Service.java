/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ex04.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class Guia10Ex04Service {

    private final Scanner input;
    private final Map<Integer, String> codigos;

    public Guia10Ex04Service() {
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.codigos = new HashMap<>();
    }

    public void agregarCodigo() {
        System.out.print("\nIngresar Codigo Postal.\n> ");
        Integer codigo = input.nextInt();

        System.out.print("Ingresar Ciudad.\n> ");
        String ciudad = input.next();

        codigos.put(codigo, ciudad);
    }

    public void crearCodigos() {
        String opc;
        do {
            agregarCodigo();
            do {
                System.out.print("\n¿Desea ingresar otro codigo postal? s/n\n> ");
                opc = input.next();
            } while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

        } while (!opc.equalsIgnoreCase("n"));
    }

    public void mostrarCodigos() {
        if (!codigos.isEmpty()) {
            System.out.println("\nCODIGOS POSTALES Y CIUDADES");
            for (Map.Entry<Integer, String> aux : codigos.entrySet()) {
                System.out.println("CP: " + aux.getKey() + " | Ciudad: " + aux.getValue() + ".");
            }
        } else {
            System.out.println("\nLa lista está vacía.");
        }
    }

    public void mostrarCiudad() {
        if (!codigos.isEmpty()) {
            System.out.print("\nIngrese Codigo Postal para saber su ciudad.\n> ");
            Integer codigo = input.nextInt();

            boolean codigoEsta = false;
            for (Map.Entry<Integer, String> aux : codigos.entrySet()) {
                if (aux.getKey().equals(codigo)) {
                    codigoEsta = true;
                    System.out.println("\nLa ciudad del código " + codigo + " es: " + aux.getValue());
                    break;
                }
            }
            if (!codigoEsta) {
                System.out.println("\nNo se encuentra una ciudad con el codigo postal.");
            }
        } else {
            System.out.println("\nLa lista está vacía.");
        }
//        codigos.forEach((Integer t, String u) -> {if (t.equals(codigo)) System.out.println("La ciudad del código " + codigo + " es: " + u);});
//        codigos.forEach((Integer t, String u) -> { if (t.equals(codigo)) System.out.println("La ciudad del código " + codigo + " es: " + u); else System.out.println("No se encontró ninguna ciudad para el código " + codigo); });
//        codigos.forEach((Integer t, String u) -> System.out.println(t.equals(codigo) ? "La ciudad del código " + codigo + " es: " + u : "No se encontró ninguna ciudad para el código " + codigo));
    }

    public void eliminarCodigo() {
        if (!codigos.isEmpty()) {
            System.out.print("\nIngrese Ciudad que desee borrar.\n> ");
            String ciudad = input.next();

            boolean ciudadEsta = false;
            for (Map.Entry<Integer, String> aux : codigos.entrySet()) {
                if (aux.getValue().equalsIgnoreCase(ciudad)) {
                    ciudadEsta = true;
                    codigos.remove(aux.getKey());
                    break; //poner break para poder eliminar en fore y no siga corriendo
                }
            }
            if (ciudadEsta) {
                System.out.println("\nSe eliminó la ciudad '" + ciudad + "' y su código postal.");
            } else {
                System.out.println("\nLa ciudad '" + ciudad + "' no se encuentra en la lista.");
            }
        } else {
            System.out.println("\nLa lista está vacía.");
        }
    }

    public void mostrarMenu() {
        crearCodigos();
        int opc = 0;
        do {
            mostrarCodigos();
            System.out.print("\nMENÚ\n"
                    + "1. Agregar Código Postal.\n"
                    + "2. Eliminar Código Postal.\n"
                    + "3. Mostrar Ciudad.\n"
                    + "4. Salir.\n"
                    + "> ");
            if (input.hasNextInt()) {
                opc = input.nextInt();
                switch (opc) {
                    case 1:
                        agregarCodigo();
                        break;
                    case 2:
                        eliminarCodigo();
                        break;
                    case 3:
                        mostrarCiudad();
                        break;
                    case 4:
                        System.out.println("\n¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("\nOpción incorrecta. Intente nuevamente.");
                        break;
                }
            } else {
                System.out.println("\nOpción incorrecta. Intente nuevamente.");
            }
        } while (opc != 4);
    }

}
