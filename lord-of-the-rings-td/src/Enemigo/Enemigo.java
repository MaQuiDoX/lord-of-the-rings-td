package Enemigo;

import Celda.CeldaCamino;
import Celda.Cerro;
import Barricada.Barricada;
public class Enemigo {
    private int vida, velocidad, dano, magiaOtorgada;
    private String tipo;
    private CeldaCamino ubicacion;

    public Enemigo(int vida, int dano, int velocidad, int magiaOtorgada, String tipo, CeldaCamino ubicacion){
        this.vida = vida;
        this.dano = dano;
        this.velocidad = velocidad;
        this.magiaOtorgada = magiaOtorgada;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }
    public int getVida(){
        return this.vida;
    }
    public void setVida(int nuevaVida){
        this.vida = nuevaVida;
    }
    public int getDano(){
        return this.dano;
    }
    public int getVelocidad(){
        return this.velocidad;
    }
    public void setVelocidad(int nuevaVelocidad){
        this.velocidad = nuevaVelocidad;
    }
    public int getMagiaOtorgada(){
        return this.magiaOtorgada;
    }
    public String getTipo(){
        return this.tipo;
    }
    public CeldaCamino getUbicacion(){ // ADECUAR A COMO FUNCIONA LA UBICACION
        return this.ubicacion;
    }
    public void setUbicacion(CeldaCamino nuevaUbicacion){ // ADECUAR A COMO FUNCIONA LA UBICACION
        this.ubicacion = nuevaUbicacion;
    }
    public void moverEnemigo(Enemigo enemigo){  // Arreglar ultimos detalles
        CeldaCamino siguienteUbicacion;
        siguienteUbicacion = enemigo.getUbicacion();
        siguienteUbicacion = siguienteUbicacion.getSiguienteCelda();
        if (siguienteUbicacion instanceof Cerro){
            danarCerro(siguienteUbicacion);
            morir(enemigo);
            return;
        }
        if (siguienteUbicacion.getBarricada() instanceof Barricada){
            Barricada barricada = siguienteUbicacion.getBarricada();
            barricada.setVida(barricada.getVida() - dano);
            return;
        }
        setUbicacion(siguienteUbicacion);
        return;
    }
    public void danarCerro(Cerro cerro){cerro.setVida(cerro.getVida() - dano);}
    public void morir(Enemigo enemigo){
        enemigo.ubicacion = null; // to do: eliminarlo de la lista de la celda
        // Eliminar la unidad de la celda en donde esta ubicado
    }
}







