/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service;

import Main.Entidad.Pais;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Thiago
 */
public class PaisService {
    
    private final Scanner input = new Scanner(System.in).useDelimiter("\n");
    private HashSet<Pais> paises = new HashSet<>();
    
    public void crearPaises() {
        
        String opc;
        do {
            Pais pais = new Pais();
            
            System.out.println("Ingrese nombre del país: ");
            pais.setNombre(input.next());
            
            paises.add(pais);
            
            System.out.println("¿Desea ingresar otro país? s/n");
            opc = input.next();
            
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
        System.out.println("Ingrese país a eliminar: ");
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
