package Torre;


import Jugador.Jugador;
import Celda.CeldaTerreno;


/**
 * Una clase de las torres capaces de generar magia.
 * @version 1.1 10/9/23 *
 * @author Ignacio Copppede Santos *
 */

public class TorreGeneradora extends Torre {

    private int cantidad;
    /**
     * @param frecuencia la frecuencia en tiempo con la que se genera magia *
     * @param cantidad la cantidad que se genera de magia *
     */

    /**
     * Constructor de la Torre generadora con valores por default.
     * @param celdaAsociada celda donde se encuentra la torre *
     */
    public TorreGeneradora(CeldaTerreno celdaAsociada){
        super(200,30,celdaAsociada);
        cantidad=10;
    }

    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }

    /**
     * Metodo para sumarle magia al jugador.
     */
    public void generarMagia(Jugador jugador){
         int magia=jugador.getmagia();
         jugador.setmagia(magia+cantidad);
    }

}
