package Jugador;
import Barricada.Barricada;
import Celda.*;
import Mapa.Mapa;
import Torre.*;

import java.util.ArrayList;

/**
 * Clase que representa al jugador.
 * @version 1.1, 10/7/23
 * @author Ignacio Coppede Santos */
public class Jugador {

    private static int magia;
    private static int puntuacion;

    /**
     * @param magia Magia que tiene el jugaador para comprar y mejorar torres.
     * @param puntuacion Puntuacion que tiene el jugador, empieza con cero y va aumentando.
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

    public Boolean comprarTorre(Mapa mapa,int coorX, int coorY, int tipoTorre){
        Celda t = mapa.getMatrizCelda(coorX, coorY);
        if (t instanceof CeldaTerreno){
            CeldaTerreno j = mapa.getMatrizCelda(coorX, coorY);
            return ColocarTorre(tipoTorre,j);
        } else if (t instanceof CeldaCamino) {

            if (tipoTorre==6){
                CeldaTerreno j = mapa.getMatrizCelda(coorX, coorY);
                return colocarBarricada(j);
            }
            else
                return Boolean.FALSE;
        } else{
            return Boolean.FALSE;
        }

    }

    public Boolean ColocarTorre(int tipoTorre,CeldaTerreno t){
            if (t.getOcupada()){
                return Boolean.FALSE;
            }
            else {
                if (tipoTorre == 1) {
                    TorreBasica torre = new TorreBasica(t);
                    t.setTorre(torre);

                } else if (tipoTorre == 2) {
                    TorreRango torre = new TorreRango(t);
                    t.setTorre(torre);

                } else if (tipoTorre == 3) {
                    TorreArea torre = new TorreArea(t);
                    t.setTorre(torre);

                } else if (tipoTorre == 4) {
                    TorreRalentizadora torre = new TorreRalentizadora(t);
                    t.setTorre(torre);

                } else if (tipoTorre == 5) {
                    TorreGeneradora torre = new TorreGeneradora(t);
                    t.setTorre(torre);
                    return Boolean.TRUE;

                } else {
                    return Boolean.FALSE;
                }
                ///implementar la lista de celdas a atacar;
                return Boolean.TRUE;

            }
    }

    public  Boolean colocarBarricada(CeldaCamino celda){
        Barricada barricada = celda.getBarricada();
        if (barricada==null){
            Barricada barricada1 = new Barricada(100, 500,0,celda);
            celda.setBarricada(barricada1);
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }




    //devuelve verdadero si pudo vender lab torre y False en caso contrario
    //public bool venderTorre(int coordenadaX, int coordenadaY){
    // return True;
    //}


  
    public static void mostrarInterfaz() {
        System.out.println(" ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Magia: " + magia + " - Puntuación: " + puntuacion + " ||| Vida Cerro: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Glosario:");
        System.out.println("Enemigos: Hu: Humano -- El: Elfo -- En: Enano -- Ho: Hobbit -- T: Ent -- V: Varios enemigos");
        System.out.println("Torres: B: Torre Básica -- R: Torre Rango -- A: Torre Área -- L: Torre Ralentizadora");
        System.out.println("        G: Torre Generadora -- ||: Barricada ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void mostrarOpciones() {
        System.out.println("¿Qué desea hacer?:");
        System.out.println("1. Fortalecer defensas");
        System.out.println("2. Descripción de Torres");
        System.out.println("3. Descripción de Enemigos");
        System.out.println("4. Conocer siguiente oleada");
        System.out.println("5. Comenzar oleada");
    }

    public static void mostrarOpcionesTorres() {
        System.out.println("¿Qué desea hacer?:");
        System.out.println("1. Colocar una Torre");
        System.out.println("2. Mejorar una Torre");
        System.out.println("3. Volver para atrás");
    }

    public static void mostrarTienda(){
        System.out.println("1. Colocar Torre Básica (100 coste de magia)");
        System.out.println("2. Colocar Torre de Rango (150 coste de magia)");
        System.out.println("3. Colocar Torre de Área (300 coste de magia)");
        System.out.println("4. Colocar Torre Ralentizadora (400 coste de magia)");
        System.out.println("5. Colocar Torre Generadora (200 coste de magia)");
        System.out.println("6. Colocar Barricada (500 coste de magia)");
        System.out.println("7. Volver para atrás");
    }

    public static void descripcionTorres() {
        System.out.println("¿Acerca de que Torre quieres saber más?");
        System.out.println("1. Torre Básica");
        System.out.println("2. Torre de Rango");
        System.out.println("3. Torre de Área");
        System.out.println("4. Torre Ralentizadora");
        System.out.println("5. Torre Generadora");
        System.out.println("6. Barricada");
        System.out.println("7. Volver atrás");
    }

    public static void descripcionEnemigos() {
        System.out.println("¿Acerca de que Enemigo quieres saber más?");
        System.out.println("1. Humano");
        System.out.println("2. Elfo");
        System.out.println("3. Enano");
        System.out.println("4. Hobbit");
        System.out.println("5. Ent");
        System.out.println("6. Volver atrás");
    }
}
