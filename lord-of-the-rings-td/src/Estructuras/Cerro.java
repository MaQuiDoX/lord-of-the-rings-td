package Estructuras;

import Celda.CeldaCamino;

/**
 * Una clase que representa al Cerro de la Gloria, estructura que debemos defender de los atacantes.
 * @version 1.0 18/9/23 *
 * @author Ezequiel L. Martins *
 */
public class Cerro{

    private int vida;

    /**
     * Constructor de cerro, recibiendo como parametro la CeldaCamino donde esta ubicado.
     * @see CeldaCamino
     */
    public Cerro(){
        this.vida = 100;
    }

    /**
     * Getter de la vida.
     * @return Devuelve un int de la vida actual del cerro.
     */
    public int getVida(){
        return vida;
    }
    /**
     * Setter de la vida.
     * @param vida Nuevo valor para la vida del cerro.
     */
    public void setVida(int vida){
        this.vida=vida;
    }
}
