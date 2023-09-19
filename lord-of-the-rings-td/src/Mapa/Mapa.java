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

public class Mapa {
    public Celda[][] matriz;
    static String nivel1 = "[(4,16), (4,15), (5,15), (6,15), (7,15), (8,15), (8,14), (8,13), (8,12), (8,11), (7,11), (6,11), (5,11), (4,11), (3,11), (3,12), (3,13), (2,13), (1,13), (1,12), (1,11), (1,10), (1,9), (2,9), (3,9), (4,9), (5,9), (6,9), (6,8), (6,7), (5,7), (4,7), (3,7), (2,7), (1,7), (1,6), (1,5), (1,4), (2,4), (3,4), (4,4), (4,5), (5,5), (6,5), (7,5), (7,4), (7,3), (7,2), (6,2), (5,2), (4,2), (3,2), (2,2), (1,2), (1,1), (1,0)]";
    static String nivel2 = "[(0,1), (16,4)]";
    static String nivel3 = "[(0,1), (16,4)]";
    public static ArrayList<Posicion> posicionesLvl1 = parsearString(nivel1);
    public static ArrayList<Posicion> posicionesLvl2 = parsearString(nivel2);
    public static ArrayList<Posicion> posicionesLvl3 = parsearString(nivel3);

    public CeldaCamino primerCelda;
    public int nivel = 0;

    public void mapa(){
        primerCelda = null;
        nivel = 0;
    }
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
    public int getNivel(){
        return this.nivel;
    }
    public Celda getMatrizCelda(int x, int y){
        return matriz[x][y];
    }

    public Celda[][] getMatriz(){
        return matriz;
    }

    public CeldaCamino getFirstCeldaCamino(){
        return this.primerCelda;
    }

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
    public List<List<Character>> getOleadas(int dificultad){
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
        List<Character> oleada14 = new ArrayList<>();
        oleada14.add('E');
        oleada14.add('E');
        oleada14.add('O');
        oleada14.add('H');
        oleada14.add('T');
        List<Character> oleada15 = new ArrayList<>();
        oleada15.add('E');
        oleada15.add('E');
        oleada15.add('O');
        oleada15.add('N');
        oleada15.add('T');
        oleada15.add('N');

        oleada1.add(oleada11);
        oleada1.add(oleada12);
        oleada1.add(oleada13);
        oleada1.add(oleada14);
        oleada1.add(oleada15);

        if (dificultad == 1){
            return oleada1;
        } else {
            int x = 1; // RELLENO
        }
        return oleada1;
    }
}