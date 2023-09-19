package Torre;

import Celda.CeldaCamino;
import Celda.CeldaTerreno;
import Enemigo.Enemigo;

import java.util.ArrayList;
import java.util.Iterator;

public class TorreArea extends TorreActiva{
    public TorreArea(CeldaTerreno celda){
        super(40,4,2,"a",200,celda);
    }

    /**
     * Busca entre todas las celdas camino que tiene dentro de su rango de ataque y ataca a todos los enemigos de la ultima celda dentro de su rango.
     */

    @Override
    public void actionTick(){
        System.out.println("posicion de la torre" + celdaAsociada.getCoorX() + " "+ celdaAsociada.getCoorY());
        System.out.println("celdas en rango: " + celdaEnRango);
        for (CeldaCamino enRango : celdaEnRango) {
            System.out.println(("celda"+ enRango.getCoorX() + enRango.getCoorY()));
            ArrayList<Enemigo> enemigoslis = enRango.getListaEnemigos();
            if (!enemigoslis.isEmpty()) {

                int vida = 0;
                for (Enemigo enemigo : enemigoslis){
                     vida = enemigo.getVida() - dano ;
                     if (vida<=0) enemigo.morir(enemigo);
                     else {
                         enemigo.setVida(vida);
                     }

                }
                break;
            }

        }
    }

}
