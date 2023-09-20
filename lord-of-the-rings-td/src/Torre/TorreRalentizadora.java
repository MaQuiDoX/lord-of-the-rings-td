package Torre;

import Celda.CeldaCamino;
import Celda.CeldaTerreno;
import Enemigo.Enemigo;
import TimeTicks.TimeTicks;

import java.util.ArrayList;

public class TorreRalentizadora extends Torre implements TimeTicks {

    private int alcance;
    private int velocidad;

    /**
     * Constructor unico de TorreRalentizadora.
     * @param celdaAsociada La celda donde se encuentra la torre.
     */
    public TorreRalentizadora(CeldaTerreno celdaAsociada){
        super(30,celdaAsociada);
        alcance=1;
        velocidad=2;
    }

    /**
     * Devuelve el alcance de la torre.
     * @return Entero alcance de la torre.
     */
    public int getAlcance(){
        return alcance;
    }

    /**
     * Modifica el alcance de la torre.
     * @param alcance nuevo alcance de la torre.
     */
    public void setAlcance(int alcance){
        this.alcance=alcance;
    }

    /**
     * Devuelve la velocidad de accion de la torre.
     * @return Entero que representa la velocidad de la torre.
     */
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Modifica la velocidad de accion de la torre.
     * @param velocidad Nuevo entero que representa la velocidad de la torre.
     */
    public void setVelocidad(int velocidad){
        this.velocidad=velocidad;
    }


    /**
     * avanza un tick y comprueba si es momente de realizar una accion.
     */
    @Override
    public void waitingTick() {
        tick++;
        if (tick==velocidad){
            actionTick();
        }
    }

    /**
     * Busca entre todas las celdas camino que tiene dentro de su rango de ataque y reduce la velocidad en uno al primer enemigo de la ultima celda dentro de su rango.
     */
    @Override
    public void actionTick() {
        for (CeldaCamino enRango : celdaEnRango) {
            ArrayList<Enemigo> enemigoslis = enRango.getListaEnemigos();
            if (!enemigoslis.isEmpty()) {
                Enemigo enemigo = enemigoslis.get(0);
                if (!enemigo.getRalentizado()){
                    enemigo.setVelocidad(enemigo.getVelocidad() + 4);
                    enemigo.setRalentizado(true);
                }
                break;
            }
        }
    }
}
