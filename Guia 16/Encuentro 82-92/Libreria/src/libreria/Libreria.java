package libreria;

import libreria.service.AutorService;

/**
 *
 * @author Thiago
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AutorService autorService = new AutorService();
        autorService.crearAutor("Diego", Boolean.TRUE);
    }

}
