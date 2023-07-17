package libreria;

import java.util.Scanner;
import libreria.entity.Autor;
import libreria.entity.Editorial;
import libreria.entity.Libro;
import libreria.service.AutorService;
import libreria.service.EditorialService;
import libreria.service.LibroService;

/**
 *
 * @author Thiago
 */
public class Menu {

    private final AutorService autorService;
    private final EditorialService editorialService;
    private final LibroService libroService;
    private final Scanner input;

    public Menu() {
        this.autorService = new AutorService();
        this.editorialService = new EditorialService();
        this.libroService = new LibroService();
        this.input = new Scanner(System.in).useDelimiter("\n");
    }

    public void ejecutarMenu() {

        boolean salir = false;

        while (salir) {
            System.out.print("===== MENÚ ===== "
                    + "1. Crear un libro."
                    + "2."
                    + "> ");

            int opcion = validarEntero();

            switch (opcion) {
                case 1:
                    
                    break;
                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
        }

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
