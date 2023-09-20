package Celda;

import java.util.ArrayList;
import Enemigo.Enemigo;
import Estructuras.*;

/**
 * Una clase que representa las celdas por las cuales pueden avanzar los enemigos y/o haber estructuras del jugador.
 * @version 1.1 19/9/23 *
 * @author Ezequiel L. Martins *
 */
public class CeldaCamino extends Celda{
    private ArrayList<Enemigo> listaEnemigos;
    private Barricada barricada;
    private Cerro cerro;
    private CeldaCamino siguienteCelda;

    /**
     * Constructor de CeldaCamino.
     * @param siguienteCelda CeldaCamino que le sigue a la celda creada.
     */
    public CeldaCamino(CeldaCamino siguienteCelda){
        super(1,1);
        this.siguienteCelda = siguienteCelda;
        this.cerro = null;
        this.barricada = null;
        this.listaEnemigos = new ArrayList<>();
    }
    /**
     * Constructor de CeldaCamino.
     * @param siguienteCelda Objeto CeldaCamino que le sigue a la celda creada.
     * @param coordenadaX Coordenada X dentro del mapa.
     * @param coordenadaY Coordenada Y dentro del mapa.
     */
    public CeldaCamino(CeldaCamino siguienteCelda, int coordenadaX, int coordenadaY){
        super(coordenadaX,coordenadaY);
        this.siguienteCelda = siguienteCelda;
        this.cerro = null;
        this.barricada = null;
        this.listaEnemigos = new ArrayList<>();
    }

    /**
     * Getter de listaEnemigos.
     * @return Devuelve un ArrayList con los objetos Enemigo parados en esa CeldaCamino.
     * @see Enemigo
     */
    public ArrayList<Enemigo> getListaEnemigos(){
        return listaEnemigos;
    }
    /**
     * Anade un nuevo enemigo al final de listaEnemigos.
     * @param enemigo Objeto Enemigo que será anadido.
     * @see Enemigo
     */
    public void nuevoEnemigo(Enemigo enemigo){
        listaEnemigos.add(enemigo);
    }
    /**
     * Elimina un enemigo de listaEnemigos.
     * @param enemigo Objeto Enemigo que será eliminado.
     * @see Enemigo
     * @return Devuelve un boolean de si pudo eliminar al enemigo
     */
    public Boolean sacarEnemigo(Enemigo enemigo) {
        Boolean b1 = listaEnemigos.contains(enemigo);
        if (b1){
            listaEnemigos.remove(enemigo);
        }
        return b1;
    }

    /**
     * Getter de siguienteCelda.
     * @return Devuelve un objeto CeldaCamino del atributo siguienteCelda o null si no tiene una siguiente celda.
     */
    public CeldaCamino getSiguienteCelda() {
        return this.siguienteCelda;
    }

    /**
     * Getter de cerro.
     * @return Devuelve un objeto Cerro.
     * @see Cerro
     */
    public Cerro getCerro(){return this.cerro;}
    /**
     * Setter de cerro.
     * @param cerro Objeto Cerro el cual estará vinculado con la CeldaCamino.
     * @see Cerro
     */
    public void setCerro(Cerro cerro){this.cerro = cerro;}

    /**
     * Getter de barricada.
     * @return Devuelve un objeto Barricada.
     * @see Barricada
     */
    public Barricada getBarricada(){
        return barricada;
    }
    /**
     * Setter de barricada.
     * @param barricada Objeto Barricada la cual estará vinculada con la CeldaCamino.
     * @see Barricada
     */
    public void setBarricada(Barricada barricada){
        this.barricada=barricada;
    }
}