package Enemigo;

import Celda.CeldaCamino;
import Juego.Juego;

/**
 * Una clase que genera un enemigo enano.
 * @version 1.1 19/9/23
 * @author Ezequiel L. Martins
 */
public class Enano extends Enemigo{
    /**
     * Constructor de Enano. Vida: 320 || Dano: 3 || Velocidad: 6 || Magia Otorgada: 40 || Tipo: pesado
     * @param juego Objeto Juego en donde estara viviendo el enemigo.
     * @param celdaCamino Objeto CeldaCamino en donde se ubicará dentro de la oleada.
     */
    public Enano(Juego juego, CeldaCamino celdaCamino){
        super(juego,320,4,6,40,"pesado",false, celdaCamino);
    }
}