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

    public void eliminar(Long isbn) throws Exception {
        Libro libro = buscarPorIsbn(isbn);
        super.eliminar(libro);
    }

    public Libro buscarPorIsbn(Long isbn) throws Exception {
        conectar();
        Libro libro = em.find(Libro.class, isbn);
        desconectar();
        return libro;
    }

}
