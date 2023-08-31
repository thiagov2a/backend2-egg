/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia12ex01;

import guia12ex01.entity.Alquiler;
import guia12ex01.entity.BarcoYate;
import java.util.Date;

/**
 *
 * @author Thiago
 */
public class Guia12Ex01Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Date fechaAlquiler = new Date(2023 - 1900, 5 - 1, 31);
        Date fechaDevolucion = new Date(2023 - 1900, 6 - 1, 31);
        
        BarcoYate by = new BarcoYate(4, 30d, "NOSE12", 25d, "25/4/97");
        
        Alquiler a = new Alquiler("Thiago", 12345, fechaAlquiler, fechaDevolucion, 4, by);  
        
        a.calcularDiasOcupacion();
        by.calcularValorModulo();
        a.calcularAlquiler();
    }

}
