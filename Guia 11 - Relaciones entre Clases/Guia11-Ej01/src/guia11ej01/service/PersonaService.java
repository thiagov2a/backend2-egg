/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ej01.service;

import guia11ej01.entity.Perro;
import guia11ej01.entity.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class PersonaService {

    private final Scanner input;
    private final List<Persona> personas;

    public PersonaService() {
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.personas = new ArrayList<>();
    }

    public Perro agregarPerro() {
        System.out.print("\nIngrese un nombre.\n> ");
        String nombre = input.next();

        System.out.print("Ingrese una raza.\n> ");
        String raza = input.next();

        System.out.print("Ingrese una edad.\n> ");
        Integer edad = input.nextInt();

        System.out.print("Ingrese un tamano.\n> ");
        Double tamano = input.nextDouble();

        return new Perro(nombre, raza, edad, tamano);
    }

    public void agregarPersona() {
        System.out.print("\nIngrese un nombre.\n> ");
        String nombre = input.next();

        System.out.print("Ingrese un apellido.\n> ");
        String apellido = input.next();

        System.out.print("Ingrese una edad.\n> ");
        Integer edad = input.nextInt();

        System.out.print("Ingrese un documento.\n> ");
        Integer documento = input.nextInt();

        System.out.print("\nPERRO.");
        Perro perro = agregarPerro();

        personas.add(new Persona(nombre, apellido, edad, documento, perro));
    }

    public void crearPersonas() {
        String opc;
        do {
            System.out.print("\nPERSONA");
            agregarPersona();
            do {
                System.out.print("\n¿Desea ingresar otra persona? s/n\n> ");
                opc = input.next();
            } while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

        } while (!opc.equalsIgnoreCase("n"));
    }

    public void mostrarPersonas() {
        System.out.println("\nPERSONAS Y PERROS.");
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }

}
