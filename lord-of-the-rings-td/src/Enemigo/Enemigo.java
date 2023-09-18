package Enemigo;

import Celda.CeldaCamino;
import Estructuras.*;
import TimeTicks.TimeTicks;

/**
 * Una clase abstracta para representar los comportamientos generales de los enemigos que intentan atacar el Cerro de la Gloria.
 * @version 1.0 18/9/23
 * @author Ezequiel L. Martins
 */
public abstract class Enemigo implements TimeTicks {

    protected int vida, velocidad, dano, magiaOtorgada, tick;
    protected String tipo;
    protected Boolean ralentizado;
    protected CeldaCamino ubicacion;

    /**
     * Constructor de enemigo, recibiendo como parametros el valor de sus atributos.
     * @param vida Vida que tendrá cuando este activo.
     * @param dano Daño que le causa a las defensas cuando ataca.
     * @param velocidad Tiempo que tarda en atacar o moverse de una celda.
     * @param magiaOtorgada Magia otorgada al jugador cuando es eliminado por una torre.
     * @param tipo Tipo de enemigo que es, siendo las opciones: 'normal', 'ligero' y 'pesado'.
     * @param ralentizado Estado lógico que dice si el enemigo se encuentra ralentizado.
     * @param ubicacion CeldaCamino en la cual se encuentra dentro del mapa.
     * @see CeldaCamino
     */
    public Enemigo(int vida, int dano, int velocidad, int magiaOtorgada, String tipo, boolean ralentizado, CeldaCamino ubicacion){
        this.vida = vida;
        this.dano = dano;
        this.velocidad = velocidad;
        this.magiaOtorgada = magiaOtorgada;
        this.tipo = tipo;
        this.ralentizado = ralentizado;
        this.ubicacion = ubicacion;
        this.tick = 0;
    }

    /**
     * Getter de la vida.
     * @return Vida actual del enemigo.
     */
    public int getVida(){
        return this.vida;
    }
    /**
     * Setter de la vida.
     * @param vida Nuevo valor para la vida del enemigo.
     */
    public void setVida(int vida){
        this.vida = vida;
    }

    /**
     * Getter del daño.
     * @return Daño del enemigo.
     */
    public int getDano(){
        return this.dano;
    }

    /**
     * Getter de la velocidad.
     * @return Velocidad del enemigo.
     */
    public int getVelocidad(){
        return this.velocidad;
    }
    /**
     * Setter de la velocidad.
     * @param nuevaVelocidad Nuevo valor de la velocidad.
     */
    public void setVelocidad(int nuevaVelocidad){
        this.velocidad = nuevaVelocidad;
    }

    /**
     * Getter de la magia ortorgada.
     * @return Magia otorgada por el enemigo.
     */
    public int getMagiaOtorgada(){
        return this.magiaOtorgada;
    }

    /**
     * Getter del tipo de enemigo.
     * @return Tipo de enemigo.
     */
    public String getTipo(){
        return this.tipo;
    }

    /**
     * Getter de ralentizado.
     * @return Ralentizado del enemigo.
     */
    public Boolean getRalentizado(){
        return this.ralentizado;
    }
    /**
     * Setter de ralentizado.
     * @param ralentizado Nuevo valor de ralentizado.
     */
    public void setRalentizado(Boolean ralentizado){
        this.ralentizado = ralentizado;
    }

    /**
     * Getter de la ubicación.
     * @return Ubicación del enemigo.
     */
    public CeldaCamino getUbicacion(){ // ADECUAR A COMO FUNCIONA LA UBICACION
        return this.ubicacion;
    }
    /**
     * Setter de la ubicación.
     * @param nuevaUbicacion Nuevo valor de ubicación.
     */
    public void setUbicacion(CeldaCamino nuevaUbicacion){ // ADECUAR A COMO FUNCIONA LA UBICACION
        this.ubicacion = nuevaUbicacion;
    }

    // Documentar
    public void moverEnemigo(Enemigo enemigo){
        CeldaCamino siguienteUbicacion;
        siguienteUbicacion = enemigo.getUbicacion();
        siguienteUbicacion = siguienteUbicacion.getSiguienteCelda();
        if (siguienteUbicacion.getCerro() instanceof Cerro){
            danarCerro(siguienteUbicacion.getCerro());
            morir(enemigo);
            return;
        }
        if (siguienteUbicacion.getBarricada() instanceof Barricada){
            Barricada barricada = siguienteUbicacion.getBarricada();
            barricada.setVida(barricada.getVida() - dano);
            return;
        }
        setUbicacion(siguienteUbicacion);
    }

    public void danarCerro(Cerro cerro){cerro.setVida(cerro.getVida() - dano);}

    public void morir(Enemigo enemigo){
        enemigo.ubicacion = null; // to do: eliminarlo de la lista de la celda
        // Eliminar la unidad de la celda en donde esta ubicado
    }

    @Override
    public void waitingTick(){
        tick++;
        if (tick == velocidad){
            actionTick();
            tick=0;
        }
    }
    @Override
    public void actionTick(){

    }
}







