/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Service.PerroService;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PerroService service = new PerroService();
        ArrayList<String> perros = service.crearPerros();
        service.menuPerros(perros);
    }
    
}
