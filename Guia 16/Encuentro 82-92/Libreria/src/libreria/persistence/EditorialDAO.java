package libreria.persistence;

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

}
