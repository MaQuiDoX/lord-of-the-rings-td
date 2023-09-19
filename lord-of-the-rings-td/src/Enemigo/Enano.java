package Enemigo;

import Celda.CeldaCamino;
import Juego.Juego;

/**
 * Una clase que genera un enemigo enano del tipo 'pesado'.
 * @version 1.0 18/9/23
 * @author Ezequiel L. Martins
 */
public class Enano extends Enemigo{
    public Enano(Juego juego, CeldaCamino celdaCamino){
        super(juego,320,3,5,12,"enano",false, celdaCamino);
    }
}