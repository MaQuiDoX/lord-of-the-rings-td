package Juego;
import java.util.InputMismatchException;
import java.util.Scanner;
import Mapa.Mapa;
import Juego.ClearScreen;
import Jugador.Jugador;
import Celda.Celda;

public class Juego {
    public void mostrarMenu(Jugador jugadorMain) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println(" === DEFIENDE EL CERRO DE LA GLORIA === ");
        System.out.println("        1 . DIFICULTAD FACIL   ");
        System.out.println("        2 . DIFICULTAD MEDIA   ");
        System.out.println("        3 . DIFICULTAD DIFICIL ");
        System.out.println("        4 . CERRAR ");
        System.out.println("  ");
        System.out.println("Ingrese una opción");

        do {
            try {
                opcion = scanner.nextInt();
                if (opcion == 1) {
                    ClearScreen.cls();
                    System.out.println();
                    Celda[][] matriz = Mapa.crearMapa(1);
                    Mapa.imprimirMapa(matriz);
                    Jugador.mostrarInterfaz();
                    menuPartida(jugadorMain);
                    break;
                } else if (opcion == 2) {
                    ClearScreen.cls();
                    System.out.println();
                    Celda[][] matriz = Mapa.crearMapa(2);
                    Mapa.imprimirMapa(matriz);
                    Jugador.mostrarInterfaz();
                    menuPartida(jugadorMain);
                    break;
                } else if (opcion == 3) {
                    ClearScreen.cls();
                    System.out.println();
                    Celda[][] matriz = Mapa.crearMapa(3);
                    Mapa.imprimirMapa(matriz);
                    Jugador.mostrarInterfaz();
                    menuPartida(jugadorMain);
                    break;
                } else if (opcion == 4) {
                    System.out.println("Cerrando...");
                    System.exit(0);
                } else {
                    System.out.println("Opción inválida. Ingrese de nuevo.");
                }
            } catch (InputMismatchException e1) {
                scanner.nextLine();
                System.out.println("Opción inválida. Ingrese de nuevo.");
            }
        } while ((opcion > 4) || (opcion < 1));
    }

    public void menuPartida(Jugador jugadorMain) {
        Scanner scanner = new Scanner(System.in);
        int opcion2, opcion3, opcion4, opcion5, opcion6, finalizador;
        int magiaActual = jugadorMain.getmagia();

        do {
            opcion3 = 0;
            opcion4 = 0;
            opcion5 = 0;
            opcion6 = 0;
            finalizador = 0;
            System.out.println();
            Jugador.mostrarOpciones();
            try {
                opcion2 = scanner.nextInt();
                if (opcion2 == 1) {
                    System.out.println();
                    Jugador.mostrarOpcionesTorres();
                    do {
                        try {
                            opcion3 = scanner.nextInt();
                            if (opcion3 == 1) {
                                System.out.println();
                                Jugador.mostrarTienda();
                                do{
                                    System.out.println();
                                    try{
                                        opcion6 = scanner.nextInt();
                                        if (opcion6 == 1){
                                            if (magiaActual < 100){
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            }else{
                                                //COLOCAR TORRE BASICA
                                            }
                                        } else if (opcion6 == 1) {
                                            if (magiaActual < 150) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                //COLOCAR TORRE RANGO
                                                //ACTUALIZAR MAPA
                                            }
                                        } else if (opcion6 == 3) {
                                            if (magiaActual < 300) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                //COLOCAR TORRE AREA
                                                //ACTUALIZAR MAPA
                                            }
                                        } else if (opcion6 == 4) {
                                            if (magiaActual < 400) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                //COLOCAR TORRE RALENTIZADORA
                                                //ACTUALIZAR MAPA
                                            }
                                        } else if (opcion6 == 5) {
                                            if (magiaActual < 200) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                //COLOCAR TORRE GENERADORA
                                                //ACTUALIZAR MAPA
                                            }
                                        } else if (opcion6 == 6) {
                                            if (magiaActual < 500) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                //COLOCAR BARRICADA
                                                //ACTUALIZAR MAPA
                                            }
                                        }else if (opcion6 == 7){
                                            break;

                                        } else {
                                            System.out.println("Opción inválida. Ingrese de nuevo.");
                                        }
                                    } catch (InputMismatchException e6){
                                        scanner.nextLine();
                                        System.out.println("Opción inválida. Ingrese de nuevo.");
                                    }
                                }while((opcion6>7)||(opcion6<1));

                            } else if (opcion3 == 2) {
                                System.out.println("");
                                System.out.println("MEJORA");
                                //MEJORA TORRE
                                System.out.println("");
                            } else if (opcion3 == 3) {
                                break;
                            } else {
                                System.out.println("Opción inválida. Ingrese de nuevo.");
                            }
                        } catch (InputMismatchException e3) {
                            scanner.nextLine();
                            System.out.println("Opción inválida. Ingrese de nuevo.");
                        }
                    } while ((opcion3 > 3) || (opcion3 < 1));

                } else if (opcion2 == 2) {
                    System.out.println();
                    Jugador.descripcionTorres();
                    do {
                        try {
                            opcion4 = scanner.nextInt();
                            if (opcion4 == 1) {
                                System.out.println("");
                                System.out.println("Info Torre Basica");
                                System.out.println("");
                            } else if (opcion4 == 2) {
                                System.out.println("");
                                System.out.println("Info Torre Rango");
                                System.out.println("");
                            } else if (opcion4 == 3) {
                                System.out.println("");
                                System.out.println("Info Torre Area");
                                System.out.println("");
                            } else if (opcion4 == 4) {
                                System.out.println("");
                                System.out.println("Info Torre Ralentizadora");
                                System.out.println("");
                            } else if (opcion4 == 5) {
                                System.out.println("");
                                System.out.println("Info Torre Generadora");
                                System.out.println("");
                            } else if (opcion4 == 6) {
                                System.out.println("");
                                System.out.println("Info Barricada");
                                System.out.println("");
                            } else if (opcion4 == 7) {
                                break;
                            } else {
                                System.out.println("Opción inválida. Ingrese de nuevo.");
                            }
                        } catch (InputMismatchException e4) {
                            scanner.nextLine();
                            System.out.println("Opción inválida. Ingrese de nuevo.");
                        }
                    } while ((opcion4 > 7) || (opcion4 < 1));
                } else if (opcion2 == 3) {
                    System.out.println();
                    Jugador.descripcionEnemigos();
                    do {
                        try {
                            opcion5 = scanner.nextInt();
                            if (opcion5 == 1) {
                                System.out.println("");
                                System.out.println("Info Humano");
                                System.out.println("");
                            } else if (opcion5 == 2) {
                                System.out.println("");
                                System.out.println("Info Elfo");
                                System.out.println("");
                            } else if (opcion5 == 3) {
                                System.out.println("");
                                System.out.println("Info Enano");
                                System.out.println("");
                            } else if (opcion5 == 4) {
                                System.out.println("");
                                System.out.println("Info Hobbit");
                                System.out.println("");
                            } else if (opcion5 == 5) {
                                System.out.println("");
                                System.out.println("Info Ent");
                                System.out.println("");
                            } else if (opcion5 == 6) {
                                break;
                            } else {
                                System.out.println("Opción inválida. Ingrese de nuevo.");
                            }
                        } catch (InputMismatchException e5) {
                            scanner.nextLine();
                            System.out.println("Opción inválida. Ingrese de nuevo.");
                        }
                    } while ((opcion5 > 6) || (opcion5 < 1));

                } else if (opcion2 == 4) {
                    System.out.println("");
                    System.out.println("Info oleada...");
                    System.out.println("");
                } else if (opcion2 == 5) {
                    finalizador = 1;

                } else {
                    System.out.println("Opción inválida. Ingrese de nuevo.");
                }
            } catch (InputMismatchException e2) {
                scanner.nextLine();
                System.out.println("Opción inválida. Ingrese de nuevo.");
            }
        } while (finalizador == 0);
    }
}