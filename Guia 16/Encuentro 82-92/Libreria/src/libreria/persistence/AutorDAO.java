package libreria.persistence;

import javax.persistence.NoResultException;
import libreria.entity.Autor;

/**
 *
 * @author Thiago
 */
public final class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    @Override
    public void editar(Autor autor) {
        super.editar(autor);
    }

    public void eliminar(Integer id) {
        Autor autor = buscarPorID(id);
        super.eliminar(autor);
    }

    public Autor buscarPorID(Integer id) {
        try {
            conectar();
            Autor autor = em.find(Autor.class, id);
            return autor;
        } finally {
            desconectar();
        }
    }

    public Autor buscarPorNombre(String nombre) {
        try {
            conectar();
            Autor autor = null;
            try {
                autor = (Autor) em.createQuery("SELECT a "
                        + "FROM Autor a "
                        + "WHERE a.nombre = :nombre")
                        .setParameter("nombre", nombre)
                        .getSingleResult();
            } catch (NoResultException e) {
                // No se encontró ningún autor
            }
            return autor;
        } finally {
            desconectar();
        }
    }

}
