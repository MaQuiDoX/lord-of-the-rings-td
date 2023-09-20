package Enemigo;

import Celda.CeldaCamino;
import Juego.Juego;

/**
 * Una clase que genera un enemigo elfo.
 * @version 1.1 19/9/23
 * @author Ezequiel L. Martins
 */
public class Elfo extends Enemigo{
    /**
     * Constructor de Elfo. Vida: 210 || Dano: 3 || Velocidad: 4 || Magia Otorgada: 30 || Tipo: ligero
     * @param juego Objeto Juego en donde estara viviendo el enemigo.
     * @param celdaCamino Objeto CeldaCamino en donde se ubicara dentro de la oleada.
     */
    public Elfo(Juego juego, CeldaCamino celdaCamino){
        super(juego, 210,3,4,30,"ligero",false, celdaCamino);
    }
}