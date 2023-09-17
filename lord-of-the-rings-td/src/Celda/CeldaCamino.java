package Celda;

import Enemigo.Enemigo;

import java.util.ArrayList;

public class CeldaCamino extends Celda{
    private ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
    private Barricada barricada;
    private int[] PosicionEnemigo;
    private Celda siguienteCelda;

    public CeldaCamino(Celda siguienteCelda){
        this.siguienteCelda=siguienteCelda;
    }

    public void nuevoEnemigo(Enemigo enemigo){
        listaEnemigos.add(enemigo);
    }
    public Boolean SacarEnemigo(Enemigo enemigo) {
        Boolean b1=listaEnemigos.contains(enemigo);
        if (b1){
            listaEnemigos.remove(enemigo);
        }
        return b1;
    }

    public ArrayList<Enemigo> getListaEnemigos(){
        return listaEnemigos;
    }


    //public Boolean hayBarricada(){
      //  Boolean b1 = new Boolean(false);
        //if
    //}
}
