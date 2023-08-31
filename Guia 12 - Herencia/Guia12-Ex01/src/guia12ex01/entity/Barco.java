/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ex01.entity;

/**
 *
 * @author Thiago
 */
public class Barco {

    protected String matricula;
    protected Double eslora;
    protected String anioFabricacion;
    
    protected Double valorModulo;

    public Barco() {
    }

    public Barco(String matricula, Double eslora, String anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
        this.valorModulo = 0d;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getEslora() {
        return eslora;
    }

    public void setEslora(Double eslora) {
        this.eslora = eslora;
    }

    public String getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(String anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public Double getValorModulo() {
        return valorModulo;
    }

    public void setValorModulo(Double valorModulo) {
        this.valorModulo = valorModulo;
    }
    
    public void calcularValorModulo() {
        this.valorModulo = this.eslora * 10;
        System.out.println(this.valorModulo);
    }

}
