package libreria.persistence;

import javax.persistence.NoResultException;
import libreria.entity.Autor;
import libreria.entity.Editorial;
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
        Libro libro = buscarPorISBN(isbn);
        super.eliminar(libro);
    }

    public Libro buscarPorISBN(Long isbn) {
        try {
            conectar();
            Libro libro = em.find(Libro.class, isbn);
            return libro;
        } finally {
            desconectar();
        }
    }

    public Libro buscarPorTituloAutorEditorial(String titulo, Autor autor, Editorial editorial) {
        try {
            conectar();
            Libro libro = null;
            try {
                libro = (Libro) em.createQuery("SELECT l "
                        + "FROM Libro l "
                        + "WHERE l.titulo = :titulo "
                        + "AND l.autor = :autor "
                        + "AND l.editorial = :editorial")
                        .setParameter("titulo", titulo)
                        .setParameter("autor", autor)
                        .setParameter("editorial", editorial)
                        .getSingleResult();
            } catch (NoResultException e) {
                throw new IllegalArgumentException("No se encontró ningún libro.");
            }
            return libro;
        } finally {
            desconectar();
        }
    }

}
