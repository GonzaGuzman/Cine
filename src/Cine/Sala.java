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
public class Sala {
    private Integer numeroSala;
    private Butaca[][] lugares;
    private Pelicula enCartelera;
    private Integer cantidadDeButacasMax;
    private Integer butacasReservadas;
    private Float precioEntrada;

    public Sala() {
    }

    public Sala(Integer numeroSala, Butaca[][] lugares, Pelicula enCartelera, Integer cantidadDeButacasMax, Integer butacasReservadas, Float precioEntrada) {
        this.numeroSala = numeroSala;
        this.lugares = lugares;
        this.enCartelera = enCartelera;
        this.cantidadDeButacasMax = cantidadDeButacasMax;
        this.butacasReservadas = butacasReservadas;
        this.precioEntrada = precioEntrada;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public Butaca[][] getLugares() {
        return lugares;
    }

    public void setLugares(Butaca[][] lugares) {
        this.lugares = lugares;
    }

    public Pelicula getEnCartelera() {
        return enCartelera;
    }

    public void setEnCartelera(Pelicula enCartelera) {
        this.enCartelera = enCartelera;
    }

    public Integer getCantidadDeButacasMax() {
        return cantidadDeButacasMax;
    }

    public void setCantidadDeButacasMax(Integer cantidadDeButacasMax) {
        this.cantidadDeButacasMax = cantidadDeButacasMax;
    }

    public Integer getButacasReservadas() {
        return butacasReservadas;
    }

    public void setButacasReservadas(Integer butacasReservadas) {
        this.butacasReservadas = butacasReservadas;
    }

    public Float getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(Float precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    
    @Override
    public String toString() {
        return  "\n Cartelera: " + enCartelera + "\n CANTIDAD DE BUTACAS: " + cantidadDeButacasMax + "\n BUTACAS RESERVADAS: " + butacasReservadas + "\n PRECIO ENTRADA: $" + precioEntrada;
    }

}