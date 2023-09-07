public abstract class TorreActiva extends Torre {

    protected int daño;
    protected int velocidad;
    protected int alcance;
    protected String tipoDaño;

    public TorreActiva(int daño,int velocidad, int alcance, String tipoDaño, int coste, int costeMejora, CeldaTerreno celdaAsociada){
        super(coste, costeMejora, celdaAsociada);
        this.daño=daño;
        this.velocidad=velocidad;
        this.alcance=alcance;
        this.tipoDaño=tipoDaño;
    }

    public TorreActiva(CeldaTerreno celdaAsociada){
        super(celdaAsociada);
        daño=10;
        velocidad=1;
        alcance=1;
        tipoDaño="neutro";
    }
    ////valores por default, a modificar
    public int getDaño(){
        return daño;
    }
    public void setDaño(int daño){
        this.daño=daño;
    }
    public int getVelocidad(){
        return velocidad;
    }
    public void setVelocidad(int velocidad){
        this.velocidad=velocidad;
    }
    public int getAlcance(){
        return alcance;
    }
    public void setAlcance(int alcance){
        this.alcance=alcance;
    }
    public String getTipoDaño(){
        return tipoDaño;
    }
    public void setTipoDaño(String tipoDaño){
        this.tipoDaño=tipoDaño;
    }

    public void atacarEnemigo(){
        for (CeldaCamino celda: celdaEnRango){
            System.out.println(" ");
        }
    }
}
