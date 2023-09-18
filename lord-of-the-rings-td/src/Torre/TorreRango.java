package Torre;

import Celda.CeldaTerreno;

public class TorreRango extends TorreActiva{

    public TorreRango(CeldaTerreno celdaAsociada){
        super(20, 2, 4, "r", 150, 300, celdaAsociada);
    }
}
