package Juego;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Enemigo.*;
import Estructuras.Cerro;
import Mapa.*;
import Jugador.*;
import Celda.*;

public class Juego {
    private Mapa mapa;
    private Jugador jugador;

    public Juego(){
        mapa = new Mapa();
        jugador = new Jugador();
    }

    public Jugador getJugador(){
        return jugador;
    }

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
                if ((opcion == 1)||(opcion == 2)||(opcion == 3)) {
                    ClearScreen.cls();
                    System.out.println();
                    Celda[][] matriz = mapa.crearMapa(opcion);
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
        int opcion2, opcion3, opcion4, opcion5, opcion6, finalizador, fila, columna;
        int magiaActual = jugadorMain.getmagia();

        do {
            opcion3 = 0;
            opcion4 = 0;
            opcion5 = 0;
            opcion6 = 0;
            fila = 0;
            columna = 0;
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
                                            }else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaCamino){
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre en el camino...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 1, primerCelda);
                                                    jugador.setmagia(jugador.getmagia()-100);
                                                    ClearScreen.cls();
                                                    System.out.println();
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
                                            }
                                        } else if (opcion6 == 2) {
                                            if (magiaActual < 150) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaCamino){
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre en el camino...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 2, primerCelda);
                                                    jugador.setmagia(jugador.getmagia()-150);
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
                                            }
                                        } else if (opcion6 == 3) {
                                            if (magiaActual < 300) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaCamino){
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre en el camino...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 3, primerCelda);
                                                    jugador.setmagia(jugador.getmagia()-300);
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
                                            }
                                        } else if (opcion6 == 4) {
                                            if (magiaActual < 400) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaCamino){
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre en el camino...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 4, primerCelda);
                                                    jugador.setmagia(jugador.getmagia()-400);
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
                                            }
                                        } else if (opcion6 == 5) {
                                            if (magiaActual < 200) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaCamino){
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre en el camino...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 5, primerCelda);
                                                    jugador.setmagia(jugador.getmagia()-200);
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
                                            }
                                        } else if (opcion6 == 6) {
                                            if (magiaActual < 500) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
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
    public int colocarFila(int x) {
        Scanner scanner2 = new Scanner(System.in);
        char posX = 'a';
        System.out.println("En que fila desea colocar la torre (A-I)");
        do {
            try {
                posX = scanner2.next().charAt(0);
                if (posX == 'A') {
                    x = 0;
                    break;
                } else if (posX == 'B') {
                    x = 1;
                    break;
                } else if (posX == 'C') {
                    x = 2;
                    break;
                } else if (posX == 'D') {
                    x = 3;
                    break;
                } else if (posX == 'E') {
                    x = 4;
                    break;
                } else if (posX == 'F') {
                    x = 5;
                    break;
                } else if (posX == 'G') {
                    x = 6;
                    break;
                } else if (posX == 'H') {
                    x = 7;
                    break;
                } else if (posX == 'I') {
                    x = 8;
                    break;
                } else {
                    System.out.println("Opción inválida, ingrese nuevamente...");
                }
            } catch (InputMismatchException e6) {
                scanner2.nextLine();
                System.out.println("Opción inválida. Ingrese de nuevo.");
            }
        } while ((posX != 'A') || (posX != 'B') || (posX != 'C') || (posX != 'D') || (posX != 'E') || (posX != 'F') || (posX != 'G') || (posX != 'H') || (posX != 'I'));

        return x;

    }
    public int colocarColumna(int y){
        Scanner scanner3 = new Scanner(System.in);
        System.out.println();
        int posY = 17;
        System.out.println("En que columna desea colocar la torre (0-16)");
        do{
            try{
                posY = scanner3.nextInt();
                if ((posY < 17) && (posY >= 0)){
                    y = posY;
                    break;
                } else {
                    System.out.println("Opción inválida, ingrese nuevamente...");
                }
            } catch (InputMismatchException e7) {
                scanner3.nextLine();
                System.out.println("Opción inválida. Ingrese de nuevo.");
            }
        } while ((posY > 17) || (posY < 0));

        return y;
    }



    // ESTE MÉTODO DEBE LLAMARSE CUANDO SE ACEPTA EMPEZAR LA RONDA
    /**
     * Método que gestiona lo que sucede durante la duración de una oleada.
     * @param mapa Mapa para poder obtener las oleadas de enemigos y las celdas del camino.
     * @param dificultad La dificultad elegida por el jugador para poder seleccionar bien la oleada correspondiente.
     * @param oleada La oleada en la cuál se encuentra el jugador en ese momento.
     */
    /**public void oleadaActiva(Mapa mapa, int dificultad, int oleada){
        // ME FALTA RECIBIR COMO PARAMETRO LA LISTA DE TORRES ACTIVAS, PERO ESO LA TIENEN QUE HACER
        // CUANDO COMPRAN LAS TORRES RECOMIENDO QUE SEA PARECIDO A LA QUE USO CON ENEMIGOS OSEA,
        // QUE SEA MÁS O MENOS ASI: ArrayList<Torres> listaTorresActivas = new ArrayList<>();
        // PERO CLARO, ESAS TORRES DEBEN SER UN ATRIBUTO DEL JUGADOR, YA QUE ÉL LAS COMPRA
        // Y POR LO TANTO ÉL LAS POSEÉ
        ArrayList<Enemigo> listaEnemigosActivos = new ArrayList<>();
        int contSpawns = 0;
        // ARREGLAR ESTO, SE SUPONE QUE TENGO UN METODO QUE TRAE LA 'CeldaCamino' CON EL CERRO
        // O LA 1RA 'CeldaCamino' DEL MAPA, PREFERENTE ESTA ÚLTIMA PARA USARLA EN MÁS METODOS
        CeldaCamino celdaCerro = new CeldaCamino(null);
        celdaCerro.setCerro(new Cerro());
        // --------
        List<List<Character>> listaEnemigosOleada = mapa.getOleadas(dificultad);
        while ((celdaCerro.getCerro().getVida() > 0) &&
                (listaEnemigosActivos.size() < listaEnemigosOleada.get(oleada).size())){
            try{
                Thread.sleep(500);
                // CAMBIAR ESE 'new CeldaCamino(null)' POR LA 1RA 'CeldaCamino' DEL MAPA, ES MUY IMPORTANTE
                Enemigo enemigoSpawned = elegirEnemigo(listaEnemigosOleada.get(oleada).get(contSpawns),
                        new CeldaCamino(null));
                listaEnemigosActivos.add(enemigoSpawned);
                int i = 0;
                while (listaEnemigosActivos.size() > i){
                    listaEnemigosActivos.get(i).waitingTick();
                    i++;
                }
                int j = 0;
                while (listaTorresActivas.size() > j){
                    listaTorresActivas.get(j).waitingTick();
                    j++;
                }
                // VER SI ME FALTA AÑADIR ALGO MÁS, PERO CREO QUE ESTA TODO

            } catch(InterruptedException e){
                e.printStackTrace();
            }
            }
        }


     **/
    /**
     * Método que elige cuál enemigo será el siguiente en aparecer en el mapa.
     * @param letra Letra dentro de 'Lista de Enemigos en la Oleada'.
     * @param primeraCelda Celda que se encuentra al inicio del recorrido de los enemigos.
     * @return
     */
    private Enemigo elegirEnemigo(char letra, CeldaCamino primeraCelda){
        switch (letra){
            case 'H':   // H = Humano
                return new Humano(primeraCelda);
            case 'O':   // O = Hobbit
                return new Hobbit(primeraCelda);
            case 'E':   // E = Elfo
                return new Elfo(primeraCelda);
            case 'N':   // N = Enano
                return new Enano(primeraCelda);
            case 'T':   // T = Ent
                return new Ent(primeraCelda);
        }
        return null;
    }
    }
