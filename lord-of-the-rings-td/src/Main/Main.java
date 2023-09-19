package Main;
import Juego.Juego;
import Jugador.Jugador;

public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.mostrarMenu(juego.getJugador());
    }
}
