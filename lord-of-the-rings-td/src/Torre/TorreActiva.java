package Torre;

import Celda.CeldaCamino;
import Celda.CeldaTerreno;
import Enemigo.Enemigo;
import TimeTicks.TimeTicks;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Una clase abstracta para representar los comportamientos generales de las torres que atacan a los enemigos.
 * @version 1.1 10/9/23 *
 * @author Ignacio Copppede Santos *
 */

public abstract class TorreActiva extends Torre implements TimeTicks {

    protected int dano;
    protected int velocidad;
    protected int alcance;
    protected String tipoDano;



    /**
     * Constructor de la torre pasando como parametros el valor de los atributo.
     * @param dano Dano que le causa la torre al enemigo en cada ataque.
     * @param velocidad Tiempo que tarda en atacar a un enemigo.
     * @param alcance Radio, en cantidad de celdas, en el que puede atacar enemigos.
     * @param tipoDano Tipo de ataque que hace la torre.
     * @param celdaAsociada Celda donde se encuentra la Torre.
     * @param costeMejora el coste en magia de la mejora inicial.
     */
    public TorreActiva(int dano, int velocidad, int alcance, String tipoDano, int costeMejora, CeldaTerreno celdaAsociada){
        super( costeMejora, celdaAsociada);
        this.dano=dano;
        this.velocidad=velocidad;
        this.alcance=alcance;
        this.tipoDano=tipoDano;
    }



    /**
     * Getter del dano.
     * @return dano de la torre*
     */
    public int getDano(){
        return dano;
    }

    /**
     * Modifica el dano de la torre.
     * @param dano nuevo dano *
     */
    public void setDano(int dano){
        this.dano=dano;
    }

    /**
     * Getter de velocidad.
     * @return la velocidad de la torre *
     */
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Modifica la velocidad.
     * @param velocidad nueva velocidad *
     */
    public void setVelocidad(int velocidad){
        this.velocidad=velocidad;
    }

    /**
     * Getter alcance.
     * @return alcance de la torre*
     */
    public int getAlcance(){
        return alcance;
    }

    /**
     * Modifica el alcance de la torre.
     * @param alcance nuevo alcance de la torre *
     */
    public void setAlcance(int alcance){
        this.alcance=alcance;
    }





    /**
     * Avanza un tick y comprueba si es momente de realizar una accion.
     */
    @Override
    public void waitingTick(){
        tick++;
        if (tick==velocidad){
            actionTick();
            tick=0;
        }
    }

    /**
     * Busca entre todas las celdas camino que tiene dentro de su rango de ataque y ataca al primer enemigo de la ultima celda dentro de su rango.
     */
    @Override
    public void actionTick(){
        for (CeldaCamino enRango : celdaEnRango) {

            ArrayList<Enemigo> enemigoslis = enRango.getListaEnemigos();
            if (!enemigoslis.isEmpty()) {
                Enemigo enemigo = enemigoslis.get(0);
                int vida = enemigo.getVida();
                if (Objects.equals(tipoDano, "b")) {
                    vida = vida - dano;
                    if (Objects.equals(enemigo.getTipo(), "normal")) {
                        vida -= 10;
                    }

                } else if (Objects.equals(tipoDano, "a")) {
                    vida = vida - dano;
                    if (Objects.equals(enemigo.getTipo(), "ligero")) {
                        vida -= 10;
                    }
                } else if (Objects.equals(tipoDano, "r")) {
                    vida = vida - dano;
                    if (Objects.equals(enemigo.getTipo(), "pesado")) {
                        vida -= 40;
                    }
                }
                if ((vida) < 0) {
                    enemigo.morir(enemigo, true);
                } else {
                    enemigo.setVida(vida);
                }
                break;


            }
        }
    }
}
