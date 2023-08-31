/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ej01;

import guia11ej01.service.PersonaService;

/**
 *
 * @author Thiago
 */
public class Guia11Ej01Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaService service = new PersonaService();
        service.crearPersonas();
        service.mostrarPersonas();
    }
    
}
