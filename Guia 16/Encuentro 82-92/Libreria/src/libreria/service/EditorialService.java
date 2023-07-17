package libreria.service;

import libreria.entity.Editorial;
import libreria.persistence.EditorialDAO;

/**
 *
 * @author Thiago
 */
public class EditorialService {

    private final EditorialDAO editorialDAO;

    public EditorialService() {
        this.editorialDAO = new EditorialDAO();
    }

    public Editorial crearEditorial(String nombre) {
        validarNombreEditorial(nombre);
        validarExistenciaEditorial(nombre);
        try {
            Editorial editorial = new Editorial(nombre);
            editorialDAO.guardar(editorial);
            System.out.println("Editorial creada correctamente.");
            return editorial;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear la editorial: " + e.getMessage());
            return null;
        }
    }

    public Editorial editarEditorial(Editorial editorial) {
        validarEditorial(editorial);
        try {
            editorialDAO.editar(editorial);
            System.out.println("Editorial editada correctamente.");
            return editorial;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al editar la editorial: " + e.getMessage());
            return null;
        }
    }

    public boolean eliminarPorID(Integer id) {
        validarID(id);
        try {
            editorialDAO.eliminar(id);
            System.out.println("Editorial eliminada correctamente.");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al eliminar la editorial: " + e.getMessage());
            return false;
        }
    }

    public Editorial buscarPorID(Integer id) {
        validarID(id);
        try {
            return editorialDAO.buscarPorID(id);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al buscar la editorial por ID: " + e.getMessage());
            return null;
        }
    }

    public Editorial buscarPorNombre(String nombre) {
        validarNombreEditorial(nombre);
        try {
            return editorialDAO.buscarPorNombre(nombre);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al buscar la editorial por nombre: " + e.getMessage());
            return null;
        }
    }

    private void validarNombreEditorial(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la editorial es requerido.");
        }
    }

    private void validarExistenciaEditorial(String nombre) {
        Editorial editorialExistente = editorialDAO.buscarPorNombre(nombre);
        if (editorialExistente != null) {
            throw new IllegalArgumentException("La editorial ya existe en la base de datos.");
        }
    }

    private void validarEditorial(Editorial editorial) {
        if (editorial == null) {
            throw new IllegalArgumentException("La editorial es nula.");
        }

        if (editorial.getNombre() == null || editorial.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la editorial es requerido.");
        }
    }

    private void validarID(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID es requerido.");
        }
    }

}
