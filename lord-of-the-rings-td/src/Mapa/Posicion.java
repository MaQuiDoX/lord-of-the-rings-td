package Mapa;

/**
 * Clase para crear objeto con las posiciones x e y enteros
 * @version 1.0, 13/9/23
 * @author Manuel Matias Quesada Riccieri
 */
public class Posicion {
    private int x;
    private int y;

    /**
     * Constructor del objeto Posicion
     * @param x entero que representa posicion x del vector
     * @param y entero que representa posicion y del vector
     */
    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter de posicion x del vector
     * @return x entero posicion
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * Getter de posicion y del vector
     * @return y entero posicion
     */
    public int getY(){
        return this.y;
    }
}
