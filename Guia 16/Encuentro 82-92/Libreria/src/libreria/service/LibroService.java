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
        Libro libro = new Libro();
        try {
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            DAO.guardar(libro);
            System.out.println("Libro creado correctamente.");
            return libro;
        } catch (Exception e) {
            System.out.println("Error al crear el libro: " + e.getMessage());
            return null;
        }
    }

    public Libro editarLibro(Libro libro) {
        try {
            DAO.editar(libro);
            System.out.println("Libro editado correctamente.");
            return libro;
        } catch (Exception e) {
            System.out.println("Error al editar el libro: " + e.getMessage());
            return null;
        }
    }

    public boolean eliminarPorISBN(Long isbn) {
        try {
            DAO.eliminar(isbn);
            System.out.println("Libro eliminado correctamente.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
            return false;
        }
    }

    public Libro buscarPorISBN(Long isbn) {
        try {
            return DAO.buscarPorIsbn(isbn);
        } catch (Exception e) {
            System.out.println("Error al buscar el libro por ISBN: " + e.getMessage());
            return null;
        }
    }

}
