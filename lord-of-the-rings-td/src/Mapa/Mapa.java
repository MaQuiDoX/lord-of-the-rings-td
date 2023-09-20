package Mapa;

import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Celda.*;
import Estructuras.*;
import Enemigo.*;
import Torre.*;

/**
 * Clase encargada de lo referido al Mapa
 * @version 1.3, 18/9/23
 * @author Manuel Matias Quesada Riccieri
 */
public class Mapa {
    public Celda[][] matriz;
    static String nivel1 = "[(4,16), (4,15), (5,15), (6,15), (7,15), (8,15), (8,14), (8,13), (8,12), (8,11), (7,11), (6,11), (5,11), (4,11), (3,11), (3,12), (3,13), (2,13), (1,13), (1,12), (1,11), (1,10), (1,9), (2,9), (3,9), (4,9), (5,9), (6,9), (6,8), (6,7), (5,7), (4,7), (3,7), (2,7), (1,7), (1,6), (1,5), (1,4), (2,4), (3,4), (4,4), (4,5), (5,5), (6,5), (7,5), (7,4), (7,3), (7,2), (6,2), (5,2), (4,2), (3,2), (2,2), (1,2), (1,1), (1,0)]";
    static String nivel2 = "[(4,16),(4,15) ,(4,14), (4,13) ,(4,12) ,(5,12) ,(6,12) ,(6,11) ,(6,10) ,(6,9) ,(5,9) ,(4,9) ,(3,9) ,(2,9) ,(2,8) ,(2,7) ,(2,6) ,(3,6) ,(4,6) ,(5,6) ,(6,6) ,(7,6) ,(7,5) ,(7,4) ,(7,3) ,(6,3) ,(5,3) ,(4,3) ,(3,3) ,(2,3) ,(1,3) ,(1,2) ,(1,1), (1,0)]";
    static String nivel3 = "[(4,16),(3,16) ,(2,16) ,(1,16) ,(0,16) ,(0,15) ,(0,14) ,(0,13) ,(0,12) ,(0,11) ,(0,10) ,(0,9) ,(0,8) ,(1,8) ,(2,8) ,(3,8) ,(4,8) ,(5,8) ,(6,8) ,(7,8) ,(8,8) ,(8,7) ,(8,6) ,(8,5) ,(8,4) ,(8,3) ,(8,2) ,(8,1) ,(8,0) ,(7,0) ,(6,0) ,(5,0) ,(4,0) ,(3,0) ,(2,0) ,(1,0)]";
    public static ArrayList<Posicion> posicionesLvl1 = parsearString(nivel1);
    public static ArrayList<Posicion> posicionesLvl2 = parsearString(nivel2);
    public static ArrayList<Posicion> posicionesLvl3 = parsearString(nivel3);

    public CeldaCamino primerCelda;
    public int nivel = 0;

    /**
     * Constructor de mapa
     */
    public void mapa(){
        primerCelda = null;
        nivel = 0;
    }

    /**
     * Metodo que lee la dificultad escogida por el usuario y devuelve el Array de Posiciones del camino de la matriz con la que se va a trabajar.
     * @param dificultad int que representa el numero de dificultad del juego.
     * @return devuelve un ArrayList ya existente dependiendo de la dificultad, en caso de que la dificultad no sea reconocida devuelve null.
     */
    public static ArrayList<Posicion> getPositionArray(int dificultad) {
        if (dificultad == 1) {
            return posicionesLvl1;
        } else if (dificultad == 2) {
            return posicionesLvl2;
        } else if (dificultad == 3) {
            return posicionesLvl3;
        } else {
            return null;
        }
    }

