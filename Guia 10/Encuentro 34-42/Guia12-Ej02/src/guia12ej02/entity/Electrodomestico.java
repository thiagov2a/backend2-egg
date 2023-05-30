/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ej02.entity;

import guia12ej02.enums.Color;
import guia12ej02.enums.Consumo;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class Electrodomestico {

    protected Double precio;
    protected String color;
    protected Consumo consumo;
    protected Double peso;
    protected Scanner input;

    public Electrodomestico() {
        this.input = new Scanner(System.in).useDelimiter("\n");
    }

    public Electrodomestico(Double precio, String color, Consumo consumo, Double peso) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void crearElectrodomestico() {
        System.out.println("===== CONSUMO ENERGETICO =====");

        for (int i = 0; i < Consumo.values().length; i++) {
            System.out.println((i + 1) + ". " + Consumo.values()[i].toString());
        }

        System.out.print("Elija una opción: ");
        Integer opcConsumo = validarEntero();

        comprobarConsumoEnergetico(opcConsumo);

        System.out.println("===== COLOR =====");

        for (int i = 0; i < Color.values().length; i++) {
            System.out.println((i + 1) + ". " + Color.values()[i].getValor());
        }

        System.out.print("Elija una opción: ");
        Integer opcColor = validarEntero();

        comprobarColor(opcColor);

        System.out.println("===== PESO =====");

        do {
            System.out.print("Ingrese peso del electrodomestico.\n> ");
            this.peso = validarDouble();
        } while (this.peso > 0);

        System.out.println("===== SUBPRECIO =====");
        System.out.println("El subprecio del electrodomestico es de $1000.");
        this.precio = 1000d;
    }

    public void precioFinal() {
        if (this.peso >= 1 && this.peso <= 19) {
            this.precio += (this.consumo.getPrecio() + 100d);
        }
        if (this.peso >= 20 && this.peso <= 49) {
            this.precio += (this.consumo.getPrecio() + 500d);
        }
        if (this.peso >= 50 && this.peso <= 79) {
            this.precio += (this.consumo.getPrecio() + 800d);
        }
        if (this.peso >= 80) {
            this.precio += (this.consumo.getPrecio() + 1000d);
        }
    }
    
    private void comprobarConsumoEnergetico(Integer opc) {
        switch (opc) {
            case 1:
                this.consumo = Consumo.A;
                break;
            case 2:
                this.consumo = Consumo.B;
                break;
            case 3:
                this.consumo = Consumo.C;
                break;
            case 4:
                this.consumo = Consumo.D;
                break;
            case 5:
                this.consumo = Consumo.E;
                break;
            default:
                this.consumo = Consumo.F;
                break;
        }
    }

    private void comprobarColor(Integer opc) {
        switch (opc) {
            case 1:
                this.color = Color.NEGRO.getValor();
                break;
            case 2:
                this.color = Color.ROJO.getValor();
                break;
            case 3:
                this.color = Color.AZUL.getValor();
                break;
            case 4:
                this.color = Color.GRIS.getValor();
                break;
            default:
                this.color = Color.BLANCO.getValor();
                break;
        }
    }
    
    public int validarEntero() {
        while (true) {
            try {
                return Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número entero válido.\n> ");
            }
        }
    }

    public double validarDouble() {
        while (true) {
            try {
                String entrada = input.next().replace(",", ".");
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido.\n> ");
            }
        }
    }

    public String validarString() {
        String entrada = input.next();
        while (entrada.isEmpty()) {
            System.out.print("Ingrese un valor válido.\n> ");
            entrada = input.next();
        }
        return entrada;
    }

}
