package Mapa;

import java.util.ArrayList;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Celda.Celda;
import Celda.CeldaCamino;
import Celda.CeldaTerreno;
import Celda.Cerro;

import Enemigo.Enemigo;
import Enemigo.Humano;
import Enemigo.Elfo;
import Enemigo.Enano;
import Enemigo.Hobbit;
import Enemigo.Ent;

public class Mapa {
    public static Celda[][] crearMapa(int dificultad) {
        Celda[][] matriz = new Celda[9][17];
        ArrayList<Posicion> posiciones;


        // BETA, camino matriz
        String beta = "[(0,0)]";
        String nivel1 = "[(4,16), (4,15), (5,15), (6,15), (7,15), (8,15), (8,14), (8,13), (8,12), (8,11), (7,11), (6,11), (5,11), (4,11), (3,11), (3,12), (3,13), (2,13), (1,13), (1,12), (1,11), (1,10), (1,9), (2,9), (3,9), (4,9), (5,9), (6,9), (6,8), (6,7), (5,7), (4,7), (3,7), (2,7), (1,7), (1,6), (1,5), (1,4), (2,4), (3,4), (4,4), (4,5), (5,5), (6,5), (7,5), (7,4), (7,3), (7,2), (6,2), (5,2), (4,2), (3,2), (2,2), (1,2), (1,1), (1,0)]";
        String nivel2 = "[(0,1), (16,4)]";
        String nivel3 = "[(0,1), (16,4)]";

        if (dificultad == 1) {
            posiciones = parsearString(nivel1);
        } else {
            if (dificultad == 2) {
                posiciones = parsearString(nivel2);
            } else {
                posiciones = parsearString(nivel3);
            }
        }
        int oldX = 0;
        int oldY = 0;
        for (int i = 0; i < posiciones.size(); i++) {
            int x = posiciones.get(i).getX();
            int y = posiciones.get(i).getY();

            if ((x == 5) && (y == 16)) {
                matriz[x][y] = new Cerro();
            } else if ((x == 5) && (y == 15)) {
                matriz[x][y] = new CeldaCamino(matriz[5][16]);
            } else {
                matriz[x][y] = new CeldaCamino(matriz[oldX][oldY]);
            }
            oldX = x;
            oldY = y;

            for (int i = 0; i < 9; i++) {
                for (int j = 0; i < 17; i++) {
                    if (matriz[i][j] == null) {
                        matriz[i][j] = new CeldaTerreno();
                    }
                }
            }
        }
        return matriz;
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

    public Celda getMatrizCelda(int x, int y) {
        return Celda[x][y];
    }
    public imprimirMapa(Celda[][] matriz){
        char letra = 'A';
        System.out.print("    ");
        for (int i = 0; i < 17; i++){
            if (i<10){
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }
        }

        for (int i = 0; i < matriz.length; i++){
            System.out.print(letra + "  ");
            for (int j = 0; matriz[i].length; j++){
                if (matriz[i][j] instanceof CeldaTerreno){
                    System.out.print("[ ]");
                } else if (matriz[i][j] instanceof CeldaCamino){
                    ArrayList<Enemigo> listaEnemigo;
                    listaEnemigo = ((CeldaCamino) matriz[i][j]).getListaEnemigos();
                    if (listaEnemigo.size() > 1){
                        System.out.print(" Va");
                    } else {
                        if (listaEnemigo.get(0) instanceof Humano){
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
                } else if (matriz[i][j] instanceof Cerro){
                    System.out.print(" C ");
                }
            }
            System.out.println();
            letra++;
        }
    }
}


