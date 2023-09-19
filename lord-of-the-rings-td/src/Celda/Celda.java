package Celda;

/**
 * Una clase abstracta que sirve para crear las celdas que forman el mapa.
 * @version 1.0 19/9/23 *
 * @author Ezequiel L. Martins *
 */
public abstract class Celda {

    protected int coorX;
    protected int coorY;

    /**
     * Constructor de Celda, recibe las coordenadas X e Y dentro del mapa.
     * @param coordenadaX Coordenada X dentro del mapa.
     * @param coordenadaY Coordenada Y dentro del mapa.
     */
    public Celda(int coordenadaX, int coordenadaY){
        this.coorX=coordenadaX;
        this.coorY=coordenadaY;
    }

    /**
     * Getter de coorX.
     * @return Devuelve la coordenada en X.
     */
    public int getCoorX(){
        return coorX;
    }
    /**
     * Getter de coorY.
     * @return Devuelve la coordenada en Y.
     */
    public int getCoorY(){
        return coorY;
    }
    // NO ME SALEN USOS DE ESTO, DEBERIAMOS BORRARLO?
    public void setCoorX(int coorX){
        this.coorX=coorX;
    }
    // NO ME SALEN USOS DE ESTO, DEBERIAMOS BORRARLO?
    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }
}
