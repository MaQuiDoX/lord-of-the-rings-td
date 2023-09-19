package Torre;
import Celda.*;
/**
 * Una clase de las torres basicas sin ningun tipo de distincion.
 * @version 1.1 10/9/23 *
 * @author Ignacio Copppede Santos *
 */
public class TorreBasica extends TorreActiva{

    /**
     * Constructor de CorreCasica.
     * @param celdaAsociada la celda en donde se va ubicar la torr *
     */
    public TorreBasica(CeldaTerreno celdaAsociada){
        super(10, 2, 2, "b", 200, celdaAsociada);
    }

}
