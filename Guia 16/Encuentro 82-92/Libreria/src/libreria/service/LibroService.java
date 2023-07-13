package libreria.service;

import libreria.entity.Autor;
import libreria.entity.Editorial;
import libreria.entity.Libro;
import libreria.persistence.LibroDAO;

/**
 *
 * @author Thiago
 */
public class LibroService {

    private final LibroDAO DAO;

    public LibroService() {
        this.DAO = new LibroDAO();
    }

    public Libro crearLibro(String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) {
        try {
            
            validarParametrosCrearLibro(titulo, anio, ejemplares, autor, editorial);

            Libro libro = new Libro();
            
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(0);
            libro.setEjemplaresRestantes(ejemplares);
            
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            
            autor.getLibros().add(libro);
            editorial.getLibros().add(libro);

            DAO.guardar(libro);

            System.out.println("Libro creado correctamente.");
            return libro;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el libro: " + e.getMessage());
            return null;
        }
    }

    public Libro editarLibro(Libro libro) {
        try {
            validarParametrosEditarLibro(libro);
            DAO.editar(libro);
            System.out.println("Libro editado correctamente.");
            return libro;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al editar el libro: " + e.getMessage());
            return null;
        }
    }

    public boolean eliminarPorISBN(Long isbn) {
        try {
            validarISBN(isbn);
            DAO.eliminar(isbn);
            System.out.println("Libro eliminado correctamente.");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
            return false;
        }
    }

    public Libro buscarPorISBN(Long isbn) throws Exception {
        try {
            validarISBN(isbn);
            return DAO.buscarPorIsbn(isbn);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al buscar el libro por ISBN: " + e.getMessage());
            return null;
        }
    }

    private void validarParametrosCrearLibro(String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título del libro es requerido.");
        }

        if (anio == null || anio < 0) {
            throw new IllegalArgumentException("El año del libro es inválido.");
        }

        if (ejemplares == null || ejemplares < 1) {
            throw new IllegalArgumentException("La cantidad de ejemplares es inválida.");
        }

        if (autor == null) {
            throw new IllegalArgumentException("El autor del libro es requerido.");
        }

        if (editorial == null) {
            throw new IllegalArgumentException("La editorial del libro es requerida.");
        }
    }

    private void validarParametrosEditarLibro(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro es nulo.");
        }

        if (libro.getIsbn() == null) {
            throw new IllegalArgumentException("El ISBN del libro es requerido.");
        }

        // Resto de validaciones específicas para editar un libro...
    }

    private void validarISBN(Long isbn) {
        if (isbn == null) {
            throw new IllegalArgumentException("El ISBN es requerido.");
        }
    }

}
