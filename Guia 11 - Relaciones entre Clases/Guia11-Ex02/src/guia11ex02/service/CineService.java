/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ex02.service;

import guia11ex02.entity.Asiento;
import guia11ex02.entity.Espectador;
import guia11ex02.entity.Pelicula;
import guia11ex02.entity.Sala;
import guia11ex02.enums.Apellido;
import guia11ex02.enums.Columna;
import guia11ex02.enums.Nombre;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CineService {

    private final int filas = 8;
    private final int columnas = 6;

    private final Scanner input;
    private final List<Sala> salas;
    private final List<Espectador> espectadores;

    public CineService() {
        input = new Scanner(System.in).useDelimiter("\n");
        salas = new ArrayList<>();
        espectadores = new ArrayList<>();
    }

    public void ejecutarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.print("===== MENÚ PRINCIPAL =====\n"
                    + "1. Crear una sala\n"
                    + "2. Crear espectadores\n"
                    + "3. Recibir espectadores en una sala\n"
                    + "4. Mostrar sala\n"
                    + "5. Salir\n"
                    + "Ingrese una opción: ");
            int opcion = validarEntero();

            switch (opcion) {
                case 1:
                    crearSala();
                    break;
                case 2:
                    crearEspectadores();
                    break;
                case 3:
                    recibirEspectadores();
                    break;
                case 4:
                    mostrarSala();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }

            System.out.println();
        }
    }

    public void crearSala() {
        System.out.println("===== CREAR SALA =====");

        Asiento[][] asientos = generarAsientos();
        Pelicula pelicula = generarPelicula();

        System.out.print("Ingrese precio de la sala:\n> $");
        Double precio = validarDouble();

        salas.add(new Sala(asientos, pelicula, precio));

        System.out.println("Sala creada exitosamente.");
    }

    private Asiento[][] generarAsientos() {
        Asiento[][] asientos = new Asiento[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String ubicacion = (filas - i) + Columna.values()[j].toString();
                asientos[i][j] = new Asiento(ubicacion);
            }
        }
        return asientos;
    }

    private Pelicula generarPelicula() {
        System.out.print("Ingrese título de la película:\n> ");
        String titulo = validarString();

        System.out.print("Ingrese duración de la película en horas:\n> ");
        Integer duracion = validarEntero();

        System.out.print("Ingrese edad mínima de la película:\n> ");
        Integer edadMinima = validarEntero();

        System.out.print("Ingrese nombre del director de la película:\n> ");
        String director = validarString();

        return new Pelicula(titulo, duracion, edadMinima, director);
    }

    public void crearEspectadores() {
        System.out.println("===== CREAR ESPECTADORES =====");

        System.out.print("Ingrese la cantidad de espectadores a crear:\n> ");
        int cantidad = validarEntero();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("----- Espectador " + (i + 1) + " -----");
            System.out.print("Ingrese nombre del espectador:\n> ");
            String nombre = validarString();

            System.out.print("Ingrese edad del espectador:\n> ");
            int edad = validarEntero();

            System.out.print("Ingrese dinero disponible del espectador:\n> $");
            double dinero = validarDouble();

            espectadores.add(new Espectador(nombre, edad, dinero));
        }

        System.out.println("Espectadores creados exitosamente.");
    }

    public void recibirEspectadores() {
        System.out.println("===== RECIBIR ESPECTADORES EN UNA SALA =====");

        if (!salas.isEmpty()) {
            System.out.println("Salas disponibles:");
            mostrarSalasDisponibles();

            System.out.print("Ingrese el número de sala donde desea recibir espectadores:\n> ");
            int numSala = validarEntero();

            while (numSala <= 0 || numSala > salas.size()) {
                System.out.println("Número de sala inválido. Por favor, ingrese un número de sala válido.\n> ");
                numSala = validarEntero();
            }

            Sala sala = salas.get(numSala - 1);

            System.out.println("Espectadores disponibles:");
            mostrarEspectadoresDisponibles();

            System.out.print("Ingrese el número de espectador que desea recibir en la sala:\n> ");
            int numEspectador = validarEntero();

            while (numEspectador <= 0 || numEspectador > espectadores.size()) {
                System.out.println("Número de espectador inválido. Por favor, ingrese un número de espectador válido.\n> ");
                numEspectador = validarEntero();
            }

            Espectador espectador = espectadores.get(numEspectador - 1);

            if (asignarEspectador(sala, espectador)) {
                espectadores.remove(espectador);
                System.out.println("Espectador recibido exitosamente en la sala " + numSala + ".");
            } else {
                System.out.println("No fue posible recibir al espectador en la sala. Compruebe los requisitos.");
            }
        } else {
            System.out.println("No hay salas disponibles. Primero debe crear una sala.");
        }
    }

    private boolean asignarEspectador(Sala sala, Espectador espectador) {
        List<Asiento> asientosDisponibles = obtenerAsientosDisponibles(sala.getAsientos());
        if (!asientosDisponibles.isEmpty()) {
            if (espectador.getEdad() >= sala.getPelicula().getEdadMinima() && espectador.getDinero() >= sala.getPrecio()) {
                int indiceAsiento = (int) (Math.random() * asientosDisponibles.size());
                Asiento asiento = asientosDisponibles.get(indiceAsiento);
                asiento.setEspectador(espectador);
                return true;
            }
        }
        return false;
    }

    private List<Asiento> obtenerAsientosDisponibles(Asiento[][] asientos) {
        List<Asiento> asientosDisponibles = new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (asientos[i][j].getEspectador() == null) {
                    asientosDisponibles.add(asientos[i][j]);
                }
            }
        }
        return asientosDisponibles;
    }

    public void mostrarSala() {
        System.out.println("===== MOSTRAR SALA =====");

        if (!salas.isEmpty()) {
            System.out.println("Salas disponibles:");
            mostrarSalasDisponibles();

            System.out.print("Ingrese el número de sala que desea mostrar:\n> ");
            int numSala = validarEntero();

            while (numSala <= 0 || numSala > salas.size()) {
                System.out.println("Número de sala inválido. Por favor, ingrese un número de sala válido.");
                numSala = validarEntero();
            }

            Sala sala = salas.get(numSala - 1);
            Asiento[][] asientos = sala.getAsientos();

            System.out.println("Sala " + numSala + ":");
            System.out.println(sala.getPelicula());
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(asientos[i][j]);
                    if (columnas - 1 != j) {
                        System.out.print("||");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("No hay salas disponibles.");
        }
    }

    private void mostrarSalasDisponibles() {
        for (int i = 0; i < salas.size(); i++) {
            System.out.println("Sala " + (i + 1));
        }
    }

    private void mostrarEspectadoresDisponibles() {
        for (int i = 0; i < espectadores.size(); i++) {
            Espectador espectador = espectadores.get(i);
            System.out.println((i + 1) + ". " + espectador);
        }
    }

    public void simulacionCrearEspectadores() {
        int cantidad = 25 + (int) (Math.random() * (filas * columnas));

        for (int i = 0; i < cantidad; i++) {
            String nombre = simulacionGenerarNombre();
            Integer edad = new Random().nextInt(80) + 1;
            Double dinero = Math.random() * 2500;

            espectadores.add(new Espectador(nombre, edad, dinero));
        }
    }

    private String simulacionGenerarNombre() {
        int indiceNombre = new Random().nextInt(Nombre.values().length);
        String nombre = Nombre.values()[indiceNombre].toString();

        int indiceApellido = new Random().nextInt(Apellido.values().length);
        String apellido = Apellido.values()[indiceApellido].toString();

        return nombre + " " + apellido;
    }

    public void simulacionRecibirEspectadores(int indiceSala) {
        int recibidos = 0;
        int rechazados = 0;
        Sala sala = salas.get(indiceSala - 1);

        for (Espectador aux : espectadores) {
            if (aux.getEdad() >= sala.getPelicula().getEdadMinima() && aux.getDinero() >= sala.getPrecio()) {
                boolean asignado = asignarEspectador(sala, aux);
                if (asignado) {
                    recibidos++;
                } else {
                    rechazados++;
                }
            } else {
                rechazados++;
            }
        }
        System.out.println("Espectadores recibidos: " + recibidos);
        System.out.println("Espectadores rechazados: " + rechazados);
    }

    private int validarEntero() {
        while (true) {
            try {
                return Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número entero válido.\n> ");
            }
        }
    }

    private double validarDouble() {
        while (true) {
            try {
                String entrada = input.next().replace(",", ".");
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido.\n> ");
            }
        }
    }

    private String validarString() {
        String entrada = input.next();
        while (entrada.isEmpty()) {
            System.out.print("Ingrese un valor válido.\n> ");
            entrada = input.next();
        }
        return entrada;
    }

}
