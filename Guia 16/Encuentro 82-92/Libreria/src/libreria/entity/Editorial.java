package libreria.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Thiago
 */
@Entity
@Table(name = "editoriales", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "alta")
    private Boolean alta;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;

    public Editorial() {
    }

    public Editorial(String nombre) {
        this.nombre = nombre;
        this.alta = true;
        this.libros = new ArrayList();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        libro.setEditorial(this);
    }

    public void removerLibro(Libro libro) {
        libros.remove(libro);
        libro.setEditorial(null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Editorial{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", alta=" + alta
                + ", cantidadLibros=" + (libros != null ? libros.size() : 0)
                + '}';
    }

}
