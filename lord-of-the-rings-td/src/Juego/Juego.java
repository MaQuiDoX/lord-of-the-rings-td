package Juego;
import java.util.Scanner;
import Mapa.Mapa;

public class Juego {
    public void mostrarMenu(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println(" === DEFIENDE EL CERRO DE LA GLORIA === ");
            System.out.println("        1 . DIFICULTAD FACIL   ");
            System.out.println("        2 . DIFICULTAD MEDIA   ");
            System.out.println("        3 . DIFICULTAD DIFICIL ");
            System.out.println("        4 . CERRAR ");
            System.out.println("  ");
            System.out.println("Ingrese una opción");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Mapa.printMapa1(args);
                case 2:
                    //iniciarPartida(2)
                case 3:
                    //iniciarPartida(3)
                case 4:
                    System.out.println("Cerrando...");
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese de nuevo.");

            }
        } while (opcion != 3);
    }

    //private void iniciarPartida()
    //en este segun numero ingresado seria elegir una dificultad
}


