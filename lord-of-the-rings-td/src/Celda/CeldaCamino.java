package Celda;

import Enemigo.Enemigo;
import java.util.ArrayList;
import Estructuras.Barricada;

/**
 * Una clase que representa las celdas por las cuales pueden avanzar los enemigos y/o haber estructuras del jugador.
 * @version 1.0 18/9/23 *
 * @author Ezequiel L. Martins *
 */
public class CeldaCamino extends Celda{
    private ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
    private Barricada barricada = null;
    private int[] PosicionEnemigo;
    private Celda siguienteCelda;

    /**
     * Constructor de CeldaCamino, recibiendo como parametro la CeldaCamino que le sigue.
     * @param siguienteCelda Celda en la cual se encuentra dentro del mapa.
     * -------------------------
     * ARREGLAR ESTE CONSTRUCTOR
     * -------------------------
     * @see CeldaCamino
     */
    public CeldaCamino(Celda siguienteCelda){
        super(1,1);
        this.siguienteCelda=siguienteCelda;
    }

    public CeldaCamino(Celda siguienteCelda, int coordenadaX, int coordenadaY){
        super(coordenadaX,coordenadaY);
        this.siguienteCelda=siguienteCelda;
    }

    /**
     * Getter de listaEnemigos.
     * @return Devuelve un ArrayList con los enemigos en esa CeldaCamino.
     */
    public ArrayList<Enemigo> getListaEnemigos(){
        return listaEnemigos;
    }
    /**
     * Añade un nuevo enemigo a listaEnemigos.
     * @param enemigo Recibe un objeto del tipo Enemigo para ser añadido.
     * @see Enemigo
     */
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



    public Barricada getBarricada(){
        return barricada;
    }
    public void setBarricada(Barricada barricada){
        this.barricada=barricada;
    }

}
