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
        libroService.buscarPorTitulo("asdas");
        boolean salir = false;

        while (salir) {
            System.out.print("===== MENÚ ===== "
                    + "1. Crear un libro."
                    + "2. Crear un autor."
                    + "3. Crear una editorial"
                    + "4. Buscar un autor por nombre."
                    + "5. Buscar un libro por ISBN."
                    + "6. Buscar un libro por título."
                    + "7. Buscar libros por nombre de autor."
                    + "8. Buscar libro por nombre de editorial."
                    + "9. Salir."
                    + "> ");

            int opcion = validarEntero();

            switch (opcion) {
                case 1 ->
                    crearLibro();
                case 2 ->
                    crearAutor();
                case 3 ->
                    crearEditorial();
                case 4 ->
                    buscarAutorPorNombre();
                case 5 ->
                    buscarLibroPorISBN();
                case 6 ->
                    buscarLibroPorTitulo();
                case 7 ->
                    buscarLibrosPorAutor();
                case 8 ->
                    buscarLibrosPorEditorial();
                case 9 ->
                    salir = true;
                default ->
                    System.out.println("Ingrese una opción válida.");
            }
        }

    }

    private void crearLibro() {
    }

    private void crearAutor() {
    }

    private void crearEditorial() {
    }

    private void buscarAutorPorNombre() {
    }

    private void buscarLibroPorISBN() {
    }

    private void buscarLibroPorTitulo() {
    }

    private void buscarLibrosPorAutor() {
    }

    private void buscarLibrosPorEditorial() {
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
