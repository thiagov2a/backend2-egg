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

    public void mostrarMenu() {
        Autor autor = autorService.crearAutor("Thiago");
        Editorial editorial = editorialService.crearEditorial("IVREA");
        Editorial editorial1 = editorialService.crearEditorial("Lollipop");
        libroService.crearLibro("La Bella y la Bestia", 1945, 25, autor, editorial);
        libroService.crearLibro("Guardianes de la Galaxia", 1996, 54, autor, editorial1);
        System.out.println(autor.toString());
    }

}
