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
        Editorial editorial = buscarPorId(id);
        super.eliminar(editorial);
    }

    public Editorial buscarPorId(Integer id) {
        try {
            conectar();
            Editorial editorial = em.find(Editorial.class, id);
            return editorial;
        } finally {
            desconectar();
        }
    }
    
    public Editorial buscarPorNombre(String nombre) {
        try {
            conectar();
            Editorial editorial = null;
            try {
                editorial = (Editorial) em.createQuery("SELECT e "
                        + "FROM Editorial e "
                        + "WHERE e.nombre = :nombre")
                        .setParameter("nombre", nombre)
                        .getSingleResult();
            } catch (NoResultException e) {
                // No se encontró ningún autor
            }
            return editorial;
        } finally {
            desconectar();
        }
    }

}
