/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class PerroService {

    private final Scanner input = new Scanner(System.in).useDelimiter("\n");

    public ArrayList<String> crearPerros() {

        ArrayList<String> perros = new ArrayList();

        String perro;
        System.out.println("Ingrese una raza de perro para agregar en la lista.\nEscriba 'salir' para terminar.");
        do {
            System.out.print("> ");
            perro = input.nextLine();
            if (!perro.equalsIgnoreCase("salir")) {
                perros.add(perro);
            }
        } while (!perro.equalsIgnoreCase("salir"));

        return perros;
    }

    public void mostrarPerros(ArrayList<String> perros) {

        Collections.sort(perros);
        System.out.println("\nLa lista se compone de las siguientes razas:");
        for (String perro : perros) {
            System.out.println(perro);
        }
    }

    public void eliminarPerro(ArrayList<String> perros, String raza) {

        Iterator<String> it = perros.iterator();
        boolean razaBorrada = false;
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(raza)) {
                razaBorrada = true;
                it.remove();
            }
        }
        if (razaBorrada) {
            System.out.println("Se eliminó la raza ingresada.");
        } else {
            System.out.println("La raza no se encontró en la lista.");
        }
    }

    public void menuPerros(ArrayList<String> perros) {

        if (!perros.isEmpty()) {
            mostrarPerros(perros);
            System.out.print("\nIngrese raza a eliminar.\n> ");
            String raza = input.nextLine();
            eliminarPerro(perros, raza);
            mostrarPerros(perros);
        } else {
            System.out.println("\nLa lista está vacia.");
        }
    }

}