    /**
     * Metodo encargado de crear el mapa compuesto por el objeto Celda[][] y extensiones, a partir de la dificultad escogida por el usuario.
     * @param dificultad que representa el numero de dificultad del juego.
     * @return matriz Celda[][] ya armada, con sus celdas ocupadas por los objetos CeldaCamino y CeldaTerreno, extensiones de Celda.
     */
    public Celda[][] crearMapa(int dificultad) {
        this.nivel = dificultad;

        Celda[][] matriz = new Celda[9][17];
        ArrayList<Posicion> posiciones = getPositionArray(dificultad);

        Posicion ultimaPosicion = posiciones.get(posiciones.size() -1);
        int firstX = ultimaPosicion.getX();
        int firstY = ultimaPosicion.getY();

        Cerro cerro = new Cerro();
        CeldaCamino celdaConCerro = new CeldaCamino(null, 4, 16);
        celdaConCerro.setCerro(cerro);
        int oldX = 0;
        int oldY = 0;
        for (int i = 0; i < posiciones.size(); i++) {
            int x = posiciones.get(i).getX();
            int y = posiciones.get(i).getY();

            if ((x == 4) && (y == 16)) {
                matriz[x][y] = celdaConCerro;
            } else if ((x == 4) && (y == 15)) {
                matriz[x][y] = new CeldaCamino((CeldaCamino) matriz[4][16], x, y);
            } else {
                matriz[x][y] = new CeldaCamino((CeldaCamino) matriz[oldX][oldY], x, y);
            }
            oldX = x;
            oldY = y;
        }

        for (int s = 0; s < 9; s++) {
            for (int j = 0; j < 17; j++) {
                if (!(matriz[s][j] instanceof CeldaCamino)) {
                    matriz[s][j] = new CeldaTerreno();
                }
            }
        }
        CeldaCamino primeraCelda = (CeldaCamino) matriz[firstX][firstY];
        this.primerCelda =  primeraCelda;
        this.matriz = matriz;
        return matriz;
    }

    /**
     * Getter del nivel de dificultad del mapa.
     * @return int igual al nivel de dificultad.
     */
    public int getNivel(){
        return this.nivel;
    }

    /**
     * Getter para obtener una celda dentro de la matriz Celda[][].
     * @param x representando el numero de posicion de fila.
     * @param y representando el numero de posicion de columna.
     * @return Celda correspondiente a la posicion ingresada.
     */
    public Celda getMatrizCelda(int x, int y){
        return matriz[x][y];
    }

    /**
     * Getter para obtener matriz completa.
     * @return matriz Celda[][].
     */
    public Celda[][] getMatriz(){
        return matriz;
    }

    /**
     * Getter para obtener la primer celda del camino.
     * @return Primer celda CeldaCamino correspondiente al camino.
     */
    public CeldaCamino getFirstCeldaCamino(){
        return this.primerCelda;
    }

