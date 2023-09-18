package Enemigo;

import Celda.CeldaCamino;

/**
 * Una clase que genera un enemigo ent del tipo 'pesado'.
 * @version 1.0 18/9/23
 * @author Ezequiel L. Martins
 */
public class Ent extends Enemigo{
    public Ent(CeldaCamino celdaCamino){ super(700,5,7,50,"pesado",false, celdaCamino);}

}
