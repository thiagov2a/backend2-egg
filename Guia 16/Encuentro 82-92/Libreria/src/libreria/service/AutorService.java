package libreria.service;

import libreria.entity.Autor;
import libreria.persistence.AutorDAO;

/**
 *
 * @author Thiago
 */
public class AutorService {

    private final AutorDAO DAO;

    public AutorService() {
        this.DAO = new AutorDAO();
    }

    public Autor crearAutor(String nombre) {
        Autor autor = new Autor();
        try {
            validarCrearAutor(nombre);
            autor.setNombre(nombre);
            DAO.guardar(autor);
            System.out.println("Autor guardado correctamente.");
            return autor;
        } catch (Exception e) {
            System.out.println("Error al crear el autor: " + e.getMessage());
            return null;
        }
    }

    public Autor editarAutor(Autor autor) {
        try {
            validarEditarAutor(autor);
            DAO.editar(autor);
            System.out.println("Autor editado correctamente.");
            return autor;
        } catch (Exception e) {
            System.out.println("Error al editar el autor: " + e.getMessage());
            return null;
        }
    }

    public boolean eliminarPorId(Integer id) {
        try {
            validarId(id);
            DAO.eliminar(id);
            System.out.println("Autor eliminado correctamente.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el autor por ID: " + e.getMessage());
            return false;
        }
    }

    public Autor buscarPorId(Integer id) {
        try {
            validarId(id);
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println("Error al buscar el autor por ID: " + e.getMessage());
            return null;
        }
    }
    
    public Autor buscarPorNombre(String nombre) {
        try {
            validarNombre(nombre);
            return DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println("Error al buscar autor por nombre: " + e.getMessage());
            return null;
        }
    }

    private void validarCrearAutor(String nombre) {
        if (buscarPorNombre(nombre) != null) {
            throw new IllegalArgumentException("El Autor ya existe en la base de datos.");
        }
        
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor es requerido.");
        }
    }

    private void validarEditarAutor(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("El libro es nulo.");
        }

        if (autor.getNombre() == null || autor.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El título del libro es requerido.");
        }
    }

    private void validarId(Integer id) {
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
