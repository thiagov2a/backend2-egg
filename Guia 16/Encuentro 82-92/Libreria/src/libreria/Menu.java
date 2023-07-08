package libreria;

import libreria.entity.Autor;
import libreria.service.AutorService;

/**
 *
 * @author Thiago
 */
public class Menu {

    private final AutorService autorService;

    public Menu() {
        this.autorService = new AutorService();
    }

    public void prueba() {
        /* autorService.crearAutor("Leonel", Boolean.TRUE);
        autorService.crearAutor("Joaquin", Boolean.TRUE);
        autorService.crearAutor("Thiago", Boolean.TRUE); */
        autorService.eliminarPorId(151);
        autorService.eliminarPorId(201);
    }

}
