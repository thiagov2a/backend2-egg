package libreria.persistence;

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
        Autor autor = buscarPorId(id);
        super.eliminar(autor);
    }

    public Autor buscarPorId(Integer id) {
        try {
            conectar();
            Autor autor = em.find(Autor.class, id);
            return autor;
        } finally {
            desconectar();
        }
    }

}
