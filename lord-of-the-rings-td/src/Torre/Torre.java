
import java.util.ArrayList; //importo la clase ArrayList

public abstract class Torre {

    protected int coste;
    protected int costeMejora;
    protected int nivel;
    protected CeldaTerreno celdaAsociada;
    protected ArrayList<CeldaCamino> celdaEnRango;

    public Torre(int coste, int costeMejora, CeldaTerreno celdaAsociada){

        this.coste=coste;
        this.costeMejora=costeMejora;
        nivel=0;
        this.celdaAsociada=celdaAsociada;

    }
    public Torre(CeldaTerreno celdaAsociada){
        coste=100;
        costeMejora=200;
        nivel=0;
        this.celdaAsociada=celdaAsociada;
    }
    ///valores por default
    public int getCoste(){
        return coste;
    }
    public void setCoste(int coste){
        this.coste=coste;
    }
    public int getCosteMejora(){
        return costeMejora;
    }
    public void setCosteMejora(int costeMejora){
        this.costeMejora=costeMejora;
    }
    public int getNivel(){
        return nivel;
    }
    public void setNivel(int nivel){
        this.nivel=nivel;
    }

    public CeldaTerreno getCeldaAsociada() {
        return celdaAsociada;
    }
    public void setCeldaAsociada(CeldaTerreno celdaAsociada){
        this.celdaAsociada=celdaAsociada;
    }
    public ArrayList<CeldaCamino> getCeldaEnRango(){
        return celdaEnRango;
    }
    private void setCeldaEnRango(CeldaCamino nuevaCelda){
        celdaEnRango.add(nuevaCelda);
    }
}
