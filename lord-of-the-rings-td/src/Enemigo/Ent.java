package Enemigo;

import Celda.CeldaCamino;
import Juego.Juego;

/**
 * Una clase que genera un enemigo ent del tipo 'pesado'.
 * @version 1.0 18/9/23
 * @author Ezequiel L. Martins
 */
public class Ent extends Enemigo{
    public Ent(Juego juego, CeldaCamino celdaCamino){ super(juego,700,5,7,50,"pesado",false, celdaCamino);}

}
