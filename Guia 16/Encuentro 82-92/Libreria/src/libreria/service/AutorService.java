package libreria.service;

import libreria.entity.Autor;
import libreria.persistence.AutorDAO;

/**
 *
 * @author Thiago
 */
public class AutorService {

    private final AutorDAO autorDAO;

    public AutorService() {
        this.autorDAO = new AutorDAO();
    }

    public Autor crearAutor(String nombre) {
        validarNombre(nombre);
        validarExistenciaAutor(nombre);
        try {
            Autor autor = new Autor(nombre);
            autorDAO.guardar(autor);
            System.out.println("Autor creado correctamente.");
            return autor;
        } catch (Exception e) {
            System.out.println("Error al crear el autor: " + e.getMessage());
            return null;
        }
    }

    public Autor editarAutor(Autor autor) {
        validarAutor(autor);
        try {
            autorDAO.editar(autor);
            System.out.println("Autor editado correctamente.");
            return autor;
        } catch (Exception e) {
            System.out.println("Error al editar el autor: " + e.getMessage());
            return null;
        }
    }

    public boolean eliminarPorID(Integer id) {
        validarID(id);
        try {
            autorDAO.eliminar(id);
            System.out.println("Autor eliminado correctamente.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el autor por ID: " + e.getMessage());
            return false;
        }
    }

    public Autor buscarPorID(Integer id) {
        validarID(id);
        try {
            return autorDAO.buscarPorID(id);
        } catch (Exception e) {
            System.out.println("Error al buscar el autor por ID: " + e.getMessage());
            return null;
        }
    }

    public Autor buscarPorNombre(String nombre) {
        validarNombre(nombre);
        try {
            return autorDAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println("Error al buscar autor por nombre: " + e.getMessage());
            return null;
        }
    }

    private void validarAutor(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("El autor es nulo.");
        }

        if (autor.getNombre() == null || autor.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor es requerido.");
        }
    }

    private void validarExistenciaAutor(String nombre) {
        Autor autorExistente = autorDAO.buscarPorNombre(nombre);
        if (autorExistente != null) {
            throw new IllegalArgumentException("El autor ya existe en la base de datos.");
        }
    }

    private void validarID(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID es requerido.");
        }
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor es requerido.");
        }
    }

}
