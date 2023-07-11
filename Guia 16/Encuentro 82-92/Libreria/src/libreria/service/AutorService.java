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
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println("Error al buscar el autor por ID: " + e.getMessage());
            return null;
        }
    }

}
