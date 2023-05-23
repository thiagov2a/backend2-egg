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
        String nombre = validarString();

        System.out.print("Ingrese edad del perro.\n> ");
        Integer edad = validarEntero();

        System.out.print("Ingrese tamano del perro.\n> ");
        Double tamano = validarDouble();

        Raza raza = seleccionarRaza();
        perros.add(new Perro(nombre, edad, tamano, raza));
    }

    private Raza seleccionarRaza() {
        Raza raza = null;
        while (raza == null) {
            System.out.println("Ingrese raza del perro:");
            for (Raza aux : Raza.values()) {
                System.out.println(aux.getCodigo() + ". " + aux.getValor());
            }
            System.out.print("> ");
            Integer seleccion = validarEntero();
            raza = obtenerRazaSeleccionada(seleccion);
        }
        return raza;
    }

    private Raza obtenerRazaSeleccionada(Integer seleccion) {
        for (Raza aux : Raza.values()) {
            if (aux.getCodigo().equals(seleccion)) {
                return aux;
            }
        }
        return null;
    }

    public void agregarPersona() {
        System.out.print("\nIngrese nombre de la persona.\n> ");
        String nombre = validarString();

        System.out.print("Ingrese apellido de la persona.\n> ");
        String apellido = validarString();

        System.out.print("Ingrese edad de la persona.\n> ");
        Integer edad = validarEntero();

        System.out.print("Ingrese documento de la persona.\n> ");
        Integer documento = validarEntero();

        Sexo sexo = seleccionarSexo();
        personas.add(new Persona(nombre, apellido, edad, documento, sexo));
    }

    private Sexo seleccionarSexo() {
        Sexo sexo = null;
        while (sexo == null) {
            System.out.println("Ingrese sexo de la persona:");
            for (Sexo aux : Sexo.values()) {
                System.out.println(aux.getCodigo() + ". " + aux.getValor());
            }
            System.out.print("> ");
            Integer seleccion = validarEntero();
            sexo = obtenerSexoSeleccionado(seleccion);
        }
        return sexo;
    }

    private Sexo obtenerSexoSeleccionado(Integer seleccion) {
        for (Sexo aux : Sexo.values()) {
            if (aux.getCodigo().equals(seleccion)) {
                return aux;
            }
        }
        return null;
    }

    public void listaPerros() {
        System.out.print("PERROS EN ADOPCIÓN");
        String opc;
        do {
            agregarPerro();
            do {
                System.out.print("\n¿Desea ingresar otro perro? s/n\n> ");
                opc = validarString();
            } while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

        } while (!opc.equalsIgnoreCase("n"));
    }

    public void listaPersonas() {
        System.out.print("\nPERSONAS ADOPTANTES");
        String opc;
        do {
            agregarPersona();
            do {
                System.out.print("\n¿Desea ingresar otro persona? s/n\n> ");
                opc = validarString();
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
            System.out.print("\nIngrese su número de documento:\n> ");
            Integer documento = validarEntero();

            Persona adoptante = buscarPersonaPorDocumento(documento);

            if (adoptante != null) {
                if (!perros.isEmpty()) {
                    mostrarPerros();
                    System.out.print("\nIngrese nombre del perro a adoptar:\n> ");
                    String nombre = validarString();

                    Perro adoptado = buscarPerroPorNombre(nombre);

                    if (adoptado != null) {
                        perros.remove(adoptado);
                        adoptante.setPerros(adoptado);
                        System.out.println("\nEl perro ha sido adoptado exitosamente.");
                    } else {
                        System.out.println("\nNo se encontró ningún perro con ese nombre.");
                    }
                } else {
                    System.out.println("\nNo hay perros en adopción.");
                }
            } else {
                System.out.println("\nNo se encontró ninguna persona con ese número de documento.");
            }
        } else {
            System.out.println("\nNo hay personas adoptantes.");
        }
    }

    private Persona buscarPersonaPorDocumento(Integer documento) {
        for (Persona aux : personas) {
            if (aux.getDocumento().equals(documento)) {
                return aux;
            }
        }
        return null;
    }

    private Perro buscarPerroPorNombre(String nombre) {
        for (Perro perro : perros) {
            if (perro.getNombre().equalsIgnoreCase(nombre)) {
                return perro;
            }
        }
        return null;
    }

    public void mostrarMenu() {
        listaPerros();
        listaPersonas();
        int opc;
        do {
            System.out.print("\nMENÚ\n"
                    + "1. Agregar perro\n"
                    + "2. Agregar adoptante\n"
                    + "3. Adoptar perro.\n"
                    + "4. Mostrar perros\n"
                    + "5. Mostrar adoptantes\n"
                    + "6. Salir\n"
                    + "> ");
            opc = validarEntero();
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
        } while (opc != 6);
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
