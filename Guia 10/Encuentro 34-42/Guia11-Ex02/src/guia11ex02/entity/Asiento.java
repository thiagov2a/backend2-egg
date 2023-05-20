/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guia11ex02.entity;

/**
 *
 * @author Thiago
 */
public class Asiento {

    private String ubicacion;
    private Espectador espectador;

    public Asiento() {
    }

    public Asiento(String ubicacion) {
        this.ubicacion = ubicacion;
        this.espectador = null;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    @Override
    public String toString() {
        if (espectador != null) {
            return ubicacion + "X";
        } else {
            return ubicacion + " ";
        }
    }

}
