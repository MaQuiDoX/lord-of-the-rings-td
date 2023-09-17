package Enemigo;

public class Enemigo {
    private int vida, velocidad, daño, magiaOtorgada; // Ver el tema de la ñ
    private String tipo, ubicacion;  // Hacer que ubicacion este enlazada con un objeto Celda

    public Enemigo(int vida, int daño, int velocidad, int magiaOtorgada, String tipo, String ubicacion){
        this.vida = vida;
        this.daño = daño;
        this.velocidad = velocidad;
        this.magiaOtorgada = magiaOtorgada;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }
    public void dañarCerro(){
        int vidaCerro = Cerro.getVida();
        vidaCerro -= daño;
        Cerro.setVida(vidaCerro);
    }
    public void moverEnemigo(){  // ADECUAR A COMO FUNCIONA LA UBICACION Y USAR OBJETOS
        if CeldaCamino.siguienteCelda() == Cerro(){
            dañarCerro();
            eliminarEntidad(Enemigo());
            return;
        }
        if CeldaCamino.siguienteCelda().barricada() == Barricada(){
            Barricada.setVida(Barricada.vida -= daño);
            return;
        }
        setUbicacion(CeldaCamino.siguienteCelda());
        return;
    }
    public void morir(){
        // Eliminar la unidad de la celda en donde esta ubicado
    }

    public int getVida(){
        return this.vida;
    }
    public void setVida(int nuevaVida){
        this.vida = nuevaVida;
    }
    public int getDaño(){
        return this.daño;
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
    public String getUbicacion(){ // ADECUAR A COMO FUNCIONA LA UBICACION
        return this.ubicacion;
    }
    public void setUbicacion(String nuevaUbicacion){ // ADECUAR A COMO FUNCIONA LA UBICACION
        this.ubicacion = nuevaUbicacion;
    }

}







