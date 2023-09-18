package Celda;

public abstract class Celda<T> {
    private T celda;
    protected int coorX;
    protected int coorY;

    public T getCelda(){
        return this.celda;

    }
    public Celda(int coordenadaX, int coordenadaY){
        this.coorX=coordenadaX;
        this.coorY=coordenadaY;
    }
    public void setCelda(T celda){
        this.celda = celda;
    }

    public int getCoorX(){
        return coorX;
    }
    public int getCoorY(){
        return coorY;
    }
    public void setCoorX(int coorX){
        this.coorX=coorX;
    }

    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }
}
