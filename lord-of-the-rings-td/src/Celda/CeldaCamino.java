package Celda;

import Enemigo.Enemigo;

import Barricada.Barricada;

import java.util.ArrayList;

public class CeldaCamino extends Celda{
    private ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
    private int[] posicionEnemigo;
    private Barricada barricada;
    private Celda siguienteCelda;

    public CeldaCamino(){
        this.listaEnemigos = null;
        this.posicionEnemigo = null;
        this.barricada = null;
        this.siguienteCelda = null;
    }
    public CeldaCamino(Celda siguienteCelda){
        this.siguienteCelda=siguienteCelda;
    }

    public void nuevoEnemigo(Enemigo enemigo){
        listaEnemigos.add(enemigo);
    }
    public Boolean sacarEnemigo(Enemigo enemigo) {
        Boolean b1 = listaEnemigos.contains(enemigo);
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
    public Barricada getBarricada(){return this.barricada;}
    public void setBarricada(Barricada barricada){this.barricada = barricada;}
}
