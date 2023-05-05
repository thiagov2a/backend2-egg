/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia10ej03.service;

import guia10ej03.entidad.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class AlumnoService {

    private final Scanner input;
    private final List<Alumno> alumnos;

    public AlumnoService() {
        this.alumnos = new ArrayList<>();
        this.input = new Scanner(System.in).useDelimiter("\n");
    }

    public void crearAlumnos() {

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
    }

    public void mostrarAlumnos() {

        System.out.println("LISTA DE ALUMNOS");
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombre() + " | Notas: " + alumno.getNotas());
        }
    }

    public double notaFinal(String nombre) {

        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                int sum = 0;
                for (Integer nota : alumno.getNotas()) {
                    sum += nota;
                }
                return (double) sum / alumno.getNotas().size();
            }
        }
        return -1;
    }

    public void mostrarMenu() {

        if (!alumnos.isEmpty()) {
            mostrarAlumnos();
            System.out.print("Ingrese nombre del alumno a promediar.\n> ");
            String nombre = input.next();
            double promedio = notaFinal(nombre);
            if (promedio != -1) {
                System.out.println("El promedio del alumno '" + nombre + "' es: " + promedio);
            } else {
                System.out.println("El alumno no se encontró.");
            }
        } else {
            System.out.println("La lista está vacía.");
        }
    }

}
