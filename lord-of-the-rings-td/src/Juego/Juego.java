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
import Torre.TorreGeneradora;

public class Juego {
    private Mapa mapa;
    private Jugador jugador;
    ArrayList<Enemigo> listaEnemigosVivos;


    public Juego(){
        mapa = new Mapa();
        jugador = new Jugador();
        listaEnemigosVivos = new ArrayList<>();
    }

    public Jugador getJugador(){
        return jugador;
    }
    public ArrayList<Enemigo> getListaEnemigosVivos(){return listaEnemigosVivos;}

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
                    jugador.mostrarInterfaz();
                    menuPartida();
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

    public void menuPartida() {
        Scanner scanner = new Scanner(System.in);
        int opcion2, opcion3, opcion4, opcion5, opcion6, finalizador, fila, columna, oleadaActual;
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
                                            if (jugador.getMagia() < 100){
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            }else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaCamino) {
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre en el camino...");
                                                    break;
                                                } else if (((CeldaTerreno)celda).getTorre() != null){
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre donde ya hay una colocada...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 1, primerCelda);
                                                    jugador.setMagia(jugador.getMagia()-100);
                                                    ClearScreen.cls();
                                                    System.out.println();
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
                                            }
                                        } else if (opcion6 == 2) {
                                            if (jugador.getMagia() < 150) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaCamino) {
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre en el camino...");
                                                    break;
                                                } else if (((CeldaTerreno)celda).getTorre() != null){
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre donde ya hay una colocada...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 2, primerCelda);
                                                    jugador.setMagia(jugador.getMagia()-150);
                                                    ClearScreen.cls();
                                                    System.out.println();
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
                                            }
                                        } else if (opcion6 == 3) {
                                            if (jugador.getMagia() < 300) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaCamino) {
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre en el camino...");
                                                    break;
                                                } else if (((CeldaTerreno)celda).getTorre() != null){
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre donde ya hay una colocada...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 3, primerCelda);
                                                    jugador.setMagia(jugador.getMagia()-300);
                                                    ClearScreen.cls();
                                                    System.out.println();
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
                                            }
                                        } else if (opcion6 == 4) {
                                            if (jugador.getMagia() < 400) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaCamino) {
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre en el camino...");
                                                    break;
                                                } else if (((CeldaTerreno)celda).getTorre() != null){
                                                        System.out.println("No es posible realizar la compra, no se puede colocar una torre donde ya hay una colocada...");
                                                        break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 4, primerCelda);
                                                    jugador.setMagia(jugador.getMagia()-400);
                                                    ClearScreen.cls();
                                                    System.out.println();
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
                                            }
                                        } else if (opcion6 == 5) {
                                            if (jugador.getMagia() < 200) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaCamino) {
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre en el camino...");
                                                    break;
                                                } else if (((CeldaTerreno)celda).getTorre() != null){
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una torre donde ya hay una colocada...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 5, primerCelda);
                                                    jugador.setMagia(jugador.getMagia()-200);
                                                    ClearScreen.cls();
                                                    System.out.println();
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
                                            }
                                        } else if (opcion6 == 6) {
                                            if (jugador.getMagia() < 500) {
                                                System.out.println("No es posible realizar la compra...");
                                                break;
                                            } else {
                                                fila = colocarFila(fila);
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaTerreno) {
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una barricada fuera del camino...");
                                                    break;
                                                } else if (((CeldaCamino)celda).getBarricada() != null){
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una barrera donde ya hay una colocada...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 6, primerCelda);
                                                    jugador.setMagia(jugador.getMagia()-500);
                                                    ClearScreen.cls();
                                                    System.out.println();
                                                    Mapa.imprimirMapa(mapa.getMatriz());
                                                    Jugador.mostrarInterfaz();
                                                    break;
                                                }
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
                    int ol = jugador.getOleada();
                    ol++;
                    jugador.setOleada(ol);
                    oleadaActiva(mapa.getNivel(), ol);

                    if ((mapa.getNivel() == 1) && (ol == 5)){
                        finalizador = 1;
                    }
                    if ((mapa.getNivel() == 2) && (ol == 6)){
                        finalizador = 1;
                    }
                    if ((mapa.getNivel() == 3) && (ol == 7)){
                        finalizador = 1;
                    }

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
     * Método que gestiona lo que sucede cuando se empieza una oleada y durante su ejecución.
     * @param dificultad La dificultad elegida por el jugador para poder seleccionar bien la oleada correspondiente.
     * @param oleada La oleada en la cuál se encuentra el jugador en ese momento.
     */
    public void oleadaActiva(int dificultad, int oleada){
        int contSpawns = 0;
        int spawnTicks = 0;
        CeldaCamino celdaCerro = mapa.getFirstCeldaCamino();
        while (celdaCerro.getCerro() == null){  // Busqueda de la celda con el 'Cerro de la Gloria'
            celdaCerro = celdaCerro.getSiguienteCelda();
        }
        //-----PRUEBAS DE ERROR-----//
        int tick = 0;
        //-----PRUEBAS DE ERROR-----//
        List<List<Character>> listaEnemigosOleada = mapa.getOleadas(dificultad);
        while ((celdaCerro.getCerro().getVida() > 0) && // Vida actual del cerro > 0
                ((contSpawns < listaEnemigosOleada.get(oleada).size()) || // Cantidad de enemigos spawneados < Cantidad total de enemigos por ronda
                (listaEnemigosVivos.size() > 0))){  // Cantidad de enemigos vivos > 0
            try{
                Thread.sleep(100);
                //-----PRUEBAS DE ERROR-----//
                System.out.println("Tick Actual: "+ ++tick);
                //System.out.println(listaEnemigosOleada.get(oleada));
                //System.out.println(listaEnemigosOleada.get(oleada).get(contSpawns));
                System.out.println("Cerro.getVida() "+celdaCerro.getCerro().getVida());
                // System.out.println("listaEnemigosVivos "+listaEnemigosVivos);
                //-----PRUEBAS DE ERROR-----//
                if (contSpawns < listaEnemigosOleada.get(oleada).size()){
                    if (spawnTicks == 0){
                        Enemigo enemigoSpawned = elegirEnemigo(this, listaEnemigosOleada.get(oleada).get(contSpawns),
                                mapa.getFirstCeldaCamino());    // Se crea el enemigo que vendra en la oleada
                        listaEnemigosVivos.add(enemigoSpawned);   // Se añade el enemigo a lista de enemigos vivos
                        contSpawns++;
                        spawnTicks = spawnDelay(enemigoSpawned);    // Tiempo de retraso antes del proximo spawn
                    } else {
                        spawnTicks--;
                    }
                }
                int i = 0;
                while (listaEnemigosVivos.size() > i){  // Realizan las acciones las Torres
                    listaEnemigosVivos.get(i).waitingTick();
                    i++;
                }
                int j = 0;
                while (jugador.getTorresOnField().size() > j){  // Realizan las acciones los enemigos
                    jugador.getTorresOnField().get(j).waitingTick();
                    j++;
                }
                ClearScreen.cls();
                System.out.println();
                mapa.imprimirMapa(mapa.getMatriz());
                Jugador.mostrarInterfaz();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        if (celdaCerro.getCerro().getVida() > 0){
            int g = 0;
            while(jugador.getTorresOnField().size() > g){   // Añade magia y puntos por cada torre generadora
                if (jugador.getTorresOnField().get(g) instanceof TorreGeneradora){
                    ((TorreGeneradora) jugador.getTorresOnField().get(g)).generarMagia(jugador);
                    jugador.sumaPuntuacion(100);
                }
                g++;
            }
            jugador.sumaPuntuacion(1000);   // Suma puntos por pasar la oleada
            jugador.setMagia(jugador.getMagia() + 300); // Suma magia por pasar la oleada
        }

    }

    /**
     * Método que elige cuál enemigo será el siguiente en aparecer en el mapa.
     * @param letra Letra dentro de 'Lista de Enemigos en la Oleada'.
     * @param primeraCelda Celda que se encuentra al inicio del recorrido de los enemigos.
     * @return
     */
    private Enemigo elegirEnemigo(Juego juego, char letra, CeldaCamino primeraCelda){
        switch (letra){
            case 'H':   // H = Humano
                return new Humano(juego, primeraCelda);
            case 'O':   // O = Hobbit
                return new Hobbit(juego, primeraCelda);
            case 'E':   // E = Elfo
                return new Elfo(juego, primeraCelda);
            case 'N':   // N = Enano
                return new Enano(juego, primeraCelda);
            case 'T':   // T = Ent
                return new Ent(juego, primeraCelda);
        }
        return null;
    }
    private int spawnDelay(Enemigo enemigo){
        if (enemigo instanceof Hobbit){ return 6;}
        if (enemigo instanceof Elfo){ return 0;} // 16
        if (enemigo instanceof Enano){ return 24;}
        if (enemigo instanceof Ent){ return 64;}
        return 0; // 8
    }
    }
