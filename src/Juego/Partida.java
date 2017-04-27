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
public class Partida {
    public Jugador banca;
    public Jugador jugador;
    public float limite;
    public boolean isJugador=true;
    public GestoraDeBarajas baraja;

    public Partida(Jugador banca, Jugador usuario, TipoDeBaraja baraja) {
        this.banca = banca;
        this.jugador = usuario;
        this.limite=baraja.getLimite();
        this.baraja=new GestoraDeBarajas(baraja);
    }
    
    public Jugador getBanca(){
        return banca;
    }
    
    public Jugador getJugador(){
        return jugador;
    }

    public float getLimite() {
        return limite;
    }
    
    public Carta obtenerOtraCarta(){
        Carta aSumar=baraja.devuelveCartaAleatoria();
        if(isJugador){
            if(baraja.getTipo().getNombre().equalsIgnoreCase(TipoDeBaraja.FRANCESA.getNombre()))blackJugador(aSumar);
            else jugador.sumaPuntos(aSumar.getValor());
        }else{
            if(baraja.getTipo().getNombre().equalsIgnoreCase(TipoDeBaraja.FRANCESA.getNombre()))blackBanca(aSumar);
            else banca.sumaPuntos(aSumar.getValor());
        }
        return aSumar;
    }
    private int contAsJug = 0;

    private void blackJugador(Carta cart) {
        float valor=cart.getValor();
        if (valor == 1f){
            contAsJug++;
            valor=11;
        }
        float total = jugador.devuelveSumaCartas()+valor;
        if (total>22&&contAsJug>0){
            jugador.setPuntos(total-10);
            contAsJug--;
        }else{
        jugador.setPuntos(total);
        }
    }
    private int contAsBan = 0;

    private void blackBanca(Carta cart) {
        float valor=cart.getValor();
        if (valor == 1f){
            contAsBan++;
            valor=11;
        }
        float total = banca.devuelveSumaCartas()+valor;
        if (total>22&&contAsBan>0){
            banca.setPuntos(total-10);
            contAsBan--;
        }else{
        banca.setPuntos(total);
        }
    }

    
    public String imagenCarta(){
        if (baraja.getTipo().getNombre().equalsIgnoreCase(TipoDeBaraja.ESPANNOLA.getNombre())){
            return "/imaes/";
        }else if(baraja.getTipo().getNombre().equalsIgnoreCase(TipoDeBaraja.FRANCESA.getNombre())){
            return "/imafr/";
        }
        return null;
    }
    
    public String comprobarCondicionVictoria(){
        String devolver=null;
        if(sePasaElJugador())devolver="Te has pasado, ¡Pierdes!";
        else if (jugador.devuelveSumaCartas()==21)devolver="Tienes BlackJack, ¡Ganas!";
        else if (banca.devuelveSumaCartas()==21)devolver="La banca tiene BlackJack, ¡Pierdes!";
        else if (sePasaLaBanca())devolver="La banca se ha pasado, ¡Ganas!";
        else if (isGanaLaBanca())devolver="¡La banca gana!";
        else if (isEmpateASieteYMedia())devolver="¡Habeis empatado!";
        return devolver;
    }
    
    public boolean sePasaElJugador(){
        return jugador.devuelveSumaCartas()>limite;
    }
    
    public boolean sePasaLaBanca(){
        return banca.devuelveSumaCartas()>limite;
    }
    
    public boolean isGanaLaBanca(){
        return banca.devuelveSumaCartas()>jugador.devuelveSumaCartas();
    }
    
    public boolean isEmpateASieteYMedia(){
        return jugador.devuelveSumaCartas()==7.5f&&banca.devuelveSumaCartas()==jugador.devuelveSumaCartas();
    }
}
