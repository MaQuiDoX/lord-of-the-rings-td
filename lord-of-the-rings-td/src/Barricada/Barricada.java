package Barricada;

import Celda.CeldaCamino;

public class Barricada {
    private int vida = 0;
    private int coste = 0;
    private int nivel = 0;
    private CeldaCamino celdaAsociada = null;

    public Barricada(int vida, int coste, int nivel, CeldaCamino celdaAsociada) {
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int nuevaVida) {
        this.vida = nuevaVida;
    }

    public void destruirse() {
        this.celdaAsociada.setBarricada((Barricada)null);
    }
}
