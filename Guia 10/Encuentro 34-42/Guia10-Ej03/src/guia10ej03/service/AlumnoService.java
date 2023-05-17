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
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.alumnos = new ArrayList<>();
    }

    public void agregarAlumno() {
        Alumno alumno = new Alumno();

        System.out.print("\nIngrese nombre del alumno.\n> ");
        alumno.setNombre(input.next());

        System.out.println("Ingrese notas del alumno '" + alumno.getNombre() + "'.");
        ArrayList<Integer> notas = new ArrayList();
        for (int i = 0; i < 3; i++) {
            int nota;
            do {
                System.out.print("Nota " + (i + 1) + ": ");
                while (!input.hasNextInt()) {
                    System.out.print("La nota debe ser un número entero.\nNota " + (i + 1) + ": ");
                    input.next(); // lee la entrada inválida y la descarta
                }
                nota = input.nextInt();
                if (nota < 1 || nota > 10) {
                    System.out.println("La nota debe estar entre 1 y 10.");
                }
            } while (nota < 1 || nota > 10);
            notas.add(nota);
        }
        alumno.setNotas(notas);

        alumnos.add(alumno);
    }

    public void crearAlumnos() {
        System.out.println("LISTA DE ALUMNOS");
        String opc;
        do {
            agregarAlumno();
            do {
                System.out.println("\n¿Desea ingresar otro alumno? s/n");
                opc = input.next();
            } while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

        } while (!opc.equalsIgnoreCase("n"));
    }

    public void mostrarAlumnos() {
        System.out.println("\nLISTA DE ALUMNOS");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
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

    public void promediarAlumno() {
        System.out.print("\nIngrese nombre del alumno a promediar.\n> ");
        String nombre = input.next();
        double promedio = notaFinal(nombre);
        if (promedio != -1) {
            System.out.print("El promedio del alumno '" + nombre + "' es: ");
            System.out.printf("%.2f\n", promedio);
        } else {
            System.out.println("El alumno no se encontró.");
        }
    }

    public void mostrarMenu() {
        crearAlumnos();
        int opc = 0;
        do {
            System.out.print("\nMENÚ\n"
                    + "1. Agregar alumno.\n"
                    + "2. Mostrar alumnos.\n"
                    + "3. Sacar promedio.\n"
                    + "4. Salir.\n"
                    + "> ");
            if (input.hasNextInt()) {
                opc = input.nextInt();
                switch (opc) {
                    case 1:
                        agregarAlumno();
                        break;
                    case 2:
                        mostrarAlumnos();
                        break;
                    case 3:
                        promediarAlumno();
                        break;
                    case 4:
                        System.out.println("\n¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("\nOpción incorrecta. Intente nuevamente.");
                }
            } else {
                System.out.println("\nOpción incorrecta. Intente nuevamente.");
                input.next();
            }
        } while (opc != 4);
    }

}
