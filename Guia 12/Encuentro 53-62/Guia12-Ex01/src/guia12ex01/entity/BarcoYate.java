/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ex01.entity;

/**
 *
 * @author Thiago
 */
public final class BarcoYate extends BarcoVapor {

    private Integer camarotes;

    public BarcoYate() {
    }

    public BarcoYate(Integer camarotes) {
        this.camarotes = camarotes;
    }

    public BarcoYate(Integer camarotes, Double CV, String matricula, Double eslora, String anioFabricacion) {
        super(CV, matricula, eslora, anioFabricacion);
        this.camarotes = camarotes;
    }
    
    public Integer getCamarotes() {
        return camarotes;
    }

    public void setCamarotes(Integer camarotes) {
        this.camarotes = camarotes;
    }

    @Override
    public void calcularValorModulo() {
        super.calcularValorModulo();
        this.valorModulo += this.camarotes;
        System.out.println(this.valorModulo);
    }
    
    

}
