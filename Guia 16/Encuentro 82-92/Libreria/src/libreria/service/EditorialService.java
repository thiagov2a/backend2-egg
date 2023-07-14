package libreria.service;

import libreria.entity.Editorial;
import libreria.persistence.EditorialDAO;

/**
 *
 * @author Thiago
 */
public class EditorialService {

    private final EditorialDAO DAO;

    public EditorialService() {
        this.DAO = new EditorialDAO();
    }

    public Editorial crearEditorial(String nombre) {
        Editorial editorial = new Editorial();
        try {
            validarCrearEditorial(nombre);
            editorial.setNombre(nombre);
            DAO.guardar(editorial);
            System.out.println("Editorial guardada correctamente.");
            return editorial;
        } catch (Exception e) {
            System.out.println("Error al crear la editorial: " + e.getMessage());
            return null;
        }
    }

    public Editorial editarEditorial(Editorial editorial) {
        try {
            validarEditarEditorial(editorial);
            DAO.editar(editorial);
            System.out.println("Editorial editada correctamente.");
            return editorial;
        } catch (Exception e) {
            System.out.println("Error al editar la editorial: " + e.getMessage());
            return null;
        }
    }

    public boolean eliminarPorId(Integer id) {
        try {
            validarId(id);
            DAO.eliminar(id);
            System.out.println("Editorial eliminada correctamente.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar la editorial por ID: " + e.getMessage());
            return false;
        }
    }

    public Editorial buscarPorId(Integer id) {
        try {
            validarId(id);
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println("Error al buscar la editorial por ID: " + e.getMessage());
            return null;
        }
    }
    
    public Editorial buscarPorNombre(String nombre) {
        try {
            
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void validarCrearEditorial(String nombre) {
        if
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor es requerido.");
        }
    }

    private void validarEditarEditorial(Editorial editorial) {
        if (editorial == null) {
            throw new IllegalArgumentException("El libro es nulo.");
        }

        if (editorial.getNombre() == null || editorial.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El título del libro es requerido.");
        }
    }

    private void validarId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID es requerido.");
        }
    }

}
