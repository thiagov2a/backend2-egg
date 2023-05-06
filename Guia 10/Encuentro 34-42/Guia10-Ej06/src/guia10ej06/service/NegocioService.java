/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ej06.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class NegocioService {

    private final Scanner input;
    private final Map<String, Double> productos;

    public NegocioService() {
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.productos = new HashMap<>();
    }

    public void agregarProducto() {
        System.out.print("\nIngresar nombre del producto: ");
        String nombre = input.next();

        System.out.print("Ingrese precio del producto: ");
        Double precio = input.nextDouble();

        productos.put(nombre, precio);
    }

    public void modificarPrecio() {
        if (!productos.isEmpty()) {
            System.out.print("\nIngresar nombre del producto a cambiar de precio: ");
            String nombre = input.next();

            boolean productoEncontrado = false;
            for (Map.Entry<String, Double> aux : productos.entrySet()) {
                if (aux.getKey().equalsIgnoreCase(nombre)) {
                    productoEncontrado = true;
                    System.out.print("Ingresar monto: ");
                    aux.setValue(input.nextDouble());
                }
            }
            if (productoEncontrado) {
                System.out.println("\nSe cambió el precio del producto '" + nombre + "'.");
            } else {
                System.out.println("\nNo se encontró el producto '" + nombre + "'.");
            }     
        } else {
            System.out.println("\nLa lista esta vacía.");
        }
    }

    public void eliminarProducto() {
        if (!productos.isEmpty()) {
            System.out.print("\nIngresar producto a eliminar: ");
            String nombre = input.next();

            boolean productoEncontrado = false;
            for (Map.Entry<String, Double> aux : productos.entrySet()) {
                if (aux.getKey().equalsIgnoreCase(nombre)) {
                    productoEncontrado = true;
                    productos.remove(aux.getKey());
                }
            }
            if (productoEncontrado) {
                System.out.println("\nSe eliminó el producto '" + nombre + "'.");
            } else {
                System.out.println("\nNo se encontró el producto '" + nombre + "'.");
            }
        } else {
            System.out.println("\nLa lista esta vacía.");
        }
    }

    public void mostrarProductos() {
        if (!productos.isEmpty()) {
            System.out.println("\nPRODUCTOS");
            for (Map.Entry<String, Double> aux : productos.entrySet()) {
                System.out.println("Nombre: " + aux.getKey() + " | Precio: " + aux.getValue() + "$.");
            }
        } else {
            System.out.println("\nLa lista esta vacía.");
        }
    }

    public void mostrarMenu() {
        int opc = 0;
        do {
            System.out.print("\nMENÚ\n"
                    + "1. Agregar producto.\n"
                    + "2. Modificar precio.\n"
                    + "3. Eliminar producto.\n"
                    + "4. Mostrar productos.\n"
                    + "5. Salir\n"
                    + "> ");
            if (input.hasNextInt()) {
                opc = input.nextInt();
                switch (opc) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        modificarPrecio();
                        break;
                    case 3:
                        eliminarProducto();
                        break;
                    case 4:
                        mostrarProductos();
                        break;
                    case 5:
                        System.out.println("\n¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("\nOpción inválida. Intente nuevamente.");
                        break;
                }
            } else {
                System.out.println("\nOpción inválida. Intente nuevamente.");
            }
        } while (opc != 5);
    }

}
