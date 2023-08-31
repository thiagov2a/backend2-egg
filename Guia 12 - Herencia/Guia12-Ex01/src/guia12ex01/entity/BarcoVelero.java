/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia12ex01.entity;

/**
 *
 * @author Thiago
 */
public final class BarcoVelero extends Barco {
 
    private Integer mastiles;

    public BarcoVelero() {
    }

    public BarcoVelero(Integer mastiles, String matricula, Double eslora, String anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.mastiles = mastiles;
    }

    public Integer getMastiles() {
        return mastiles;
    }

    public void setMastiles(Integer mastiles) {
        this.mastiles = mastiles;
    }
    
    @Override
    public void calcularValorModulo() {
        super.calcularValorModulo();
        this.valorModulo += this.mastiles;
        System.out.println(this.valorModulo);
    }
    
}
