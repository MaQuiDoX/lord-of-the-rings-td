package Enemigo;

import Celda.CeldaCamino;
import Juego.Juego;

/**
 * Una clase que genera un enemigo humano.
 * @version 1.1 19/9/23
 * @author Ezequiel L. Martins
 */
public class Humano extends Enemigo{
    /**
     * Constructor de Humano. Vida: 100 || Dano: 2 || Velocidad: 4 || Magia Otorgada: 15 || Tipo: normal
     * @param juego Objeto Juego en donde estara viviendo el enemigo.
     * @param celdaCamino Objeto CeldaCamino en donde se ubicara dentro de la oleada.
     */
    public Humano(Juego juego, CeldaCamino celdaCamino){
        super(juego, 100,2,4,15,"normal",false, celdaCamino);
    }
}
