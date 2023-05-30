/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ej02.entity;

import guia12ej02.enums.Consumo;

/**
 *
 * @author Thiago
 */
public final class Televisor extends Electrodomestico {

    private Double resolucion;
    private boolean sintonizadorTDT;

    public Televisor() {
    }

    public Televisor(Double resolucion, boolean sintonizadorTDT, Double precio, String color, Consumo consumo, Double peso) {
        super(precio, color, consumo, peso);
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

        System.out.print("Ingrese las pulgadas del televisor.\n> ");
        this.resolucion = input.nextDouble();

        System.out.println("===== SINTONIZADOR TDT =====");

        System.out.print("¿El televisor tiene sintonizador TDT? (s/n)\n > ");
        String opc = input.next();
        this.sintonizadorTDT = opc.equals("s");
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
    }

}
