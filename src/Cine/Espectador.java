/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

/**
 *
 * @author Rem
 */
public class Espectador {

    private String nombre;
    private int edad;
    private float billetera;

    public Espectador() {
    }

    public Espectador(String nombre, int edad, float billetera) {
        this.nombre = nombre;
        this.edad = edad;
        this.billetera = billetera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getBilletera() {
        return billetera;
    }

    public void setBilletera(float billetera) {
        this.billetera = billetera;
    }

    @Override
    public String toString() {
        return "NOMBRE: " + nombre + " - EDAD: " + edad + " - SALDO: $ " + billetera;
    }

}
