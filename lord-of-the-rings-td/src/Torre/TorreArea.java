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


    @Override
    public void actionTick(){
        for (CeldaCamino enRango : celdaEnRango) {

            ArrayList<Enemigo> enemigoslis = enRango.getListaEnemigos();
            if (!enemigoslis.isEmpty()) {
                Iterator<Enemigo> enemigo = enemigoslis.iterator();
                while (enemigo.hasNext()) {
                    enemigo.next().setVida(enemigo.next().getVida() - dano);

                }
                break;
            }

        }
    }
}
