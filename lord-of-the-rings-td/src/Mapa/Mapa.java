package Mapa;

import java.util.ArrayList;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Celda.Celda;
import Celda.CeldaCamino;
import Celda.CeldaTerreno;

import Estructuras.Cerro;

import Enemigo.Enemigo;

import Torre.Torre;
import Torre.TorreBasica;
import Torre.TorreRango;
import Torre.TorreArea;
import Torre.TorreGeneradora;
import Torre.TorreRalentizadora;

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


            if ((x == 4) && (y == 16)) {
                matriz[x][y] = new Cerro();
            } else if ((x == 4) && (y == 15)) {
                matriz[x][y] = new CeldaCamino(matriz[5][16]);
            } else {
                matriz[x][y] = new CeldaCamino(matriz[oldX][oldY]);
            }
            oldX = x;
            oldY = y;
        }

        for (int s = 0; s < 9; s++) {
            for (int j = 0; j < 17; j++) {
                if (!(matriz[s][j] instanceof CeldaCamino) && !(matriz[s][j] instanceof Cerro)) {
                    matriz[s][j] = new CeldaTerreno();
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
                } else if (matriz[i][j] instanceof Cerro){
                    System.out.print(" C ");
                } else if (matriz[i][j] instanceof CeldaCamino){
                    ArrayList<Enemigo> listaEnemigo;
                    listaEnemigo = ((CeldaCamino) matriz[i][j]).getListaEnemigos();
                    if (listaEnemigo.size() > 1){
                        System.out.print(" Va");
                    } else {
                        System.out.print("   ");
                    }
                }
            }
            System.out.println("");
            letra++;
        }
    }
}


