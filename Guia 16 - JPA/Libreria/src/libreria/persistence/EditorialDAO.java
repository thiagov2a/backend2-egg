package libreria.persistence;

import javax.persistence.NoResultException;
import libreria.entity.Editorial;

/**
 *
 * @author Thiago
 */
public final class EditorialDAO extends DAO<Editorial> {

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }

    @Override
    public void editar(Editorial editorial) {
        super.editar(editorial);
    }

    public void eliminar(Integer id) {
        Editorial editorial = buscarPorID(id);
        super.eliminar(editorial);
    }

    public Editorial buscarPorID(Integer id) {
        try {
            conectar();
            Editorial editorial = em.find(Editorial.class, id);
            if (editorial == null) {
                throw new IllegalArgumentException("No se encontró ninguna editorial con el ID: " + id);
            }
            return editorial;
        } finally {
            desconectar();
        }
    }

    public Editorial buscarPorNombre(String nombre) {
        try {
            conectar();
            return em.createQuery("SELECT e "
                    + "FROM Editorial e "
                    + "WHERE e.nombre LIKE :nombre", Editorial.class)
                    .setParameter("nombre", "%" + nombre + "%")
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new IllegalArgumentException("No se encontró ninguna editorial.");
        } finally {
            desconectar();
        }
    }

}
