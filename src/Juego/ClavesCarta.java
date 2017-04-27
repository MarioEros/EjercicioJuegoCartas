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
public enum ClavesCarta {
    AS ("1",1),
    DOS("2",2),
    TRES("3",3),
    CUATRO("4",4),
    CINCO("5",5),
    SEIS("6",6),
    SIETE("7",7),
    OCHO("8",8),
    NUEVE("9",9),
    DIEZ("0",10),
    JACK("j",10),
    QUEEN("q",10),
    KING("k",10),
    SOTA("s",0.5f),
    CABALLO("c",0.5f),
    REY("r",0.5f);
    
    private String num;
    private float valor;
    
    private ClavesCarta(String num, float val){
        this.num=num;
        this.valor=val;
    }
    
    public static float devolverValor(String num){
        for(ClavesCarta una:values()){
            if (una.num.equalsIgnoreCase(num))return una.valor;
        }
        return 0f;
    }
}
