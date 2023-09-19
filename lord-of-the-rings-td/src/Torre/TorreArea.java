package Torre;

import Celda.CeldaCamino;
import Celda.CeldaTerreno;
import Enemigo.Enemigo;

import java.util.ArrayList;
import java.util.Iterator;

public class TorreArea extends TorreActiva{
    public TorreArea(CeldaTerreno celda){
        super(20,4,2,"a",200,celda);
    }

    /**
     * Busca entre todas las celdas camino que tiene dentro de su rango de ataque y ataca a todos los enemigos de la ultima celda dentro de su rango.
     */
    @Override
    public void actionTick(){
        for (CeldaCamino enRango : celdaEnRango) {

            ArrayList<Enemigo> enemigoslis = enRango.getListaEnemigos();
            if (!enemigoslis.isEmpty()) {
                //Iterator<Enemigo> enemigo = enemigoslis.iterator();
                //while (enemigo.hasNext()) {
                  //  enemigo.next().setVida(enemigo.next().getVida() - dano);

                //}
                int vida = 0;
                for (Enemigo enemigo : enemigoslis){
                     vida = enemigo.getVida() - dano ;
                     if (vida<=0){
                         enemigo.morir(enemigo);
                    }
                     else
                         enemigo.setVida(vida);

                }
                break;
            }

        }
    }
}
