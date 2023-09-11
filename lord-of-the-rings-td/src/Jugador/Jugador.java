package Jugador;

/**
 * Clase que representa al jugador.
 * @version 1.1, 10/7/23
 * @author Ignacio Coppede Santos */
public class Jugador {


    private int magia;
    private int puntuacion;

    /**
     *
     * @parammagia Magia que tiene el jugaador para comprar y mejorar torres.
     * @parampuntuacion Puntuacion que tiene el jugador, empieza con cero y va aumentando.
     */

    /**
     * Getter de magia.
     * @return magia del jugador *
     */
    public int getmagia(){
        return magia;
    }

    /**
     * Modifica la magia.
     * @param magia nuevo valor de la magia *
     */
    public void setmagia(int magia){
        this.magia=magia;
    }

    /**
     * Getter de puntuacion.
     * @return puntuacion del jugador *
     */
    public int getpuntuacion(){
        return puntuacion;
    }

    /**
     * Agrega puntuacion a la que tiene el jugador.
     * @param puntuacion el aumento de la puntuacion *
     */
    public void sumaPuntuacion(int puntuacion){
        this.puntuacion+=puntuacion;
    }

    /**
     * Constructor del jugador con todos los valores por default.
     */
    public Jugador(){
        magia=50;
        puntuacion=0;
    }


    //devuelve verdadero si pudo vender lab torre y False en caso contrario
    //public bool venderTorre(int coordenadaX, int coordenadaY){
    // return True;
    //}
}
