/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ex01.service;

import guia11ex01.entity.Perro;
import guia11ex01.entity.Persona;
import guia11ex01.enums.Raza;
import guia11ex01.enums.Sexo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class Guia11Ex01Service {

    private final Scanner input;
    private final List<Perro> perros;
    private final List<Persona> personas;

    public Guia11Ex01Service() {
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.perros = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public void agregarPerro() {
        System.out.print("\nIngrese nombre del perro.\n> ");
        String nombre = input.next();

        System.out.print("Ingrese edad del perro.\n> ");
        Integer edad = input.nextInt();

        System.out.print("Ingrese tamano del perro.\n> ");
        Double tamano = input.nextDouble();

        Raza raza = null;
        while (raza == null) {
            System.out.println("Ingrese raza del perro.");
            for (Raza aux : Raza.values()) {
                System.out.println(aux.getCodigo() + ". " + aux.getValor());
            }
            System.out.print("> ");
            Integer seleccion = input.nextInt();
            for (Raza aux : Raza.values()) {
                if (aux.getCodigo().equals(seleccion)) {
                    raza = aux;
                }
            }
        }
        perros.add(new Perro(nombre, edad, tamano, raza));
    }

    public void agregarPersona() {
        System.out.print("\nIngrese nombre de la persona.\n> ");
        String nombre = input.next();

        System.out.print("Ingrese apellido de la persona.\n> ");
        String apellido = input.next();

        System.out.print("Ingrese edad de la persona.\n> ");
        Integer edad = input.nextInt();

        System.out.print("Ingrese documento de la persona.\n> ");
        Integer documento = input.nextInt();

        Sexo sexo = null;
        while (sexo == null) {
            System.out.println("Ingrese sexo de la persona.");
            for (Sexo aux : Sexo.values()) {
                System.out.println(aux.getCodigo() + ". " + aux.getValor());
            }
            System.out.print("> ");
            Integer seleccion = input.nextInt();
            for (Sexo aux : Sexo.values()) {
                if (aux.getCodigo().equals(seleccion)) {
                    sexo = aux;
                }
            }
        }
        personas.add(new Persona(nombre, apellido, edad, documento, sexo));
    }

    public void listaPerros() {
        System.out.print("LISTA DE PERROS");
        String opc;
        do {
            agregarPerro();
            do {
                System.out.print("\n¿Desea ingresar otro perro? s/n\n> ");
                opc = input.next();
            } while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

        } while (!opc.equalsIgnoreCase("n"));
    }

    public void listaPersonas() {
        System.out.print("LISTA DE PERSONAS");
        String opc;
        do {
            agregarPersona();
            do {
                System.out.print("\n¿Desea ingresar otro persona? s/n\n> ");
                opc = input.next();
            } while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

        } while (!opc.equalsIgnoreCase("n"));
    }

    public void mostrarPerros() {
        if (!perros.isEmpty()) {
            System.out.println("\nPERROS EN ADOPCIÓN");
            for (Perro perro : perros) {
                System.out.println(perro);
            }
        } else {
            System.out.println("\nNo hay perros en adopción.");
        }
    }

    public void mostrarPersonas() {
        if (!personas.isEmpty()) {
            System.out.println("\nPERSONAS ADOPTANTES");
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        } else {
            System.out.println("\nNo hay personas adoptantes.");
        }
    }

    public void adoptarPerro() {
        if (!personas.isEmpty()) {
            System.out.print("\nIngrese su numero de documento.\n> ");
            Integer documento = input.nextInt();

            Persona adoptante = null;
            for (Persona aux : personas) {
                if (aux.getDocumento().equals(documento)) {
                    adoptante = aux;
                    break;
                }
            }

            if (!perros.isEmpty()) {
                mostrarPerros();
                System.out.print("\nIngrese nombre de perro a adoptar.\n> ");
                String nombre = input.next();

                Perro adoptado = null;
                for (Perro perro : perros) {
                    if (perro.getNombre().equalsIgnoreCase(nombre)) {
                        adoptado = perro;
                        perros.remove(perro);
                        break;
                    }
                }
                adoptante.setPerro(adoptado);
            } else {
                System.out.println("\nNo hay perros en adopción.");
            }
        } else {
            System.out.println("\nNo hay personas adoptantes.");
        }
    }

    public void mostrarMenu() {
        listaPerros();
        listaPersonas();
        int opc = 0;
        do {
            System.out.print("\nMENÚ\n"
                    + "1. Agregar perro\n"
                    + "2. Agregar adoptante\n"
                    + "3. Adoptar perro.\n"
                    + "4. Mostrar perros\n"
                    + "5. Mostrar adoptantes\n"
                    + "6. Salir\n"
                    + "> ");
            if (input.hasNextInt()) {
                opc = input.nextInt();
                switch (opc) {
                    case 1:
                        agregarPerro();
                        break;
                    case 2:
                        agregarPersona();
                        break;
                    case 3:
                        adoptarPerro();
                        break;
                    case 4:
                        mostrarPerros();
                        break;
                    case 5:
                        mostrarPersonas();
                        break;
                    case 6:
                        System.out.println("¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción invalida. Intente nuevamente.");
                        break;
                }
            } else {
                System.out.println("Opción invalida. Intente nuevamente.");
                input.next();
            }
        } while (opc != 6);
    }

}
