package libreria;

import java.util.ArrayList;
import java.util.List;
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

        // Generar muchos nombres de autores
        String[] nombresAutores = {"Juan García", "María Rodríguez", "Carlos López", "Ana Martínez", "Pedro Sánchez", "Laura Gómez", "Andrés Torres", "Sofía Ramírez", "Gabriel Herrera", "Lucía Morales"};

        // Generar muchos nombres de editoriales
        String[] nombresEditoriales = {"Editorial ABC", "Libros XYZ", "Ediciones 123", "Publicaciones ABCD", "Editorial EFG", "Editorial OPQ", "Libros RST", "Ediciones UVW", "Publicaciones XYZ", "Editorial HIJ"};

        // Generar muchos títulos de libros
        String[] titulosLibros = {"El Secreto del Bosque", "Cazadores de Estrellas", "La Ciudad Perdida", "El Laberinto de los Sueños", "El Último Suspiro", "Amanecer en el Horizonte", "El Misterio de la Isla", "La Herencia Perdida", "El Camino de los Valientes", "El Juego de las Sombras"};

        // Crear una lista para realizar seguimiento de autores, editoriales y títulos utilizados
        List<String> autoresUtilizados = new ArrayList<>();
        List<String> editorialesUtilizadas = new ArrayList<>();
        List<String> titulosUtilizados = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // Generar un autor no utilizado previamente
            String nombreAutor;
            do {
                nombreAutor = nombresAutores[(int) (Math.random() * nombresAutores.length)];
            } while (autoresUtilizados.contains(nombreAutor));
            autoresUtilizados.add(nombreAutor);

            // Generar una editorial no utilizada previamente
            String nombreEditorial;
            do {
                nombreEditorial = nombresEditoriales[(int) (Math.random() * nombresEditoriales.length)];
            } while (editorialesUtilizadas.contains(nombreEditorial));
            editorialesUtilizadas.add(nombreEditorial);

            // Generar un título de libro no utilizado previamente
            String tituloLibro;
            do {
                tituloLibro = titulosLibros[(int) (Math.random() * titulosLibros.length)];
            } while (titulosUtilizados.contains(tituloLibro));
            titulosUtilizados.add(tituloLibro);

            Autor autor = autorService.crearAutor(nombreAutor);
            Editorial editorial = editorialService.crearEditorial(nombreEditorial);

            // Generar un año aleatorio entre 1950 y 2023
            int añoPublicacion = 1950 + (int) (Math.random() * (2023 - 1950 + 1));

            // Generar un número aleatorio de ejemplares entre 1 y 100
            int numeroEjemplares = 1 + (int) (Math.random() * 100);

            Libro libro = libroService.crearLibro(tituloLibro, añoPublicacion, numeroEjemplares, autor, editorial);
            // Hacer algo con el libro creado
        }
        
        

    }

}
