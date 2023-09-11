package Torre;

import java.util.ArrayList; //importo la clase ArrayList

/**
 * Una clase abstracta para representar los comportamientos generales de las torres.
 * @version 1.1 10/9/23 *
 * @author Ignacio Copppede Santos *
 */

public abstract class Torre {

    protected int coste;
    protected int costeMejora;
    protected int nivel;
    protected CeldaTerreno celdaAsociada;
    protected ArrayList<CeldaCamino> celdaEnRango;

    /**
     *
     * @param coste El coste en magia de la torre.
     * @param costeMejora El coste en magia de mejorar la torre.
     * @param nivel el nivel actual de la torre.
     * @param celdaAsociada La celda donde se encuentra la torre.
     * @param celdaEnRango Las celdas que estan en el rango de ataque de la torre.
     */

    /**
     * Constructor de la torre pasando como parametros el valor de los atributo.
     */
    public Torre(int coste, int costeMejora, CeldaTerreno celdaAsociada){

        this.coste=coste;
        this.costeMejora=costeMejora;
        nivel=0;
        this.celdaAsociada=celdaAsociada;

    }

    /** Constructor de la torre solo pasando el parametro de celdaTerren */
    public int Torre(CeldaTerreno celdaAsociada){
        coste=100;
        costeMejora=200;
        nivel=0;
        this.celdaAsociada=celdaAsociada;
        //valores por default
    //}

    /**
     * Getter del coste.
     * @return el coste de la torre.
     */
    public int getCoste(){
        return coste;
    }

    /**
     * Modifica el coste de la torre.
     * @param coste nuevo coste *
     */
    public void setCoste(int coste){
        this.coste=coste;
    }

    /**
     *getter costeMejora.
     * @return el coste de la mejora *
     */
    public int getCosteMejora(){
        return costeMejora;
    }

    /**
     //* modifica el coste de la mejora.
     //* @param costeMejora nuevo coste de mejora *
     */
    public void setCosteMejora(int costeMejora){
        this.costeMejora=costeMejora;
    }

    /**
     * getter del nivel.
     * @return el nivel de la torre*
     */
    public int getNivel(){
        return nivel;
    }

    /**
     * modifica el nivel de la torre.
     * @param nivel nivel de la torre*
     */
    public void setNivel(int nivel){
        this.nivel=nivel;
    }

    /**
     * getter de celdaAsociada.
     * @return la celda donde se encuentra la torre*
     */
    public CeldaTerreno getCeldaAsociada() {
        return celdaAsociada;
    }

    /**
     * getter de CeldaEnRango.
     * @return la lista con las celdas en el rango de ataque*
     */
    public ArrayList<CeldaCamino> getCeldaEnRango(){
        return celdaEnRango;
    }

    /**
     * agrega celdas en el rango de ataque.
     * @param nuevaCelda nueva celda en el rango de ataque*
     */
    private void setCeldaEnRango(CeldaCamino nuevaCelda){
        celdaEnRango.add(nuevaCelda);
    }
}
