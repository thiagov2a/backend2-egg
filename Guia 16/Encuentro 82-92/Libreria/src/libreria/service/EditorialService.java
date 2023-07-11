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
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println("Error al buscar la editorial por ID: " + e.getMessage());
            return null;
        }
    }

}
