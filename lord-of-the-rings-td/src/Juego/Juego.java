package Juego;
import java.text.BreakIterator;
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
        int opcion2, opcion3, opcion4, opcion5, opcion6, finalizador, fila, columna, ol;
        do {
            ol = 0;
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
                                                System.out.println("En que fila desea colocar la torre (A-I)");
                                                fila = colocarFila(fila);
                                                System.out.println("En que columna desea colocar la torre (0-16)");
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
                                                    jugador.comprarTorre(celda, 1, fila, columna, primerCelda);
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
                                                System.out.println("En que fila desea colocar la torre (A-I)");
                                                fila = colocarFila(fila);
                                                System.out.println("En que columna desea colocar la torre (0-16)");
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
                                                    jugador.comprarTorre(celda, 2,fila, columna, primerCelda);
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
                                                System.out.println("En que fila desea colocar la torre (A-I)");
                                                fila = colocarFila(fila);
                                                System.out.println("En que columna desea colocar la torre (0-16)");
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
                                                    jugador.comprarTorre(celda, 3,fila, columna, primerCelda);
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
                                                System.out.println("En que fila desea colocar la torre (A-I)");
                                                fila = colocarFila(fila);
                                                System.out.println("En que columna desea colocar la torre (0-16)");
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
                                                    jugador.comprarTorre(celda, 4,fila, columna, primerCelda);
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
                                                System.out.println("En que fila desea colocar la torre (A-I)");
                                                fila = colocarFila(fila);
                                                System.out.println("En que columna desea colocar la torre (0-16)");
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
                                                    jugador.comprarTorre(celda, 5,fila, columna, primerCelda);//
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
                                                System.out.println("En que fila desea colocar la barricada (A-I)");
                                                fila = colocarFila(fila);
                                                System.out.println("En que columna desea colocar la barricada (0-16)");
                                                columna = colocarColumna(columna);
                                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                                if (celda instanceof CeldaTerreno) {
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una barricada fuera del camino...");
                                                    break;
                                                } else if (((CeldaCamino)celda).getBarricada() != null) {
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una barrera donde ya hay una colocada...");
                                                    break;
                                                } else if ((fila == 1) && (columna == 0)) {
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una barrera al principio del camino...");
                                                    break;
                                                } else if (((CeldaCamino)celda).getCerro()!=null) {
                                                    System.out.println("No es posible realizar la compra, no se puede colocar una barrera en el cerro...");
                                                    break;
                                                } else {
                                                    CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                                    jugador.comprarTorre(celda, 6,fila, columna, primerCelda);
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
                                if (jugador.getMagia() > 200){
                                    System.out.println("En que fila se encuentra la torre que desea mejorar (A-I)");
                                    fila = colocarFila(fila);
                                    System.out.println("En que columna se encuentra la torre que desea mejorar (0-16)");
                                    columna = colocarColumna(columna);
                                    Celda celda = mapa.getMatrizCelda(fila, columna);
                                    if (celda instanceof CeldaTerreno) {
                                        if (((CeldaTerreno) celda).getTorre() == null) {
                                            System.out.println("Aqui no se encuentra ninguna torre para mejorar...");
                                            break;
                                        }
                                        CeldaCamino primerCelda = mapa.getFirstCeldaCamino();
                                        jugador.mejorarTorre((CeldaTerreno)celda, primerCelda);
                                        jugador.setMagia(jugador.getMagia()-200);
                                        ClearScreen.cls();
                                        System.out.println();
                                        Mapa.imprimirMapa(mapa.getMatriz());
                                        Jugador.mostrarInterfaz();
                                        break;
                                    } else if (celda instanceof CeldaCamino){
                                        if (((CeldaCamino) celda).getCerro() != null) {
                                            System.out.println("No puedes mejorar el Cerro...");
                                            break;
                                        } else if (((CeldaCamino) celda).getBarricada() == null) {
                                            System.out.println("Esta es una posicion para camino. Aqui no se encuentra ninguna barricada para mejorar...");
                                            break;
                                        }
                                        jugador.mejorarBarricada(((CeldaCamino) celda).getBarricada());
                                        jugador.setMagia(jugador.getMagia()-200);
                                        ClearScreen.cls();
                                        System.out.println();
                                        Mapa.imprimirMapa(mapa.getMatriz());
                                        Jugador.mostrarInterfaz();
                                        break;
                                    } else {
                                        System.out.println("No tienes la cantidad suficiente de magia para realizar una mejora...");
                                        break;
                                    }
                                }
                            } else if (opcion3 == 3) {
                                System.out.println("En que fila se encuentra la torre que desea eliminar (A-I)");
                                fila = colocarFila(fila);
                                System.out.println("En que columna se encuentra la torre que desea eliminar (0-16)");
                                columna = colocarColumna(columna);
                                Celda celda = mapa.getMatrizCelda(fila, columna);
                                if (celda instanceof CeldaCamino) {
                                    if (((CeldaCamino)celda).getCerro() != null){
                                        System.out.println("No puedes eliminar el cerro");
                                        break;
                                    } else if (((CeldaCamino) celda).getBarricada() == null) {
                                        System.out.println("En esta posicion no se encuentra una barrera para eliminar...");
                                        break;
                                    } else {
                                        System.out.println("No es necesario eliminar una barrera...");
                                        break;
                                    }
                                } else if (celda instanceof CeldaTerreno) {
                                    if (((CeldaTerreno) celda).getTorre() == null){
                                        System.out.println("En esta posicion no se encuentra una torre para eliminar...");
                                        break;
                                    }
                                    jugador.venderTorre((CeldaTerreno) celda);
                                    jugador.setMagia(jugador.getMagia()+100);
                                    ClearScreen.cls();
                                    System.out.println();
                                    Mapa.imprimirMapa(mapa.getMatriz());
                                    Jugador.mostrarInterfaz();
                                    break;
                                }

                            } else if (opcion3 == 4) {
                                break;
                            } else {
                                System.out.println("Opción inválida. Ingrese de nuevo.");
                            }
                        } catch (InputMismatchException e3) {
                            scanner.nextLine();
                            System.out.println("Opción inválida. Ingrese de nuevo.");
                        }
                    } while ((opcion3 > 4) || (opcion3 < 1));

                } else if (opcion2 == 2) {
                    System.out.println();
                    Jugador.descripcionTorres();
                    do {
                        try {
                            opcion4 = scanner.nextInt();
                            if (opcion4 == 1) {
                                System.out.println("");
                                System.out.println("Torre Basica:");
                                System.out.println(" + Descripción: Torre confiable que dispara flechas a los enemigos cercanos para defender tu cerro");
                                System.out.println(" + Daño: 10 (+10 mejora de nivel 1)");
                                System.out.println(" + Velocidad: 2 (+1 mejora a nivel 2)");
                                System.out.println(" + Alcance: 2 (+1 mejora a nivel3)");
                                System.out.println(" + Tipo de daño: Daño básico");
                                System.out.println(" + Coste de mejora: 200 de magia");
                                System.out.println("");
                            } else if (opcion4 == 2) {
                                System.out.println("");
                                System.out.println("Torre Rango:");
                                System.out.println(" + Descripción: Torre especializada en disparar proyectiles de largo alcance con precisión letal");
                                System.out.println(" + Daño: 20 (+10 mejora de nivel 1)");
                                System.out.println(" + Velocidad: 2 (+1 mejora de nivel 2)");
                                System.out.println(" + Alcance: 4 (+1 mejora de nivel 3)");
                                System.out.println(" + Tipo de daño: Daño en rango");
                                System.out.println(" + Coste de mejora: 300 de magia");
                                System.out.println("");
                            } else if (opcion4 == 3) {
                                System.out.println("");
                                System.out.println("Torre Area:");
                                System.out.println(" + Descripción: Torre mágica que libera hechizos explosivos para dañar múltiples enemigos a la vez");
                                System.out.println(" + Daño: 20 (+10 mejora de nivel 1)");
                                System.out.println(" + Velocidad: 4 (+1 mejora de nivel 2)");
                                System.out.println(" + Alcance: 2 (+1 mejora de nivel 3)");
                                System.out.println(" + Tipo de daño: Daño en área");
                                System.out.println(" + Coste de mejora: 200 de magia");
                                System.out.println("");
                            } else if (opcion4 == 4) {
                                System.out.println("");
                                System.out.println("Torre Ralentizadora:");
                                System.out.println(" + Descripción:  Torre que emite una aura gélida que desacelera a los invasores");
                                System.out.println(" + Velocidad: 3 (+1 mejora a nivel 1, +1 a nivel 2)");
                                System.out.println(" + Alcance: 1 (+1 mejora a nivel3)");
                                System.out.println(" + Coste de mejora: 300 de magia");
                                System.out.println("");
                            } else if (opcion4 == 5) {
                                System.out.println("");
                                System.out.println("Torre Generadora:");
                                System.out.println(" + Descripción: Una estructura que acumula y canaliza capital mágico luego de cada oleada");
                                System.out.println(" + Ganancia por ronda: 10 de magia ()");
                                System.out.println(" + Coste de mejora: 300 de magia");
                                System.out.println("");
                            } else if (opcion4 == 6) {
                                System.out.println("");
                                System.out.println("Barricada:");
                                System.out.println(" + Descripción: Una sólida barrera que bloquea el avance de los enemigos, ganando tiempo para tus torres");
                                System.out.println(" + Vida: 10 (+10 mejora a nivel 1, +10 mejora a nivel 2, +10 mejora a nivel 3)");
                                System.out.println(" + Coste de mejora: 200 de magia");
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
                                System.out.println(" -- HUMANO -- ");
                                System.out.println("Guerreros humanos que marchan hacia tu Cerro, armados con espadas y escudos, listos para la batalla");
                                System.out.println("");
                            } else if (opcion5 == 2) {
                                System.out.println("");
                                System.out.println(" -- ELFO -- ");
                                System.out.println("Ágiles arqueros elfos que disparan flechas con precisión, dañando con mayor eficacia tu Cerro");
                                System.out.println("");
                            } else if (opcion5 == 3) {
                                System.out.println("");
                                System.out.println(" -- ENANO -- ");
                                System.out.println("Resistentes enanos que avanzan lentamente, con una gran resistencia a los ataques");
                                System.out.println("");
                            } else if (opcion5 == 4) {
                                System.out.println("");
                                System.out.println(" -- HOBBIT -- ");
                                System.out.println("Pequeños y debiles pero agiles y astutos, los hobbits intentan infiltrarse rapidamente en el Cerro");
                                System.out.println("");
                            } else if (opcion5 == 5) {
                                System.out.println("");
                                System.out.println(" -- ENT -- ");
                                System.out.println("Criaturas gigantes de la naturaleza que avanzan lentamente pero son difíciles de derrotar.");
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
                    System.out.println(" -- SIGUIENTE OLEADA: " + ol + " -- ");

                } else if (opcion2 == 5) {
                    ol = jugador.getOleada();
                    ol++;
                    jugador.setOleada(ol);
                    oleadaActiva(mapa.getNivel(), ol);
                    CeldaCamino celdaCerro = (CeldaCamino) mapa.getMatrizCelda(4,16);
                    if (celdaCerro.getCerro().getVida() < 1){
                        ClearScreen.cls();
                        System.out.println(" === GAME OVER ===");
                        System.out.println(" --- PUNTUACION FINAL: " + jugador.getPuntuacion() + " --- ");
                        finalizador = 1;
                    }

                    if ((mapa.getNivel() == 1) && (ol == 4)){
                        ClearScreen.cls();
                        System.out.println(" === FELICIDADES, EL CERRO SOBREVIVIÓ A LAS OLEADAS DE ENEMIGOS === ");
                        System.out.println(" --- PUNTUACION FINAL: " + jugador.getPuntuacion() + " --- ");
                        finalizador = 1;
                    }
                    if ((mapa.getNivel() == 2) && (ol == 5)){
                        ClearScreen.cls();
                        System.out.println(" === FELICIDADES, EL CERRO SOBREVIVIÓ A LAS OLEADAS DE ENEMIGOS === ");
                        System.out.println(" --- PUNTUACION FINAL: " + jugador.getPuntuacion() + " --- ");
                        finalizador = 1;
                    }
                    if ((mapa.getNivel() == 3) && (ol == 6)){
                        ClearScreen.cls();
                        System.out.println(" === FELICIDADES, EL CERRO SOBREVIVIÓ A LAS OLEADAS DE ENEMIGOS === ");
                        System.out.println(" --- PUNTUACION FINAL: " + jugador.getPuntuacion() + " --- ");
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
        jugador.setOleada(0);
        jugador.setMagia(500);
        mostrarMenu(jugador);
    }
    public int colocarFila(int x) {
        Scanner scanner2 = new Scanner(System.in);
        char posX = 'a';
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
        int posY = 17;
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
        int contDelay = 0;
        CeldaCamino celdaCerro = mapa.getFirstCeldaCamino();
        while (celdaCerro.getCerro() == null){  // Busqueda de la celda con el 'Cerro de la Gloria'
            celdaCerro = celdaCerro.getSiguienteCelda();
        }
        List<List<Character>> listaEnemigosOleada = mapa.getOleadas(dificultad);
        while ((celdaCerro.getCerro().getVida() > 0) && // Vida actual del cerro > 0
                ((contSpawns < listaEnemigosOleada.get(oleada).size()) || // Cantidad de enemigos spawneados < Cantidad total de enemigos por ronda
                (listaEnemigosVivos.size() > 0))){  // Cantidad de enemigos vivos > 0
            try{
                Thread.sleep(100);
                if (contSpawns < listaEnemigosOleada.get(oleada).size()){
                    if (contDelay == 0){
                        Enemigo enemigoSpawned = elegirEnemigo(this, listaEnemigosOleada.get(oleada).get(contSpawns),
                                mapa.getFirstCeldaCamino());    // Se crea el enemigo que vendra en la oleada
                        listaEnemigosVivos.add(enemigoSpawned);   // Se añade el enemigo a lista de enemigos vivos
                        contSpawns++;
                        contDelay = spawnDelay(enemigoSpawned);
                    } else {
                        contDelay--;
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
                System.out.println(" === VIDA CERRO: " + celdaCerro.getCerro().getVida() + " === ");
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
        if (enemigo instanceof Elfo){ return 8;} // 16
        if (enemigo instanceof Enano){ return 24;}
        if (enemigo instanceof Ent){ return 64;}
        return 4; // 8
    }
}
