package Celda;

import Enemigo.Enemigo;
import java.util.ArrayList;
import Barricada.Barricada;

public class CeldaCamino extends Celda{
    private ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
    private Barricada barricada = null;
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

    public Celda getSiguienteCelda() {
        return this.siguienteCelda;
    }
    public ArrayList<Enemigo> getListaEnemigos(){
        return listaEnemigos;
    }

    public Barricada getBarricada(){
        return barricada;
    }
    public void setBarricada(Barricada barricada){
        this.barricada=barricada;
    }
    //public Boolean hayBarricada(){
      //  Boolean b1 = new Boolean(false);
        //if
    //}
}
