package Mapa;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mapa {
    public static void printMapa1(int dificultad){
        // Creo la matriz
        String[][] matriz = new String[17][9];
        List<Posicion> posiciones;
        char letra;
        letra = 'A';

        // BETA, camino matriz
        String beta = "[(0,0)]";
        String nivel1 = "[(0,1), (1,1), (2,1), (2,2), (2,3), (2,4), (2,5), (2,6), (2,7), (3,7), (4,7), (5,7), (5,6), (5,5), (5,4), (4,4), (4,3), (4,2), (4,1), (5,1), (6,1), (7,1), (7,2), (7,3), (7,4), (7,5), (7,6), (8,6), (9,6), (9,5), (9,4), (9,3), (9,2), (9,1), (10,1), (11,1), (12,1), (13,1), (13,2), (13,3), (12,3), (11,3), (11,4), (11,5), (11,6), (11,7), (11,8), (12,8), (13,8), (14,8), (15,8), (15,7), (15,6), (15,5), (15,4) ,(16,4)]";
        String nivel2 = "[(0,1), (16,4)]";
        String nivel3 = "[(0,1), (16,4)]";

        if (dificultad == 1){
            posiciones = parsearString(nivel1);
        }else{
            if (dificultad == 2) {
                posiciones = parsearString(nivel2);
            }else{
                posiciones = parsearString(nivel3);
            }
        }

        //comprobacion posiciones (acceso O(n)? despues averiguo como funca bien)
        //for (Posicion posicion : posiciones) {
        //    System.out.println("x: " + posicion.x + ", y: " + posicion.y);
        //}

        // Lleno matriz con posiciones
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 9; j++) {
                Posicion posicionActual = new Posicion(i, j);
                if (posiciones.contains(posicionActual)) {
                    if (i == 16 && j == 4) {
                        matriz[i][j] = " C ";
                    } else {
                        matriz[i][j] = "   ";
                    }
                } else {
                    matriz[i][j] = "[ ]";
                }
            }
        }

        // Imprimir matriz
        System.out.print("    ");
        for (int i = 0; i < 17; i++){
            if (i<10){
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }

        }
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print(letra + "  ");
            for (int j = 0; j < 17; j++) {
                System.out.print(matriz[j][i]);
            }
            System.out.println();
            letra++;
        }
    }

    public static List<Posicion> parsearString(String input) {
        List<Posicion> posiciones = new ArrayList<>();
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
}
class Posicion {
    int x;
    int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Posicion posicion = (Posicion) obj;
        return x == posicion.x && y == posicion.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
