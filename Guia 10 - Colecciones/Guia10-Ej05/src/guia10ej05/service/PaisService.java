/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ej05.service;

import guia10ej05.entidad.Pais;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Thiago
 */
public class PaisService {

    private final Scanner input;
    private final Set<Pais> paises;

    public PaisService() {
        this.paises = new HashSet<>();
        this.input = new Scanner(System.in).useDelimiter("\n");
    }

    public void agregarPais() {
        Pais pais = new Pais();
        System.out.print("\nIngrese nombre del país.\n> ");
        pais.setNombre(input.next());
        paises.add(pais);
    }

    public void crearPaises() {
        System.out.println("LISTA DE PAÍSES");
        String opc;
        do {
            agregarPais();
            do {
                System.out.print("\n¿Desea ingresar otro país? s/n\n> ");
                opc = input.next();
            } while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

        } while (!opc.equalsIgnoreCase("n"));
    }

    public void mostrarPaises() {
        if (!paises.isEmpty()) {
            Set<Pais> nombres = new TreeSet<>(paises);
            System.out.println("\nPAÍSES");
            for (Pais nombre : nombres) {
                System.out.println(nombre);
            }
        } else {
            System.out.println("\nNo hay países en la lista.");
        }
    }

    public void eliminarPais() {
        if (!paises.isEmpty()) {
            System.out.print("\nIngrese país a eliminar.\n> ");
            String nombre = input.next();
            Iterator<Pais> it = paises.iterator();
            boolean paisEncontrado = false;
            while (it.hasNext()) {
                if (it.next().getNombre().equalsIgnoreCase(nombre)) {
                    paisEncontrado = true;
                    it.remove();
                }
            }
            if (paisEncontrado) {
                System.out.println("\nSe eliminó el país.");
            } else {
                System.out.println("\nNo se encontró el país.");
            }
        } else {
            System.out.println("\nNo hay países en la lista.");
        }
    }

    public void mostrarMenu() {
        crearPaises();
        int opc = 0;
        do {
            System.out.print("\nMENÚ\n"
                    + "1. Agregar país.\n"
                    + "2. Mostrar países.\n"
                    + "3. Eliminar país.\n"
                    + "4. Salir.\n"
                    + "> ");
            if (input.hasNextInt()) {
                opc = input.nextInt();
                switch (opc) {
                    case 1:
                        agregarPais();
                        break;
                    case 2:
                        mostrarPaises();
                        break;
                    case 3:
                        eliminarPais();
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
                input.next();
            }
        } while (opc != 4);
    }

}
