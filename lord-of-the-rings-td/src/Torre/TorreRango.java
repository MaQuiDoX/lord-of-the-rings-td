package Torre;

import Celda.CeldaTerreno;

public class TorreRango extends TorreActiva{


    public TorreRango(CeldaTerreno celdaAsociada){
        super(60, 8, 4, "r", 300, celdaAsociada);
    }
}
