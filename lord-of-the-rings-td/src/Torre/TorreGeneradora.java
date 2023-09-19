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
     * Constructor de la Torre generadora con valores por default.
     * @param celdaAsociada celda donde se encuentra la torre *
     */
    public TorreGeneradora(CeldaTerreno celdaAsociada){
        super(30,celdaAsociada);
        cantidad=10;
    }

    /**
     * Devuelve la cantidad de magia que genera por ronda la torre.
     * @return cantidad de magia que genera la torre.
     */
    public int getCantidad(){
        return cantidad;
    }

    /**
     * Modifica la cantidad de magia que genera la torre por ronda.
     * @param cantidad nueva cantidad.
     */
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
