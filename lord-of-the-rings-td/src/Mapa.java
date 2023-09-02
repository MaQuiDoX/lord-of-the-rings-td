import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class Mapa {
    public static void main(String[] args){
        // Creo la matriz
        String[][] matriz = new String[17][9];
        char letra;
        letra = 'A';

        // BETA, camino matriz
        List <Posicion> posiciones = new ArrayList<>();
        posiciones.add(new Posicion(0,1));
        posiciones.add(new Posicion(1,1));
        posiciones.add(new Posicion(2,1));
        posiciones.add(new Posicion(2,2));
        posiciones.add(new Posicion(2,3));
        posiciones.add(new Posicion(2,4));
        posiciones.add(new Posicion(2,5));
        posiciones.add(new Posicion(2,6));
        posiciones.add(new Posicion(2,7));
        posiciones.add(new Posicion(3,7));
        posiciones.add(new Posicion(4,7));
        posiciones.add(new Posicion(5,7));
        posiciones.add(new Posicion(5,6));
        posiciones.add(new Posicion(5,5));
        posiciones.add(new Posicion(5,4));

        // Necesario añadir mas posiciones

        // Lleno matriz con posiciones
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 9; j++) {
                Posicion posicionActual = new Posicion(i, j);
                if (posiciones.contains(posicionActual)) {
                    matriz[i][j] = "   "; // Espacio vacío si está en la lista
                } else {
                    matriz[i][j] = "[ ]"; // Corchetes si no está en la lista
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
