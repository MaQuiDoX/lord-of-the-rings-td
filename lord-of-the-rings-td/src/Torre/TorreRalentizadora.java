public class TorreRalentizadora extends Torre{

    private int alcance;
    ///ver de balancearlo mejor, solo se podria mejorar el alcance
    public TorreRalentizadora(CeldaTerreno celdaAsociada){
        super(15,30,celdaAsociada);
        alcance=1;
    }

    public int reducidirVelocidad(){
        return 10;///implementar
    }

}
