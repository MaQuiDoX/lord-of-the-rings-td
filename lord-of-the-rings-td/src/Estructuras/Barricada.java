package Estructuras;

import Celda.CeldaCamino;

/**
 * Una clase que representa a una barricada, un medio de defensa que detiene el avance de los atacantes.
 * @version 1.0 18/9/23 *
 * @author Ezequiel L. Martins *
 */
public class Barricada {
    private int vida = 0;
    private int coste = 0;
    private int costeMejora = 0;
    private int nivel = 0;
    private CeldaCamino celdaAsociada = null;

    /**
     * Constructor de cerro, recibiendo como parametro la CeldaCamino donde se encuentra.
     * @param vida
     * -------------------------------
     * RELLENAR Y/O CAMBIAR PARAMETROS
     * -------------------------------
     * @param celdaCamino Celda en la cual se encuentra dentro del mapa.
     * @see CeldaCamino
     */
    public Barricada(int vida, int coste, int nivel, CeldaCamino celdaCamino) {
        this.vida = 10;
        this.coste = 0;
        this.costeMejora = 0;
        this.nivel = 1;
        this.celdaAsociada = celdaCamino;
    }

    /**
     * Getter de la vida.
     * @return Devuelve un int de la vida actual de la barricada.
     */
    public int getVida() {
        return this.vida;
    }
    /**
     * Setter de la vida.
     * @param vida Nuevo valor para la vida de la barricada.
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * D
     * @see CeldaCamino
     */
    public void destruirse() {
        this.celdaAsociada.setBarricada(null);
    }

    public int getNivel(){
        return nivel;
    }
    public void setNivel(int nivel){
        this.nivel=nivel;
    }
}
