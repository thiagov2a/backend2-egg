/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidad.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class AlumnoService {

    private final Scanner input = new Scanner(System.in).useDelimiter("\n");

    public ArrayList<Alumno> crearAlumnos() {

        ArrayList<Alumno> alumnos = new ArrayList();
        System.out.println("LISTA DE ALUMNOS");
        String opc;
        do {
            Alumno alumno = new Alumno();

            System.out.print("Ingrese nombre del alumno.\n> ");
            alumno.setNombre(input.next());

            ArrayList<Integer> notas = new ArrayList();
            System.out.println("Ingrese notas de '" + alumno.getNombre() + "'.");
            for (int i = 0; i < 3; i++) {
                int nota;
                System.out.print("Nota " + (i + 1) + ": ");
                nota = input.nextInt();
                while (nota < 1 || nota > 10) {
                    System.out.print("La nota debe estar entre 1 y 10.\nNota " + (i + 1) + ": ");
                    nota = input.nextInt();
                }
                notas.add(nota);
            }
            alumno.setNotas(notas);

            alumnos.add(alumno);

            System.out.println("¿Desea ingresar otro alumno? s/n");
            opc = input.next();

        } while (!opc.equalsIgnoreCase("n"));

        return alumnos;
    }
    
    public void mostrarAlumnos(ArrayList<Alumno> alumnos) {
        
        if (!alumnos.isEmpty()) {
            System.out.println("LISTA DE ALUMNOS");
            for (Alumno alumno : alumnos) {
                System.out.println("Alumno: " + alumno.getNombre() + " | Notas: " + alumno.getNotas());
            }
        } else {
            System.out.println("La lista está vacía.");
        }
    }
    
    public double notaFinal(ArrayList<Alumno> alumnos, String nombre) {
        
        double promedio = -1;
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                for (Integer nota : alumno.getNotas()) {
                    promedio += nota;
                }
                promedio /= alumno.getNotas().size();
                break;
            }
        }
        return promedio;
    }

    public void mostrarMenu(ArrayList<Alumno> alumnos) {
        
        
        if (!alumnos.isEmpty()) {
            mostrarAlumnos(alumnos);
            System.out.print("Ingrese nombre del alumno a promediar.\n> ");
            String nombre = input.next();
            double promedio = notaFinal(alumnos, nombre); 
            if (promedio != -1) {
                System.out.println("El promedio del alumno '" + nombre + "' es: " + String.format("%,2f", promedio));
            } else {
                System.out.println("El alumno no se encontró.");
            }
        } else {
            System.out.println("La lista está vacía.");
        }
    }
    
}
