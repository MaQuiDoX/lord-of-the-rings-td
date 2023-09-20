package Enemigo;

import Celda.CeldaCamino;
import Juego.Juego;

/**
 * Una clase que genera un enemigo ent.
 * @version 1.1 19/9/23
 * @author Ezequiel L. Martins
 */
public class Ent extends Enemigo{
    /**
     * Constructor de Ent. Vida: 1200 || Dano: 10 || Velocidad: 10 || Magia Otorgada: 200 || Tipo: pesado
     * @param juego Objeto Juego en donde estara viviendo el enemigo.
     * @param celdaCamino Objeto CeldaCamino en donde se ubicará dentro de la oleada.
     */
    public Ent(Juego juego, CeldaCamino celdaCamino){
        super(juego,1200,10,10,200,"pesado",false, celdaCamino);
    }
}