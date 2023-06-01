/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ex01.entity;

/**
 *
 * @author Thiago
 */
public class BarcoVapor extends Barco {

    private Double CV;

    public BarcoVapor() {
    }

    public BarcoVapor(Double CV, String matricula, Double eslora, String anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.CV = CV;
    }

    public Double getCV() {
        return CV;
    }

    public void setCV(Double CV) {
        this.CV = CV;
    }

    @Override
    public void calcularValorModulo() {
        super.calcularValorModulo();
        this.valorModulo += this.CV;
        System.out.println(this.valorModulo);
    }
    
    

}
