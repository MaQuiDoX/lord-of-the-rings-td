package Enemigo;

import Celda.CeldaCamino;
import Juego.Juego;

/**
 * Una clase que genera un enemigo hobbit.
 * @version 1.1 19/9/23
 * @author Ezequiel L. Martins
 */
public class Hobbit extends Enemigo{
    /**
     * Constructor de Hobbit. Vida: 40 || Dano: 1 || Velocidad: 2 || Magia Otorgada: 5 || Tipo: ligera
     * @param juego Objeto Juego en donde estara viviendo el enemigo.
     * @param celdaCamino Objeto CeldaCamino en donde se ubicará dentro de la oleada.
     */
    public Hobbit(Juego juego, CeldaCamino celdaCamino){
        super(juego,40,1,2,5,"ligero",false, celdaCamino);
    }
}
