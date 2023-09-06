package Torre;

public class TorreActiva extends Torre {
    private int danoTorre;
    private int velocidadAtaqueTorre;
    // private int alcance (esto creo que iria junto con celda rango)
    // SE ME OCURRE QUE, A LA HORA DE MEJORAR LA TORRE, EN VEZ DE CAMBIARLE LOS ATRIBUTOS MEJOR SERIA BORRARLA Y CAMBIARLA POR UNA CON LOS ATRIBUTOS NUEVOS
    // ES ALGO QUE TENDRIAMOS QUE TENER PREMEDITADO

    private String tipoDano;

    // añadir dependencias
    public TorreActiva(int costeTorre, int costeMejoraTorre, int nivelTorre, int danoTorre, int velocidadAtaqueTorre){
        super(costeTorre, costeMejoraTorre, nivelTorre);
        this.danoTorre = danoTorre;
        this.velocidadAtaqueTorre = velocidadAtaqueTorre;
    }
}