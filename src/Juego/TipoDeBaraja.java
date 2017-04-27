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
public enum TipoDeBaraja {
    ESPANNOLA("Siete y Media","o1,o2,o3,o4,o5,o6,o7,os,oc,or,c1,c2,c3,c4,c5,c6,c7,cs,cc,cr,e1,e2,e3,e4,e5,e6,e7,es,ec,er,b1,b2,b3,b4,b5,b6,b7,bs,bc,br",7.5f),
    FRANCESA("BlackJack","p1,p2,p3,p4,p5,p6,p7,p8,p9,p0,pj,pq,pk,c1,c2,c3,c4,c5,c6,c7,c8,c9,c0,cj,cq,ck,t1,t2,t3,t4,t5,t6,t7,t8,t9,t0,tj,tq,tk,d1,d2,d3,d4,d5,d6,d7,d8,d9,d0,dj,dq,dk",21f);
    private String nombre;
    private String archivosImagen;
    private float limite;
    
    private TipoDeBaraja(String nombre, String anverso, float limite){
        this.nombre=nombre;
        this.archivosImagen=anverso;
        this.limite=limite;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArchivosImagen() {
        return archivosImagen;
    }

    public float getLimite() {
        return limite;
    }
    
    public String[] archivosDeCarta(TipoDeBaraja baraja){
        return baraja.archivosImagen.split(",");
    }
    
    public int numeroDeCartas(TipoDeBaraja baraja){
        return baraja.archivosImagen.split(",").length;
    }
    
    
    public static String[] nombresBaraja() {
        String[] devolver=new String[values().length];
        int cont=0;
        for (TipoDeBaraja uno:values()){
            devolver[cont]=uno.nombre;
            cont++;
        }
        return devolver;
    }
  
    public static TipoDeBaraja devuelveBaraja(String nombre){
        for (TipoDeBaraja uno:values()){
            if(nombre.equals(uno.nombre))return uno;
        }
        return null;
    }
}
