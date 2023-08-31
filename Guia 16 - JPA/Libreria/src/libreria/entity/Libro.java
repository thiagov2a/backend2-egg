package libreria.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Thiago
 */
@Entity
@Table(name = "libros", uniqueConstraints = @UniqueConstraint(columnNames = {"titulo", "autor_id", "editorial_id"}))
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbn")
    private Long isbn;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "año")
    private Integer año;

    @Column(name = "ejemplares")
    private Integer ejemplares;

    @Column(name = "ejemplares_prestados")
    private Integer ejemplaresPrestados;

    @Column(name = "ejemplares_restantes")
    private Integer ejemplaresRestantes;

    @Column(name = "alta")
    private Boolean alta;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    public Libro() {
    }

    public Libro(String titulo, Integer año, Integer ejemplares, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.año = año;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = 0; // Cuando creamos un nuevo libro no hay ejemplares prestados
        this.ejemplaresRestantes = ejemplares; // Cuando creamos un nuevo libro los ejemplares restantes son los mismos que los ejemplares
        this.alta = true;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{"
                + "isbn=" + isbn
                + ", titulo='" + titulo + '\''
                + ", año=" + año
                + ", ejemplares=" + ejemplares
                + ", ejemplaresPrestados=" + ejemplaresPrestados
                + ", ejemplaresRestantes=" + ejemplaresRestantes
                + ", alta=" + alta
                + ", autor=" + (autor != null ? autor.getNombre() : null)
                + ", editorial=" + (editorial != null ? editorial.getNombre() : null)
                + '}';
    }

}
