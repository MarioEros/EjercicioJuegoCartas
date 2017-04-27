/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

/**
 *
 * @author Yossy
 */
public class Jugador {
    private String nombre;
    private float puntos=0;
    
    public Jugador(String nombre){
        this.nombre=nombre.toLowerCase();
        this.nombre=this.nombre.substring(0, 1).toUpperCase()+this.nombre.substring(1);
    }

    public String getNombre() {
        return nombre;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }
    
    public void sumaPuntos(float punto){
        this.puntos=puntos+punto;
    }
    
    
    public float devuelveSumaCartas(){
        return puntos;
    }
}
