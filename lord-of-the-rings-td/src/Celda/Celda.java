package Celda;
// añadir commit
public abstract class Celda<T> {
    private T celda;

    public T getCelda(){
        return this.celda;
    }
    public void setCelda(T celda){
        this.celda = celda;
    }
}
