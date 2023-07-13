package libreria.persistence;

import libreria.entity.Libro;

/**
 *
 * @author Thiago
 */
public final class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    @Override
    public void editar(Libro libro) {
        super.editar(libro);
    }

    public void eliminar(Long isbn) {
        Libro libro = buscarPorIsbn(isbn);
        super.eliminar(libro);
    }

    public Libro buscarPorIsbn(Long isbn) {
        try {
            conectar();
            Libro libro = em.find(Libro.class, isbn);
            return libro;
        } finally {
            desconectar();
        }
    }

}
