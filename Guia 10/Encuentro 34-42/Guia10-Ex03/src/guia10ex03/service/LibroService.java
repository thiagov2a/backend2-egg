/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ex03.service;

import guia10ex03.entidad.Libro;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Thiago
 */
public class LibroService {

    private final Scanner input = new Scanner(System.in).useDelimiter("\n");
    private final Set<Libro> libros = new HashSet<>();

//    public LibroService() {
//        this.input = new Scanner(System.in).useDelimiter("\n");
//        this.libros = new HashSet<>();
//    }
    public void agregarLibro() {
        Libro libro = new Libro();
        System.out.print("\nIngrese titulo del libro.\n> ");
        libro.setTitulo(input.next());
        System.out.print("Ingrese autor del libro.\n> ");
        libro.setAutor(input.next());
        System.out.print("Ingrese ejemplares del libro.\n> ");
        libro.setNumEjem(input.nextInt());
        System.out.print("Ingrese ejemplares prestados del libro.\n> ");
        libro.setNumEjemPrestados(input.nextInt());
        libros.add(libro);
    }

    public void crearLibros() {
        System.out.println("LISTA DE LIBROS");
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
        System.out.print("Ingrese libro a prestar.\n> ");
        String nombre = input.next();

        Iterator<Libro> it = libros.iterator();
        boolean libroEsta = false;
        while (it.hasNext()) {
            Libro aux = it.next();
            if (aux.getTitulo().equalsIgnoreCase(nombre) && aux.getNumEjem() > 0) {
                libroEsta = true;
                int contPrestado = aux.getNumEjemPrestados() + 1;
                int cont = aux.getNumEjem() - 1;
                aux.setNumEjemPrestados(contPrestado);
                aux.setNumEjem(cont);
                return libroEsta;
            } else if (aux.getTitulo().equalsIgnoreCase(nombre) && aux.getNumEjem() == 0) {
                System.out.println("No hay mas ejemplares del libro.");
                return libroEsta;
            }
        }
        System.out.println("El libro no pertenece a la lista.");
        return libroEsta;
    }

    public boolean devolucion() {
        System.out.print("Ingrese libro a devolver.\n> ");
        String nombre = input.next();

        Iterator<Libro> it = libros.iterator();
        boolean libroEsta = false;
        while (it.hasNext()) {
            Libro aux = it.next();
            if (aux.getTitulo().equalsIgnoreCase(nombre) && aux.getNumEjemPrestados() > 0) {
                libroEsta = true;
                int contPrestado = aux.getNumEjemPrestados() - 1;
                int cont = aux.getNumEjem() + 1;
                aux.setNumEjemPrestados(contPrestado);
                aux.setNumEjem(cont);
                return libroEsta;
            }
        }
        System.out.println("El libro no pertenece a la lista.");
        return libroEsta;
    }

    public void mostrarLibros() {
        System.out.println("LISTA DE LIBROS");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void mostrarMenu() {
        crearLibros();
        int opc;
        do {
            System.out.println("\nMENÚ\n"
                    + "1. Agregar libro.\n"
                    + "2. Mostrar libros.\n"
                    + "3. Prestar libro.\n"
                    + "4. Devolver libro.\n"
                    + "5. Salir.\n"
                    + "> ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    prestamo();
                    break;
                case 4:
                    devolucion();
                    break;
                case 5:
                    System.out.println("¡Hasta pronto!");
                    break;
            }
        } while (opc != 5);
    }

}
