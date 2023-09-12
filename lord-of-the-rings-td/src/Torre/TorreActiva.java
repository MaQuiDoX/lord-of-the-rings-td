package Torre;

/**
 * Una clase abstracta para representar los comportamientos generales de las torres que atacan a los enemigos.
 * @version 1.1 10/9/23 *
 * @author Ignacio Copppede Santos *
 */

public abstract class TorreActiva extends Torre {

    protected int dano;
    protected int velocidad;
    protected int alcance;
    protected String tipoDano;

    /**
     *
     * @param daño Daño que le causa la torre al enemigo en cada ataque.
     * @param velocidad Tiempo que tarda en atacar a un enemigo.
     * @param alcance Radio, en cantidad de celdas, en el que puede atacar enemigos.
     * @param tipoDaño Tipo de ataque que hace la torre.
     */

    /**
     * Constructor de la torre pasando como parametros el valor de los atributo.
     */
    public TorreActiva(int dano,int velocidad, int alcance, String tipoDano, int coste, int costeMejora, CeldaTerreno celdaAsociada){
        super(coste, costeMejora, celdaAsociada);
        this.dano=dano;
        this.velocidad=velocidad;
        this.alcance=alcance;
        this.tipoDano=tipoDano;
    }

    /**
     * Consturctor con todos los atributos por defecto.
     */
    public TorreActiva(CeldaTerreno celdaAsociada){
        super(celdaAsociada);
        dano=10;
        velocidad=1;
        alcance=1;
        tipoDano="neutro";
        ////valores por default, a modificar
    }

    /**
     * Getter del daño.
     * @return daño de la torre*
     */
    public int getDano(){
        return dano;
    }

    /**
     * Modifica el daño de la torre.
     * @param dano nuevo daño *
     */
    public void setDano(int dano){
        this.dano=dano;
    }

    /**
     * Getter de velocidad.
     * @return la velocidad de la torre *
     */
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Modifica la velocidad.
     * @param velocidad nueva velocidad *
     */
    public void setVelocidad(int velocidad){
        this.velocidad=velocidad;
    }

    /**
     * Getter alcance.
     * @return alcance de la torre*
     */
    public int getAlcance(){
        return alcance;
    }

    /**
     * Modifica el alcance de la torre.
     * @param alcance nuevo alcance de la torre *
     */
    public void setAlcance(int alcance){
        this.alcance=alcance;
    }

    /**
     * Getter del tipoDaño.
     * @return el tipo de daño *
     */
    public String getTipoDano(){
        return tipoDano;
    }

    /**
     * Modifica el tipo de daño.
     * @param tipoDano nuevo tipo de daño *
     */
    public void setTipoDano(String tipoDano){
        this.tipoDano=tipoDano;
    }

    /**
     * ataca al enemigo que más avanzo.
     */
    public void atacarEnemigo(){
        for (CeldaCamino celda: celdaEnRango){
            System.out.println(" ");
        }
    }
}
