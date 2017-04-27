/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Yossy
 */
public class GestoraDeBarajas extends ArrayList<Carta>{
    private TipoDeBaraja laBaraja;

    public GestoraDeBarajas(TipoDeBaraja laBaraja) {
        this.laBaraja = laBaraja;
        definirCartas();
    }
    
    private void definirCartas(){
        for(String carta:laBaraja.archivosDeCarta(laBaraja)){
            super.add(new Carta(carta));
        }
        Collections.shuffle(this);
    }

    public Carta devuelveCartaAleatoria() {
        Carta devolver = this.get(0);
        this.remove(0);
        return devolver;
    }

    public TipoDeBaraja getTipo() {
        return laBaraja;
    }
    
}
