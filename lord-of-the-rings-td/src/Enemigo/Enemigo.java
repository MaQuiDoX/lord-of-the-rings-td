package Enemigo;

import TimeTicks.TimeTicks;
import Celda.CeldaCamino;
import Estructuras.*;
import Juego.Juego;

/**
 * Una clase abstracta para representar los comportamientos generales de los enemigos que intentan atacar el Cerro de la Gloria.
 * @version 1.1 19/9/23
 * @author Ezequiel L. Martins
 */
public abstract class Enemigo implements TimeTicks {

    protected int vida, velocidad, dano, magiaOtorgada, tick;
    protected String tipo;
    protected Boolean ralentizado;
    protected CeldaCamino ubicacion;
    protected Juego juego;

    /**
     * Constructor de enemigo.
     * @param vida Vida que tendrá cuando este activo.
     * @param dano Daño que le causa a las defensas cuando ataca.
     * @param velocidad Tiempo que tarda en atacar o moverse de una celda.
     * @param magiaOtorgada Magia otorgada al jugador cuando es eliminado por una torre.
     * @param tipo Tipo de enemigo que es, siendo las opciones: 'normal', 'ligero' y 'pesado'.
     * @param ralentizado Estado lógico que dice si el enemigo se encuentra ralentizado.
     * @param ubicacion Objeto CeldaCamino en donde se ubicará dentro de la oleada.
     * @param juego Objeto Juego en donde estara viviendo el enemigo.
     * @see CeldaCamino
     * @see Juego
     */
    public Enemigo(Juego juego, int vida, int dano, int velocidad, int magiaOtorgada, String tipo, boolean ralentizado, CeldaCamino ubicacion){
        this.juego = juego;
        this.vida = vida;
        this.dano = dano;
        this.velocidad = velocidad;
        this.magiaOtorgada = magiaOtorgada;
        this.tipo = tipo;
        this.ralentizado = ralentizado;
        this.ubicacion = ubicacion;
        ubicacion.nuevoEnemigo(this);
        this.tick = 0;
    }

    /**
     * Getter de juego.
     * @return Devuelve un Objeto Juego que es donde esta existiendo el enemigo.
     */
    public Juego getJuego(){
        return this.juego;
    }

    /**
     * Getter de vida.
     * @return Devuelve la vida actual del enemigo.
     */
    public int getVida(){
        return this.vida;
    }
    /**
     * Setter de vida.
     * @param vida Nuevo valor para la vida del enemigo.
     */
    public void setVida(int vida){
        this.vida = vida;
    }


    /**
     * Getter de velocidad.
     * @return Devuelve la velocidad actual del enemigo.
     */
    public int getVelocidad(){
        return this.velocidad;
    }
    /**
     * Setter de velocidad.
     * @param nuevaVelocidad Nuevo valor de velocidad.
     */
    public void setVelocidad(int nuevaVelocidad){
        this.velocidad = nuevaVelocidad;
    }

    /**
     * Getter del tipo de enemigo.
     * @return Devuelve el Tipo de enemigo.
     */
    public String getTipo(){
        return this.tipo;
    }

    /**
     * Getter de ralentizado.
     * @return Estado lógico de ralentización del enemigo.
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
     * Getter de ubicación.
     * @return Ubicación del enemigo.
     */
    public CeldaCamino getUbicacion(){ // ADECUAR A COMO FUNCIONA LA UBICACION
        return this.ubicacion;
    }
    /**
     * Setter de ubicación.
     * @param nuevaUbicacion Objeto CeldaCamino que correspondería a la ubicación actual del enemigo.
     */
    public void setUbicacion(CeldaCamino nuevaUbicacion){ // ADECUAR A COMO FUNCIONA LA UBICACION
        this.ubicacion = nuevaUbicacion;
    }

    /**
     * Método para eliminar al enemigo de la partida cuando su vida baja de 1 y dar una recompensa si la causo el jugador.
     * @param enemigo Objeto Cerro que sera dañado.
     * @param recompensa Estado lógico de si se recibirá recompensa por su muerte.
     */
    public void morir(Enemigo enemigo, boolean recompensa){
        if (recompensa){
            juego.getJugador().sumaPuntuacion(this.magiaOtorgada*10);
        } else{
            juego.getJugador().sumaPuntuacion(-this.magiaOtorgada*10);
        }
        CeldaCamino celda = enemigo.getUbicacion();
        celda.sacarEnemigo(enemigo);
        enemigo.getJuego().getListaEnemigosVivos().remove(enemigo);
        enemigo.ubicacion = null;
        enemigo.juego = null;
    }

    /**
     * Método privado para causarle daño al cerro cuando el enemigo llega hasta él.
     * @param cerro Objeto Cerro que sera dañado.
     */
    private void danarCerro(Cerro cerro){cerro.setVida(cerro.getVida() - dano);}
    /**
     * Método privado para causarle daño a una barricada cuando el enemigo se topa con una y destruirla si su vida baja de 1.
     * @param barricada Objeto Barricada que sera dañada.
     */
    private void danarBarricada(Barricada barricada){
        barricada.setVida(barricada.getVida() - dano);
        if (barricada.getVida() < 0){
            barricada.destruirse();
        }
    }
    /**
     *
     */
    private void moverEnemigo(Enemigo enemigo){
        CeldaCamino ubicacionActual = enemigo.getUbicacion();   // Asignar la celda donde esta parado
        ubicacionActual.sacarEnemigo(enemigo); // Saca al enemigo de la lista de enemigos en la celda donde esta parado
        ubicacionActual = ubicacionActual.getSiguienteCelda();  // Avanza a la siguiente celda
        setUbicacion(ubicacionActual);  // Le asigna la celda a la que avanzo a su atributo ubicacion
        ubicacionActual.nuevoEnemigo(enemigo); // Añade el enemigo a la lista de enemigos en esa celda
    }

    /**
     * Método que funciona como temporizador antes de las acciones del Enemigo.
     */
    @Override
    public void waitingTick(){
        tick++;
        if (tick == velocidad){
            actionTick();
            tick = 0;
        }
    }

    /**
     * Método que realiza las acciones del Enemigo, como avanzar por las celdas, atacar barricas y morir al dañar el cerro.
     */
    @Override
    public void actionTick(){
        CeldaCamino ubicacionActual, ubicacionSiguiente;
        ubicacionActual = this.getUbicacion();
        ubicacionSiguiente = ubicacionActual.getSiguienteCelda();
        if (ubicacionSiguiente.getCerro() instanceof Cerro){    // Verifica si en la celda siguiente esta el Cerro
            danarCerro(ubicacionSiguiente.getCerro());
            morir(this, false);
            return;
        }
        if (ubicacionSiguiente.getBarricada() instanceof Barricada){    // Verifica si en la celda siguiente hay una barricada
            danarBarricada(ubicacionSiguiente.getBarricada());
            return;
        }
        moverEnemigo(this);
    }
}