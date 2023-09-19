package Torre;

import Celda.CeldaCamino;
import Celda.CeldaTerreno;
import Enemigo.Enemigo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class TorreArea extends TorreActiva{
    public TorreArea(CeldaTerreno celda){
        super(10,6,2,"a",200,celda);
    }

    /**
     * Busca entre todas las celdas camino que tiene dentro de su rango de ataque y ataca a todos los enemigos de la ultima celda dentro de su rango.
     */

    @Override
    public void actionTick(){
        for (CeldaCamino enRango : celdaEnRango) {


            ArrayList<Enemigo> enemigoslis = enRango.getListaEnemigos();
            if (!enemigoslis.isEmpty()) {
                for (var i = 0; i<enemigoslis.size() ; i++) {
                    Enemigo enemigo = enemigoslis.get(i);
                    int vida = enemigo.getVida();

                    if (Objects.equals(tipoDano, "a")) {
                        vida = vida - dano;
                        if (Objects.equals(enemigo.getTipo(), "ligero")) {
                            vida -= 10;
                        }
                    }
                    if ((vida) < 0) {
                        enemigo.morir(enemigo, true);
                    } else {
                        enemigo.setVida(vida);
                    }
                }
                break;
            }
        }
    }

}
