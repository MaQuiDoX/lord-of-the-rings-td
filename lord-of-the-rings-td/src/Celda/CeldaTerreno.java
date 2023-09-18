package Celda;
// añadir commit
import Torre.Torre;

public class CeldaTerreno extends Celda{
    private Torre torre;
    private Boolean ocupada = new Boolean(false);

    public CeldaTerreno(){
        super(1,1);
        torre=null;
        ocupada=Boolean.FALSE;
    }
    public CeldaTerreno( int coordenadaX, int coordenadaY){
        super(coordenadaX,coordenadaY);
        torre=null;
        ocupada=Boolean.FALSE;
    }


    public Torre getTorre(){
        return torre;
    }

    public void setTorre(Torre torre){
        this.torre=torre;
    }

    public Boolean getOcupada(){
        return ocupada;
    }

}
