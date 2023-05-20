/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ex02.service;

import guia11ex02.entity.Asiento;
import guia11ex02.entity.Sala;
import guia11ex02.enums.Columna;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class CineService {

    private final Scanner input;
    private final List<Sala> salas;

    public CineService() {
        this.input = new Scanner(System.in).useDelimiter("\n");
        this.salas = new ArrayList<>();
    }

    public void crearSala() {
        Sala sala = new Sala();
        Asiento[][] asientos = new Asiento[8][6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                String ubicacion = (8 - i) + Columna.values()[j].toString();
                asientos[i][j] = new Asiento(ubicacion);
            }
        }
        sala.setAsientos(asientos);

        for (Asiento[] fila : asientos) {
            for (Asiento asiento : fila) {
                System.out.print(asiento + "|");
            }
            System.out.println();
        }

    }

}
