package Enemigo;

import Celda.CeldaCamino;

/**
 * Una clase que genera un enemigo hobbit del tipo 'ligero'.
 * @version 1.0 18/9/23
 * @author Ezequiel L. Martins
 */
public class Hobbit extends Enemigo{
    public Hobbit(CeldaCamino celdaCamino){
        super(40,1,2,2,"ligero",false, celdaCamino);
    }
}
