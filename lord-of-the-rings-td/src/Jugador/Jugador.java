package Jugador;
//import Celda.CeldaCerro

public class Jugador {
    static int magiaJuego = 0; //ESTO CAMBIARLO, NO ESTOY SEGURO DE COMO, PERO NO PUEDO IMPRIMIR VALORES NO ESTATICOS
    static int puntuacionJuego = 0; //ESTO TAMBIEN

    public static void mostrarInterfaz() {
        System.out.println("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Magia: " + magiaJuego + " - Puntuación: " + puntuacionJuego + " ||| Vida Cerro: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Glosario:");
        System.out.println("Enemigos: Hu: Humano -- El: Elfo -- En: Enano -- Ho: Hobbit -- T: Ent -- V: Varios enemigos");
        System.out.println("Torres: B: Torre Básica -- R: Torre Rango -- A: Torre Área -- RR: Torre Ralentizadora");
        System.out.println("        G: Torre Generadora -- BB: Barricada ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void mostrarOpciones() {
        System.out.println("¿Qué desea hacer?:");
        System.out.println("1. Fortalecer defensas");
        System.out.println("2. Descripción de Torres");
        System.out.println("3. Descripción de Enemigos");
        System.out.println("4. Conocer siguiente oleada");
        System.out.println("5. Comenzar oleada");
    }

    public static void mostrarOpcionesTorres() {
        System.out.println("¿Qué desea hacer?:");
        System.out.println("1. Colocar una Torre");
        System.out.println("2. Mejorar una Torre");
        System.out.println("3. Volver para atrás");
    }

    public static void mostrarTienda(){
        System.out.println("1. Colocar Torre Básica (100 coste de magia)");
        System.out.println("2. Colocar Torre de Rango (150 coste de magia)");
        System.out.println("3. Colocar Torre de Área (300 coste de magia)");
        System.out.println("4. Colocar Torre Ralentizadora (400 coste de magia)");
        System.out.println("5. Colocar Torre Generadora (200 coste de magia)");
        System.out.println("6. Colocar Barricada (500 coste de magia)");
        System.out.println("7. Volver para atrás");
    }

    public static void descripcionTorres() {
        System.out.println("¿Acerca de que Torre quieres saber más?");
        System.out.println("1. Torre Básica");
        System.out.println("2. Torre de Rango");
        System.out.println("3. Torre de Área");
        System.out.println("4. Torre Ralentizadora");
        System.out.println("5. Torre Generadora");
        System.out.println("6. Barricada");
        System.out.println("7. Volver atrás");
    }

    public static void descripcionEnemigos() {
        System.out.println("¿Acerca de que Enemigo quieres saber más?");
        System.out.println("1. Humano");
        System.out.println("2. Elfo");
        System.out.println("3. Enano");
        System.out.println("4. Hobbit");
        System.out.println("5. Ent");
        System.out.println("6. Volver atrás");
    }
}