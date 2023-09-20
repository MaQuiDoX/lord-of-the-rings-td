package Torre;

import Celda.CeldaTerreno;

public class TorreRango extends TorreActiva{

    /**
     * Cosntructor de TorreRango.
     * @param celdaAsociada celda donde se encuentra la torre.
     */
    public TorreRango(CeldaTerreno celdaAsociada){
        super(30, 8, 4, "r", 300, celdaAsociada);
    }
}
