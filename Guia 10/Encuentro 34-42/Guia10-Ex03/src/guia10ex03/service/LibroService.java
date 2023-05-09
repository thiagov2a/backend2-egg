/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ex03.service;

import guia10ex03.entidad.Libro;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Thiago
 */
public class LibroService {

    private final Scanner input;
    private final Set<Libro> libros;

    public LibroService() {
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.libros = new HashSet<>();
    }

    public void agregarLibro() {
        Libro libro = new Libro();

        System.out.print("\nIngrese titulo del libro.\n> ");
        libro.setTitulo(input.next());

        System.out.print("Ingrese autor del libro.\n> ");
        libro.setAutor(input.next());

        System.out.print("Ingrese ejemplares del libro.\n> ");
        libro.setNumEjemplares(input.nextInt());

        System.out.print("Ingrese ejemplares prestados del libro.\n> ");
        libro.setNumEjemPrestados(input.nextInt());

        boolean libroEsta = false;
        for (Libro aux : libros) {
            if (aux.getTitulo().equalsIgnoreCase(libro.getTitulo())) {
                libroEsta = true;
                break;
            }
        }
        if (libroEsta) {
            System.out.println("\nEl libro ya se encuentra en la lista.");
        } else {
            System.out.println("\nEl libro se agregó con éxito.");
            libros.add(libro);
        }
    }

    public void crearLibros() {
        System.out.print("LISTA DE LIBROS");
        String opc;
        do {
            agregarLibro();
            do {
                System.out.print("\n¿Desea ingresar otro libro? s/n\n> ");
                opc = input.next();
            } while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

        } while (!opc.equalsIgnoreCase("n"));
    }

    public boolean prestamo() {
        if (!libros.isEmpty()) {
            System.out.print("\nIngrese libro a prestar.\n> ");
            String nombre = input.next();

            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(nombre)) {
                    if (libro.getNumEjemplares() > 0) {
                        int ejemplares = libro.getNumEjemplares() - 1;
                        libro.setNumEjemplares(ejemplares);

                        int ejemPrestados = libro.getNumEjemPrestados() + 1;
                        libro.setNumEjemPrestados(ejemPrestados);

                        System.out.println("\nPréstamo realizado con exito.");
                        return true;
                    } else {
                        System.out.println("\nNo hay ejemplares para prestar del libro '" + nombre + "'.");
                        return false;
                    }
                }
            }
            System.out.println("\nEl libro '" + nombre + "' no pertenece a la lista.");
            return false;
        } else {
            System.out.println("\nLa lista está vacía.");
            return false;
        }
    }

    public boolean devolucion() {
        if (!libros.isEmpty()) {
            System.out.print("\nIngrese libro a devolver.\n> ");
            String nombre = input.next();

            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(nombre)) {
                    if (libro.getNumEjemPrestados() > 0) {
                        int ejemplares = libro.getNumEjemplares() + 1;
                        libro.setNumEjemplares(ejemplares);

                        int ejemPrestados = libro.getNumEjemPrestados() - 1;
                        libro.setNumEjemPrestados(ejemPrestados);

                        System.out.println("\nDevolución realizada con éxito.");
                        return true;
                    } else {
                        System.out.println("\nNo hay ejemplares prestados del libro '" + nombre + "'.");
                        return false;
                    }
                }
            }
            System.out.println("\nEl libro '" + nombre + "' no pertenece a la lista.");
            return false;
        } else {
            System.out.println("\nLa lista está vacía.");
            return false;
        }
    }

    public void mostrarLibros() {
        if (!libros.isEmpty()) {
            Set<Libro> librosOrdenados = new TreeSet<>(libros);
            System.out.println("\nLISTA DE LIBROS");
            librosOrdenados.forEach((libro) -> System.out.println(libro));
        } else {
            System.out.println("\nLa lista está vacía.");
        }
    }

    public void mostrarMenu() {
        crearLibros();
        int opc = 0;
        do {
            mostrarLibros();
            System.out.print("\nMENÚ\n"
                    + "1. Agregar libro.\n"
                    + "2. Prestar libro.\n"
                    + "3. Devolver libro.\n"
                    + "4. Salir.\n"
                    + "> ");
            if (input.hasNextInt()) {
                opc = input.nextInt();
                switch (opc) {
                    case 1:
                        agregarLibro();
                        break;
                    case 2:
                        prestamo();
                        break;
                    case 3:
                        devolucion();
                        break;
                    case 4:
                        System.out.println("\n¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("\nOpción inválida. Intente nuevamente.");
                        break;
                }
            } else {
                System.out.println("\nOpción inválida. Intente nuevamente.");
            }
        } while (opc != 4);
    }

}
