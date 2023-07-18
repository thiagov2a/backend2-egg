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

    private final LibroDAO libroDAO;

    public LibroService() {
        this.libroDAO = new LibroDAO();
    }

    public Libro crearLibro(String titulo, Integer año, Integer ejemplares, Autor autor, Editorial editorial) {
        validarCrearLibro(titulo, año, ejemplares, autor, editorial);
        try {
            Libro libro = new Libro(titulo, año, ejemplares, autor, editorial);
            autor.agregarLibro(libro);
            editorial.agregarLibro(libro);
            libroDAO.guardar(libro);
            System.out.println("Libro creado correctamente.");
            return libro;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el libro: " + e.getMessage());
            return null;
        }
    }

    public Libro editarLibro(Libro libro) {
        validarEditarLibro(libro);
        try {
            libroDAO.editar(libro);
            System.out.println("Libro editado correctamente.");
            return libro;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al editar el libro: " + e.getMessage());
            return null;
        }
    }

    public boolean eliminarPorISBN(Long isbn) {
        validarISBN(isbn);
        try {
            libroDAO.eliminar(isbn);
            System.out.println("Libro eliminado correctamente.");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
            return false;
        }
    }

    public Libro buscarPorISBN(Long isbn) {
        validarISBN(isbn);
        try {
            return libroDAO.buscarPorISBN(isbn);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al buscar el libro por ISBN: " + e.getMessage());
            return null;
        }
    }

    public Libro buscarPorTitulo(String titulo) {
        validarTitulo(titulo);
        try {
            return libroDAO.buscarPorTitulo(titulo);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al buscar el libro por título: " + e.getMessage());
            return null;
        }
    }

    public Libro buscarPorTituloAutorEditorial(String titulo, Autor autor, Editorial editorial) {
        validarTitulo(titulo);
        validarAutor(autor);
        validarEditorial(editorial);
        try {
            return libroDAO.buscarPorTituloAutorEditorial(titulo, autor, editorial);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al buscar el libro por título, autor y editorial: " + e.getMessage());
            return null;
        }
    }

    private void validarCrearLibro(String titulo, Integer año, Integer ejemplares, Autor autor, Editorial editorial) {
        validarTitulo(titulo);
        validarAño(año);
        validarEjemplares(ejemplares);
        validarAutor(autor);
        validarEditorial(editorial);
        validarExistenciaLibro(titulo, autor, editorial);
    }

    private void validarEditarLibro(Libro libro) {
        validarTitulo(libro.getTitulo());
        validarAño(libro.getAño());
        validarEjemplares(libro.getEjemplares());
        validarEjemplaresRestantes(libro.getEjemplares(), libro.getEjemplaresRestantes());
        validarAutor(libro.getAutor());
        validarEditorial(libro.getEditorial());
    }

    private void validarExistenciaLibro(String titulo, Autor autor, Editorial editorial) {
        Libro libroExistente = libroDAO.buscarPorTituloAutorEditorial(titulo, autor, editorial);
        if (libroExistente != null) {
            throw new IllegalArgumentException("El libro ya existe en la base de datos.");
        }
    }

    private void validarISBN(Long isbn) {
        if (isbn == null) {
            throw new IllegalArgumentException("El ISBN es requerido.");
        }
    }

    private void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título del libro es requerido.");
        }
    }

    private void validarAño(Integer año) {
        if (año == null || año < 0) {
            throw new IllegalArgumentException("El año del libro es inválido.");
        }
    }

    private void validarEjemplares(Integer ejemplares) {
        if (ejemplares == null || ejemplares < 1) {
            throw new IllegalArgumentException("La cantidad de ejemplares es inválida.");
        }
    }

    private void validarEjemplaresRestantes(Integer ejemplares, Integer ejemplaresRestantes) {
        if (ejemplares < ejemplaresRestantes) {
            throw new IllegalArgumentException("La cantidad de ejemplares no puede ser menor que la cantidad de ejemplares restantes.");
        }
    }

    private void validarAutor(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("El autor del libro es requerido.");
        }
    }

    private void validarEditorial(Editorial editorial) {
        if (editorial == null) {
            throw new IllegalArgumentException("La editorial del libro es requerida.");
        }
    }

}
