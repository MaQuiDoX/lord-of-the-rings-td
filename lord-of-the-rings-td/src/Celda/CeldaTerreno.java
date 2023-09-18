package Celda;
// añadir commit
import Torre.Torre;

public class CeldaTerreno extends Celda{
    private Torre torre;
    private Boolean ocupada = new Boolean(false);

    public void CeldaTerreno(){

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
