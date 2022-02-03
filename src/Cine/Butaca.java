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
public class Butaca {
    private int numero;
    private char letraFila;
    private boolean ocupado;
    private Espectador reserva;
            
    public Butaca() {
    }

    public Butaca(int numero, char letraFila, boolean ocupado, Espectador reserva) {
        this.numero = numero;
        this.letraFila = letraFila;
        this.ocupado = ocupado;
        this.reserva = reserva;
    }
    
    public Butaca(int numero, char letraFila, boolean estado) {
        this.numero = numero;
        this.letraFila = letraFila;
        this.ocupado = estado;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Espectador getReserva() {
        return reserva;
    }

    public void setReserva(Espectador reserva) {
        this.reserva = reserva;
    }

    public Butaca(boolean estado) {
        this.ocupado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getLetraFila() {
        return letraFila;
    }

    public void setLetraFila(char letraFila) {
        this.letraFila = letraFila;
    }

    public boolean isEstado() {
        return ocupado;
    }

    public void setEstado(boolean estado) {
        this.ocupado = estado;
    }

    @Override
    public String toString() {
        
        return  ""+numero + ""+letraFila +""+(ocupado? "[ ]":"[x]");
    }
    
}
