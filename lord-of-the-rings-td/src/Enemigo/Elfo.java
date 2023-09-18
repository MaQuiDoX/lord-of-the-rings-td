package Enemigo;

import Celda.CeldaCamino;

/**
 * Una clase que genera un enemigo elfo del tipo 'ligero'.
 * @version 1.0 18/9/23
 * @author Ezequiel L. Martins
 */
public class Elfo extends Enemigo{
    public Elfo(CeldaCamino celdaCamino){
        super(210,3,4,10,"ligero",false, celdaCamino);
    }
}
