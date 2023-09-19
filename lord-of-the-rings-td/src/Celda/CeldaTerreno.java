package Celda;

import Estructuras.Cerro;
import Torre.Torre;

/**
 * Una clase que representa las celdas donde el jugador podrá colocar sus defensas.
 * @version 1.0 19/9/23 *
 * @author Ezequiel L. Martins *
 */
public class CeldaTerreno extends Celda{
    private Torre torre;
    private Boolean ocupada;

    /**
     * Constructor de CeldaTerreno.
     */
    public CeldaTerreno(){
        super(1,1);
        torre = null;
        ocupada = false;
    }
    /**
     * Constructor de CeldaCamino.
     * @param coordenadaX Coordenada X dentro del mapa.
     * @param coordenadaY Coordenada Y dentro del mapa.
     */
    public CeldaTerreno(int coordenadaX, int coordenadaY){
        super(coordenadaX, coordenadaY);
        torre = null;
        ocupada = false;
    }

    /**
     * Getter de torre.
     * @return Devuelve un objeto Torre.
     * @see Torre
     */
    public Torre getTorre(){
        return torre;
    }
    /**
     * Setter de torre.
     * @param torre Objeto Torre la cual estará vinculada con la CeldaTerreno.
     * @see Torre
     */
    public void setTorre(Torre torre){
        this.torre=torre;
    }

    /**
     * Getter de ocupada.
     * @return Devuelve un boolean.
     */
    public Boolean getOcupada(){
        return ocupada;
    }
}