    /**
     * Metodo encargado de interpretar una String separandola por comas y parentesis, para asignarle al Objeto Posicion los parametros x e y, e introducirlos en un ArrayList
     * @param input representa el String que ingresa.
     * @return retorna el ArrayList de Posicion.
     */
    public static ArrayList<Posicion> parsearString(String input) {
        ArrayList<Posicion> posiciones = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            Posicion posicion = new Posicion(x, y);
            posiciones.add(posicion);
        }
        return posiciones;
    }

    /**
     * Metodo encargado de imprimir la matriz
     * @param matriz Celda[][] correspondiente a la matriz que se va a imprimir.
     */
    public static void imprimirMapa(Celda[][] matriz){
        char letra = 'A';
        System.out.print("    ");
        for (int s = 0; s < 17; s++){
            if (s<10){
                System.out.print(s + "  ");
            } else {
                System.out.print(s + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < 9; i++){
            System.out.print(letra + "  ");
            for (int j = 0; j < 17; j++){
                if (matriz[i][j] instanceof CeldaTerreno){
                    Torre torre = ((CeldaTerreno) matriz[i][j]).getTorre();
                    if (torre instanceof TorreBasica){
                        System.out.print("[B]");
                    } else if (torre instanceof TorreRango) {
                        System.out.print("[R]");
                    } else if (torre instanceof TorreArea) {
                        System.out.print("[A]");
                    } else if (torre instanceof TorreGeneradora) {
                        System.out.print("[G]");
                    } else if (torre instanceof TorreRalentizadora) {
                        System.out.print("[L]");
                    } else {
                        System.out.print("[ ]");
                    }
                } else if (matriz[i][j] instanceof CeldaCamino){
                    ArrayList<Enemigo> listaEnemigo;
                    listaEnemigo = ((CeldaCamino) matriz[i][j]).getListaEnemigos();
                    Cerro cerro = ((CeldaCamino) matriz[i][j]).getCerro();
                    Barricada barricada = ((CeldaCamino) matriz[i][j]).getBarricada();
                    if (cerro != null) {
                        System.out.print(" C ");
                    } else if (barricada != null) {
                        System.out.print("BBB");
                    } else {
                        if ((listaEnemigo == null) || (listaEnemigo.isEmpty())){
                            System.out.print("   ");
                        } else {
                            if (listaEnemigo.size() > 1){
                                System.out.print(" Va");
                            } else if (listaEnemigo.get(0) instanceof Humano){
                                System.out.print(" Hu");
                            } else if (listaEnemigo.get(0) instanceof Elfo){
                                System.out.print(" El");
                            } else if (listaEnemigo.get(0) instanceof Enano){
                                System.out.print(" En");
                            } else if (listaEnemigo.get(0) instanceof Hobbit){
                                System.out.print(" Ho");
                            } else if (listaEnemigo.get(0) instanceof Ent){
                                System.out.print(" Te");
                            } else {
                                System.out.print("   ");
                            }
                        }
                    }
                }
            }
            System.out.println("");
            letra++;
        }

    }

    /**
     * Metodo que define las Listas compuestas por Listas compuestas de Caracteres que representan enemigos y devuelve la lista correspondiente dependiendo la dificultad elegida.
     * @param dificultad correspondiente al nivel de dificultad elegido.
     * @return Lista compuesta de Listas compuestas por Caracteres representando enemigos.
     */
    public List<List<Character>> getOleadas(int dificultad) {
        List<List<Character>> oleada1 = new ArrayList<>();

        List<Character> oleada11 = new ArrayList<>();
        oleada11.add('H');
        oleada11.add('H');
        oleada11.add('H');

        List<Character> oleada12 = new ArrayList<>();
        oleada12.add('H');
        oleada12.add('H');
        oleada12.add('E');
        oleada12.add('H');

        List<Character> oleada13 = new ArrayList<>();
        oleada13.add('H');
        oleada13.add('E');
        oleada13.add('O');
        oleada13.add('H');
        oleada13.add('N');
        oleada13.add('N');

        List<Character> oleada14 = new ArrayList<>();
        oleada14.add('E');
        oleada14.add('E');
        oleada14.add('O');
        oleada14.add('H');
        oleada14.add('H');
        oleada14.add('N');
        oleada14.add('N');

        List<Character> oleada15 = new ArrayList<>();
        oleada15.add('E');
        oleada15.add('E');
        oleada15.add('H');
        oleada15.add('H');
        oleada15.add('H');
        oleada15.add('N');
        oleada15.add('N');
        oleada15.add('O');
        oleada15.add('O');

        List<Character> oleada16 = new ArrayList<>();
        oleada16.add('T');
        oleada16.add('T');

        oleada1.add(oleada11);
        oleada1.add(oleada12);
        oleada1.add(oleada13);
        oleada1.add(oleada14);
        oleada1.add(oleada15);
        oleada1.add(oleada16);

        // ========================================================================================

        List<List<Character>> oleada2 = new ArrayList<>();
        List<Character> oleada21 = new ArrayList<>();
        oleada21.add('H');
        oleada21.add('H');
        oleada21.add('H');
        oleada21.add('O');

        List<Character> oleada22 = new ArrayList<>();
        oleada22.add('H');
        oleada22.add('E');
        oleada22.add('E');
        oleada22.add('O');
        oleada22.add('N');

        List<Character> oleada23 = new ArrayList<>();
        oleada23.add('H');
        oleada23.add('N');
        oleada23.add('N');
        oleada23.add('O');
        oleada23.add('O');
        oleada23.add('O');
        oleada23.add('E');
        oleada23.add('E');

        List<Character> oleada24 = new ArrayList<>();
        oleada24.add('N');
        oleada24.add('N');
        oleada24.add('N');
        oleada24.add('O');
        oleada24.add('E');
        oleada24.add('O');
        oleada24.add('E');
        oleada24.add('E');

        List<Character> oleada25 = new ArrayList<>();
        oleada25.add('H');
        oleada25.add('H');
        oleada25.add('N');
        oleada25.add('N');
        oleada25.add('E');
        oleada25.add('E');
        oleada25.add('E');
        oleada25.add('E');

        List<Character> oleada26 = new ArrayList<>();
        oleada26.add('N');
        oleada26.add('N');
        oleada26.add('N');
        oleada26.add('N');
        oleada26.add('E');
        oleada26.add('E');
        oleada26.add('E');
        oleada26.add('E');

        List<Character> oleada27 = new ArrayList<>();
        oleada27.add('T');
        oleada27.add('T');
        oleada27.add('N');
        oleada27.add('N');


        oleada2.add(oleada21);
        oleada2.add(oleada22);
        oleada2.add(oleada23);
        oleada2.add(oleada24);
        oleada2.add(oleada25);
        oleada2.add(oleada26);
        oleada2.add(oleada27);

        // ========================================================================================

        List<List<Character>> oleada3 = new ArrayList<>();
        List<Character> oleada31 = new ArrayList<>();
        oleada31.add('H');
        oleada31.add('H');
        oleada31.add('H');
        oleada31.add('O');
        oleada31.add('O');

        List<Character> oleada32 = new ArrayList<>();
        oleada32.add('H');
        oleada32.add('E');
        oleada32.add('E');
        oleada32.add('O');
        oleada32.add('N');
        oleada32.add('O');

        List<Character> oleada33 = new ArrayList<>();
        oleada33.add('H');
        oleada33.add('N');
        oleada33.add('N');
        oleada33.add('O');
        oleada33.add('O');
        oleada33.add('O');
        oleada33.add('E');
        oleada33.add('E');
        oleada33.add('O');

        List<Character> oleada34 = new ArrayList<>();
        oleada34.add('N');
        oleada34.add('N');
        oleada34.add('N');
        oleada34.add('O');
        oleada34.add('E');
        oleada34.add('O');
        oleada34.add('E');
        oleada34.add('E');
        oleada34.add('O');
        oleada34.add('O');

        List<Character> oleada35 = new ArrayList<>();
        oleada35.add('H');
        oleada35.add('H');
        oleada35.add('N');
        oleada35.add('N');
        oleada35.add('E');
        oleada35.add('E');
        oleada35.add('E');
        oleada35.add('E');
        oleada35.add('O');
        oleada35.add('O');

        List<Character> oleada36 = new ArrayList<>();
        oleada36.add('N');
        oleada36.add('N');
        oleada36.add('N');
        oleada36.add('N');
        oleada36.add('E');
        oleada36.add('E');
        oleada36.add('E');
        oleada36.add('E');
        oleada36.add('O');
        oleada36.add('O');

        List<Character> oleada37 = new ArrayList<>();
        oleada37.add('T');
        oleada37.add('T');
        oleada37.add('N');
        oleada37.add('N');
        oleada37.add('N');

        oleada3.add(oleada31);
        oleada3.add(oleada32);
        oleada3.add(oleada33);
        oleada3.add(oleada34);
        oleada3.add(oleada35);
        oleada3.add(oleada36);
        oleada3.add(oleada37);

        // ========================================================================================

        if (dificultad == 1) {
            return oleada1;
        } else if (dificultad == 2) {
            return oleada2;
        } else {
            return oleada3;
        }
    }
}