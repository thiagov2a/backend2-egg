/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ej03.entity;

import guia11ej03.enumeraciones.Palo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class Baraja {

    private final Scanner input;
    private final List<Carta> baraja;
    private final List<Carta> monton;

    public Baraja() {
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.baraja = new ArrayList<>();
        this.monton = new ArrayList<>();
    }

    public void crearBaraja() {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
        for (Palo aux : Palo.values()) {
            for (int i : num) {
                baraja.add(new Carta(i, aux.getValor()));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(baraja);
    }

    public Carta siguienteCarta() {
        if (baraja.isEmpty()) {
            System.out.println("\nLa baraja está vacía.");
        }
        Carta carta = baraja.get(0);
        System.out.println(carta);
        baraja.remove(0);
        return carta;
    }

    public void cartasDisponibles() {
        System.out.println("\nLas cartas disponibles son " + baraja.size() + ".");
    }

    public void darCartas() {
        System.out.print("\nIngrese número de cartas a dar.\n> ");
        int num = input.nextInt();
        if (baraja.size() >= num) {
            System.out.println("");
            for (int i = 0; i < num; i++) {
                monton.add(siguienteCarta());
            }
        } else {
            cartasDisponibles();
        }
    }

    public void cartasMonton() {
        if (!monton.isEmpty()) {
            System.out.println("");
            for (Carta carta : monton) {
                System.out.println(carta);
            }
        } else {
            System.out.println("\nNo se ha dado ninguna carta.");
        }
    }

    public void mostrarBaraja() {
        if (!baraja.isEmpty()) {
            System.out.println("");
            for (Carta carta : baraja) {
                System.out.println(carta);
            }
        } else {
            System.out.println("\nLa baraja está vacía.");
        }
    }

    public void mostrarMenu() {
        crearBaraja();
        int opc = 0;
        do {
            System.out.print("\nMENÚ\n"
                    + "1. Barajar.\n"
                    + "2. Dar cartas.\n"
                    + "3. Cartas disponibles.\n" 
                    + "4. Mostrar montón.\n"
                    + "5. Mostrar baraja.\n"
                    + "6. Salir.\n"
                    + "> ");
            if (input.hasNextInt()) {
                opc = input.nextInt();
                switch (opc) {
                    case 1:
                        barajar();
                        break;
                    case 2:
                        darCartas();
                        break;
                    case 3:
                        cartasDisponibles();
                        break;
                    case 4:
                        cartasMonton();
                        break;
                    case 5:
                        mostrarBaraja();
                        break;
                    case 6:
                        System.out.println("\n¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("\nOpción invalida. Intente nuevamente.");
                        break;
                }
            } else {
                System.out.println("\nOpción invalida. Intente nuevamente.");
            }
        } while (opc != 6);
    }

}
