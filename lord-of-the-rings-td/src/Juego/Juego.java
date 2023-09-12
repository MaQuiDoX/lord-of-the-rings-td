package Juego;
import java.util.Scanner;
import Mapa.Mapa;
import Juego.ClearScreen;
import Jugador.Jugador;

public class Juego {
    public void mostrarMenu(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println(" === DEFIENDE EL CERRO DE LA GLORIA === ");
        System.out.println("        1 . DIFICULTAD FACIL   ");
        System.out.println("        2 . DIFICULTAD MEDIA   ");
        System.out.println("        3 . DIFICULTAD DIFICIL ");
        System.out.println("        4 . CERRAR ");
        System.out.println("  ");
        System.out.println("Ingrese una opción");
        opcion = scanner.nextInt();

        while (opcion != 1 && opcion != 2 && opcion != 3 && opcion !=4) {
            System.out.println("Opción inválida. Ingrese de nuevo.");
            opcion = scanner.nextInt();
        }

        switch (opcion) {
            case 1:
                ClearScreen.cls();
                System.out.println();
                Mapa.printMapa1(1);
                Jugador.mostrarInterfaz();
                iniciarPartida();
                break;
            case 2:
                ClearScreen.cls();
                System.out.println();
                Mapa.printMapa1(2);
                Jugador.mostrarInterfaz();
                iniciarPartida();
                break;
            case 3:
                ClearScreen.cls();
                System.out.println();
                Mapa.printMapa1(3);
                Jugador.mostrarInterfaz();
                iniciarPartida();
                break;
            case 4:
                System.out.println("Cerrando...");
                System.exit(0);
        }
    }

    public void iniciarPartida(){
        int auxiliar = 0;
        int auxiliarTorresDesc, auxiliarEnemDesc;
        int opcion2, opcion3, opcion4, opcion5, opcion6;
        do {
            auxiliarTorresDesc = 0;
            auxiliarEnemDesc = 0;
            Scanner scanner2 = new Scanner(System.in);
            opcion2 = 0;
            opcion3 = 0;
            opcion4 = 0;
            opcion5 = 0;
            opcion6 = 0;

            System.out.println();
            Jugador.mostrarOpciones();

            opcion2 = scanner2.nextInt();
            while (opcion2 != 1 && opcion2 != 2 && opcion2 != 3 && opcion2 != 4 && opcion2 != 5) {
                System.out.println("Opción inválida. Ingrese de nuevo.");
                opcion2 = scanner2.nextInt();
            }
            switch (opcion2) {
                case 1:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println();
                    Jugador.mostrarOpcionesTorres();
                    opcion3 = scanner3.nextInt();

                    while (opcion3 != 1 && opcion3 != 2 && opcion3 != 3) {
                        System.out.println("Opción inválida. Ingrese de nuevo.");
                        opcion3 = scanner3.nextInt();
                    }
                    switch (opcion3) {
                        case 1:
                            Scanner scanner4 = new Scanner(System.in);
                            System.out.println();
                            Jugador.mostrarTienda();
                            opcion4 = scanner4.nextInt();

                            while (opcion4 != 1 && opcion4 != 2 && opcion4 != 3 && opcion4 != 4 && opcion4 != 5 && opcion4 != 6 && opcion4 != 7) {
                                System.out.println("Opción inválida. Ingrese de nuevo.");
                                opcion4 = scanner4.nextInt();
                            }

                            switch (opcion4) {
                                case 1: //colocar torre basica
                                case 2: //colocar torre rango
                                case 3: //colocar torre area
                                case 4: //colocar torre ralentizadora
                                case 5: //colocar torre generadora
                                case 6: //colocar barricada
                                case 7:
                                    break;
                            }
                        case 2:
                            //mejora torre
                        case 3:
                            break;
                    }
                case 2:
                    do {
                        Scanner scanner5 = new Scanner(System.in);
                        System.out.println();
                        Jugador.descripcionTorres();
                        opcion5 = scanner5.nextInt();

                        while (opcion5 != 1 && opcion5 != 2 && opcion5 != 3 && opcion5 != 4 && opcion5 != 5 && opcion5 != 6 && opcion5 != 7) {
                            System.out.println("Opción inválida. Ingrese de nuevo.");
                            opcion5 = scanner5.nextInt();
                        }

                        switch(opcion5){
                            case 1: //lore y caracteristicas torre basica
                                System.out.println("");
                                System.out.println("info torre basica");
                                System.out.println("");
                                break;
                            case 2: //lore y caracteristicas torre rango
                                System.out.println("");
                                System.out.println("info torre rango");
                                System.out.println("");
                                break;
                            case 3: //lore y caracteristicas torre area
                                System.out.println("");
                                System.out.println("info torre area");
                                System.out.println("");
                                break;
                            case 4: //lore y caracteristicas torre ralentizadora
                                System.out.println("");
                                System.out.println("info torre ralentizadora");
                                System.out.println("");
                                break;
                            case 5: //lore y caracteristicas torre generadora
                                System.out.println("");
                                System.out.println("info torre generadora");
                                System.out.println("");
                                break;
                            case 6: //lore y caracteristicas barricada
                                System.out.println("");
                                System.out.println("info barricada");
                                System.out.println("");
                                break;
                            case 7:
                                auxiliarTorresDesc++;
                                break;
                        }
                        auxiliarTorresDesc++;
                        break;
                    } while (auxiliarTorresDesc >= 1);
                    auxiliarTorresDesc = 0;
                    opcion6 = 0;
                case 3:
                    do {
                        Scanner scanner6 = new Scanner(System.in);
                        System.out.println();
                        Jugador.descripcionEnemigos();
                        opcion6 = scanner6.nextInt();

                        while (opcion6 != 1 && opcion6 != 2 && opcion6 != 3 && opcion6 != 4 && opcion6 != 5 && opcion6 != 6) {
                            System.out.println("Opción inválida. Ingrese de nuevo.");
                            opcion6 = scanner6.nextInt();
                        }

                        switch(opcion6){
                            case 1: //lore y caracteristicas humano
                                System.out.println("");
                                System.out.println("info humano");
                                System.out.println("");
                                break;
                            case 2: //lore y caracteristicas elfo
                                System.out.println("");
                                System.out.println("info elfo");
                                System.out.println("");
                                break;
                            case 3: //lore y caracteristicas enano
                                System.out.println("");
                                System.out.println("info enano");
                                System.out.println("");
                                break;
                            case 4: //lore y caracteristicas hobbit
                                System.out.println("");
                                System.out.println("info hobbit");
                                System.out.println("");
                                break;
                            case 5: //lore y caracteristicas ent
                                System.out.println("");
                                System.out.println("info ent");
                                System.out.println("");
                                break;
                            case 6:
                                break;
                        }
                        auxiliarEnemDesc++;
                        break;
                    } while (auxiliarEnemDesc >= 1);
                    auxiliarEnemDesc = 0;
                    opcion6 = 0;
                case 4:
                    // asociado a mapa.array de enemigos
                    System.out.println("");
                    System.out.println("info oleadas");
                    System.out.println("");
                case 5:
            }
            auxiliar++;
        } while (auxiliar <= 1);
    }

}


