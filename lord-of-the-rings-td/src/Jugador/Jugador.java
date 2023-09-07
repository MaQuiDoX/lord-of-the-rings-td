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
    public static void mostrarTienda(){

    }
}
