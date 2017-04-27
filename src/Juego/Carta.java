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
public class Carta {
    
    private String nombre;
    private float valor;
    
    public Carta (String nombre){
        this.nombre=nombre;
        setValor();
    }
    
    public String getImagen(){
        return nombre+".jpg";
    }
    
    public float getValor(){
        return valor;
    }
    
    public void setValor(){
        this.valor=ClavesCarta.devolverValor(nombre.substring(1));
    }
}
