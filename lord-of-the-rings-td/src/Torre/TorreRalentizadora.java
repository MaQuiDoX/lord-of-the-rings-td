package Torre;
import Celda.CeldaCamino;
import Celda.CeldaTerreno;
import Enemigo.Enemigo;
import TimeTicks.TimeTicks;

import java.util.ArrayList;
import java.util.Iterator;

public class TorreRalentizadora extends Torre implements TimeTicks {

    private int alcance;
    private int velocidad;

    ///ver de balancearlo mejor, solo se podria mejorar el alcance
    public TorreRalentizadora(CeldaTerreno celdaAsociada){
        super(30,celdaAsociada);
        alcance=1;
        velocidad=3;
    }

    public int getAlcance(){
        return alcance;
    }
    public void setAlcance(int alcance){
        this.alcance=alcance;
    }
    public int getVelocidad(){
        return velocidad;
    }
    public void setVelocidad(int velocidad){
        this.velocidad=velocidad;
    }



    @Override
    public void waitingTick() {
        tick++;
        if (tick==velocidad){
            actionTick();
        }
    }

    @Override
    public void actionTick() {
        for (CeldaCamino enRango : celdaEnRango) {

            ArrayList<Enemigo> enemigoslis = enRango.getListaEnemigos();
            if (!enemigoslis.isEmpty()) {
                Enemigo enemigo = enemigoslis.get(0);
                enemigo.setVelocidad(enemigo.getVelocidad() + 1);
                break;

            }
        }
    }
}
