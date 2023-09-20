package Estructuras;

import Celda.CeldaCamino;

/**
 * Una clase que representa a una barricada, un medio de defensa que detiene el avance de los atacantes.
 * @version 1.1 19/9/23 *
 * @author Ezequiel L. Martins *
 */
public class Barricada {
    private int vida;
    private int nivel;
    private CeldaCamino celdaAsociada = null;

    /**
     * Constructor de cerro.
     * @param celdaCamino Objeto CeldaCamino en la cual se encuentra la barricada en el mapa.
     * @see CeldaCamino
     */
    public Barricada(CeldaCamino celdaCamino) {
        this.vida = 20;
        this.nivel = 1;
        this.celdaAsociada = celdaCamino;
    }

    /**
     * Getter de vida.
     * @return Devuelve un int de la vida actual de la barricada.
     */
    public int getVida() {
        return this.vida;
    }
    /**
     * Setter de vida.
     * @param vida Nuevo valor para la vida de la barricada.
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Getter de nivel.
     * @return Devuelve un int con el nivel actual de la barricada.
     */
    public int getNivel(){
        return nivel;
    }
    /**
     * Setter de nivel.
     * @param nivel Nuevo valor para el nivel de la barricada.
     */
    public void setNivel(int nivel){
        this.nivel=nivel;
    }

    /**
     * Método que sirve para eliminar la barricada de una CeldaCamino .
     * @see CeldaCamino
     */
    public void destruirse() {
        this.celdaAsociada.setBarricada(null);
    }
}
