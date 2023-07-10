package libreria.service;

import libreria.entity.Autor;
import libreria.entity.Editorial;
import libreria.entity.Libro;
import libreria.persistence.LibroDAO;

/**
 *
 * @author Thiago
 */
public class LibroService {
    
    private LibroDAO DAO;
    
    public LibroService() {
        this.DAO = new LibroDAO();
    }
    
    public Libro crearLibro(String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) {
        Libro libro = new Libro();
        try {
            libro.setTitulo(titulo);
            
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
