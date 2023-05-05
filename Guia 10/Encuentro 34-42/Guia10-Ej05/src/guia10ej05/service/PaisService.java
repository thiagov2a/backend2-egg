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

    public void crearPaises() {

        String opc;
        do {
            Pais pais = new Pais();

            System.out.println("Ingrese nombre del país.\n> ");
            pais.setNombre(input.next());

            paises.add(pais);

            do {
                System.out.println("¿Desea ingresar otro país? s/n\n> ");
                opc = input.next();
            } while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

        } while (!opc.equalsIgnoreCase("n"));
    }

    public void mostrarPaises() {

        TreeSet<Pais> nombres = new TreeSet<>(paises);
        System.out.println("PAÍSES");
        for (Pais nombre : nombres) {
            System.out.println(nombre);
        }
    }

    public void eliminarPais() {

        Iterator<Pais> it = paises.iterator();
        boolean paisEncontrado = false;
        System.out.println("Ingrese país a eliminar.\n> ");
        String nombre = input.next();
        while (it.hasNext()) {
            if (it.next().getNombre().equalsIgnoreCase(nombre)) {
                paisEncontrado = true;
                it.remove();
            }
        }
        if (paisEncontrado) {
            System.out.println("Se eliminó el país.");
        } else {
            System.out.println("No se encontró el país.");
        }
    }

}
