public class TorreGeneradora extends Torre{

    private int frecuencia;

    public TorreGeneradora(CeldaTerreno celdaAsociada){
        super(15,30,celdaAsociada);
        frecuencia=3;
    }

    public int generarMagia(){
         return 5*frecuencia;///cambiar
    }
}
