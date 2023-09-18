package Enemigo;

import Celda.CeldaCamino;

/**
 * Una clase que genera un humano elfo del tipo normal.
 * @version 1.0 18/9/23
 * @author Ezequiel L. Martins
 */
public class Humano extends Enemigo{
    public Humano(CeldaCamino celdaCamino){
        super(120,2,4,8,"normal",false, celdaCamino);
    }
}
