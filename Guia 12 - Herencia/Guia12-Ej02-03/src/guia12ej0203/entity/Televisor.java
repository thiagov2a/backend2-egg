/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ej0203.entity;

import guia12ej0203.enums.Consumo;

/**
 *
 * @author Thiago
 */
public final class Televisor extends Electrodomestico {

    private Double resolucion;
    private boolean sintonizadorTDT;

    public Televisor() {
    }

    public Televisor(Double resolucion, boolean sintonizadorTDT, String color, Consumo consumo, Double peso) {
        super(color, consumo, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public Double getResolucion() {
        return resolucion;
    }

    public void setResolucion(Double resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public void crearTelevisor() {
        super.crearElectrodomestico();

        System.out.println("===== RESOLUCIÓN =====");
        do {
            System.out.print("Ingrese las pulgadas del televisor.\n> ");
            this.resolucion = validarDouble();
        } while (this.resolucion <= 0d);

        System.out.println("===== SINTONIZADOR TDT =====");
        String opc;
        do {
            System.out.print("¿El televisor tiene sintonizador TDT? (s/n)\n> ");
            opc = validarString();
        } while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n"));

        this.sintonizadorTDT = opc.equalsIgnoreCase("s");
    }

    @Override
    public void precioFinal() {
        super.precioFinal();
        if (resolucion > 40) {
            this.precio *= 1.3;
        }
        if (sintonizadorTDT) {
            this.precio += 500d;
        }
        System.out.println("===== PRECIO FINAL =====");
        System.out.println("El precio final del televisor es de $" + this.precio);
    }

}
