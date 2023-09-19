package Jugador;

import Celda.Celda;
import Celda.CeldaCamino;
import Celda.CeldaTerreno;
import Estructuras.Barricada;
import Torre.*;

import java.util.ArrayList;


/**
 * Clase que representa al jugador.
 * @version 1.1, 10/7/23
 * @author Ignacio Coppede Santos */
public class Jugador {

    private static int magia;
    private static int puntuacion;

    private ArrayList<Torre> torresOnField;

    public int oleada = 0;
    public int getOleada(){
        return oleada;
    }
    public void setOleada(int oleada1){
        this.oleada = oleada1;
    }

    /**
     * Getter de magia.
     * @return magia del jugador *
     */
    public int getMagia(){
        return magia;
    }

    /**
     * Modifica la magia.
     * @param magia nuevo valor de la magia *
     */
    public void setMagia(int magia){
        this.magia=magia;
    }

    /**
     * Getter de puntuacion.
     * @return puntuacion del jugador *
     */
    public int getPuntuacion(){
        return puntuacion;
    }

    /**
     * Agrega puntuacion a la que tiene el jugador.
     * @param puntuacion el aumento de la puntuacion *
     */
    public void sumaPuntuacion(int puntuacion){
        this.puntuacion+=puntuacion;
    }

    /**
     *
     * @return
     */
    public ArrayList<Torre> getTorresOnField(){
        return torresOnField;
    }
    public void setTorresOnField(ArrayList<Torre> torresOnField){
        this.torresOnField=torresOnField;
    }

    /**
     * Constructor del jugador con todos los valores por default.
     */
    public Jugador(){
        magia=500;
        puntuacion=0;
        torresOnField = new ArrayList<Torre>();
    }

    public Boolean comprarTorre(Celda celdaTorre, int tipoTorre, CeldaCamino primeraCelda){
        int coorX = celdaTorre.getCoorX();
        int coorY = celdaTorre.getCoorY();

        if (celdaTorre instanceof CeldaTerreno){
            CeldaTerreno j = (CeldaTerreno) celdaTorre;
            return colocarTorre(tipoTorre,j,primeraCelda, coorX, coorY);
        } else if (celdaTorre instanceof CeldaCamino) {
            if (tipoTorre==6){
                CeldaCamino j = (CeldaCamino) celdaTorre;
                return colocarBarricada(j);
            }
            else
                return Boolean.FALSE;
        } else{
            return Boolean.FALSE;
        }

    }
    private Boolean colocarTorre(int tipoTorre,CeldaTerreno t, CeldaCamino currentCelda,int coorX, int coorY){
        if (t.getOcupada()){
            return Boolean.FALSE;
        }
        else {
            if (tipoTorre == 1) {
                TorreBasica torre = new TorreBasica(t);
                t.setTorre(torre);
                buscarCeldasEnRango(currentCelda, coorX, coorY,torre);
                torresOnField.add(torre);

            } else if (tipoTorre == 2) {
                TorreRango torre = new TorreRango(t);
                t.setTorre(torre);
                buscarCeldasEnRango(currentCelda, coorX, coorY,torre);
                torresOnField.add(torre);

            } else if (tipoTorre == 3) {
                TorreArea torre = new TorreArea(t);
                t.setTorre(torre);
                buscarCeldasEnRango(currentCelda, coorX, coorY,torre);
                torresOnField.add(torre);

            } else if (tipoTorre == 4) {
                TorreRalentizadora torre = new TorreRalentizadora(t);
                t.setTorre(torre);
                buscarCeldasEnRango(currentCelda, coorX, coorY,torre);
                torresOnField.add(torre);

            } else if (tipoTorre == 5) {
                TorreGeneradora torre = new TorreGeneradora(t);
                t.setTorre(torre);
                torresOnField.add(torre);
                return Boolean.TRUE;


            } else {
                return Boolean.FALSE;
            }

            return Boolean.TRUE;

        }
    }



    private void buscarCeldasEnRango(CeldaCamino currentCelda, int coorX, int coorY, TorreActiva torre){
        boolean b = Boolean.TRUE;
        int x = 1;
        int y = 1;
        ArrayList<CeldaCamino> list = new ArrayList<>();
        while(b){
            x = currentCelda.getCoorX();
            y = currentCelda.getCoorY();
            if (Math.abs(x-coorX)<= torre.getAlcance()){
                if (Math.abs(y-coorY)<= torre.getAlcance()){
                    list.add(0,currentCelda);
                }
            }
            if (currentCelda.getSiguienteCelda()==null)
                b=Boolean.FALSE;
            else
                currentCelda = currentCelda.getSiguienteCelda();

        }
        torre.setCeldaEnRango(list);
    }

    private void buscarCeldasEnRango(CeldaCamino currentCelda, int coorX, int coorY, TorreRalentizadora torre){
        boolean b = Boolean.TRUE;
        int x = 1;
        int y = 1;
        ArrayList<CeldaCamino> list = new ArrayList<>();
        while(b){
            x = currentCelda.getCoorX();
            y = currentCelda.getCoorY();
            if (Math.abs(x-coorX)<= torre.getAlcance()){
                if (Math.abs(y-coorY)<= torre.getAlcance()){
                    list.add(0,currentCelda);
                }
            }
            if (currentCelda.getSiguienteCelda()==null)
                b=Boolean.FALSE;
            else
                currentCelda = currentCelda.getSiguienteCelda();

        }
        torre.setCeldaEnRango(list);
    }

// asd

    public Boolean mejorarBarricada(Barricada barricada){
        puntuacion+=100;
        if (barricada.getNivel()>=3){
            return Boolean.FALSE;
        }
        if (barricada.getNivel()==0){
            barricada.setVida(barricada.getVida()+100);
        }
        if (barricada.getNivel()==1){
            barricada.setVida(barricada.getVida()+100);
        }
        if (barricada.getNivel()==2){
            barricada.setVida(barricada.getVida()+100);
        }
        return Boolean.TRUE;
    }


    public Boolean mejorarTorre(CeldaTerreno celdaDeTorre, CeldaCamino primeraCelda){
        puntuacion+=100;
        Torre torre = celdaDeTorre.getTorre();
        int x = celdaDeTorre.getCoorX();
        int y = celdaDeTorre.getCoorY();
        if (torre instanceof TorreActiva){
            TorreActiva tor = (TorreActiva) torre;
            buscarCeldasEnRango(primeraCelda, x, y,tor);
            return mejorarTorreActiva(tor);
        }
        if (torre instanceof TorreRalentizadora){
            TorreRalentizadora tor = (TorreRalentizadora) torre;
            buscarCeldasEnRango(primeraCelda, x, y,tor);
            return mejorarTorreRalentizadora(tor);
        }
        if (torre instanceof TorreGeneradora){
            TorreGeneradora tor = (TorreGeneradora) torre;
            return mejorarTorreGeneradora(tor);
        }
        return Boolean.FALSE;
    }

    private Boolean mejorarTorreGeneradora(TorreGeneradora torre){
        if (torre.getNivel()>=3){
            return Boolean.FALSE;
        }
        if (torre.getNivel()==0){
            torre.setCantidad(torre.getCantidad()+10);
        }
        if (torre.getNivel()==1){
            torre.setCantidad(torre.getCantidad()+10);
        }
        if (torre.getNivel()==2){
            torre.setCantidad(torre.getCantidad()+10);
        }
        torre.setCosteMejora(torre.getCosteMejora()+20);
        return Boolean.TRUE;
    }

    private Boolean mejorarTorreActiva(TorreActiva torre){
        if (torre.getNivel()>=3){
            return Boolean.FALSE;
        }
        if (torre.getNivel()==0){
            torre.setDano(torre.getDano()+10);
        }
        if (torre.getNivel()==1){
            torre.setVelocidad(torre.getVelocidad()-1);
        }
        if (torre.getNivel()==2){
            torre.setAlcance(torre.getAlcance()+1);
        }
        torre.setCosteMejora(torre.getCosteMejora()+20);
        return Boolean.TRUE;
    }

    private Boolean mejorarTorreRalentizadora(TorreRalentizadora torre){
        if (torre.getNivel()>=3){
            return Boolean.FALSE;
        }
        if (torre.getNivel()==0){
            torre.setVelocidad(torre.getVelocidad()-1);
        }
        if (torre.getNivel()==1){
            torre.setVelocidad(torre.getVelocidad()-1);
        }
        if (torre.getNivel()==2){
            torre.setAlcance(torre.getAlcance()+1);

        }

        torre.setCosteMejora(torre.getCosteMejora()+20);
        return Boolean.TRUE;
    }

    public Boolean venderTorre(CeldaTerreno celda){
        if (celda.getTorre()==null)
            return Boolean.FALSE;
        else{
            torresOnField.remove(celda.getTorre());
            celda.setTorre(null);
            magia+=100;
            return Boolean.TRUE;
        }
    }

    private   Boolean colocarBarricada(CeldaCamino celda){
        Barricada barricada = celda.getBarricada();
        if (barricada==null){
            Barricada barricada1 = new Barricada(celda);
            celda.setBarricada(barricada1);
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }









    public static void mostrarInterfaz() {
        System.out.println(" ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Magia: " + magia + " - Puntuación: " + puntuacion + " ||| Vida Cerro: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Glosario:");
        System.out.println("Enemigos: Hu: Humano -- El: Elfo -- En: Enano -- Ho: Hobbit -- Te: Ent -- V: Varios enemigos");
        System.out.println("Torres: B: Torre Básica -- R: Torre Rango -- A: Torre Área -- L: Torre Ralentizadora");
        System.out.println("        G: Torre Generadora -- BBB: Barricada ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void mostrarOpciones() {
        System.out.println("¿Qué desea hacer?:");
        System.out.println("1. Fortalecer defensas");
        System.out.println("2. Descripción de Torres");
        System.out.println("3. Descripción de Enemigos");
        System.out.println("4. Conocer siguiente oleada");
        System.out.println("5. Comenzar oleada");
    }

    public static void mostrarOpcionesTorres() {
        System.out.println("¿Qué desea hacer?:");
        System.out.println("1. Colocar una Torre");
        System.out.println("2. Mejorar una Torre");
        System.out.println("3. Volver para atrás");
    }

    public static void mostrarTienda(){
        System.out.println("1. Colocar Torre Básica (100 coste de magia)");
        System.out.println("2. Colocar Torre de Rango (150 coste de magia)");
        System.out.println("3. Colocar Torre de Área (300 coste de magia)");
        System.out.println("4. Colocar Torre Ralentizadora (400 coste de magia)");
        System.out.println("5. Colocar Torre Generadora (200 coste de magia)");
        System.out.println("6. Colocar Barricada (500 coste de magia)");
        System.out.println("7. Volver para atrás");
    }

    public static void descripcionTorres() {
        System.out.println("¿Acerca de que Torre quieres saber más?");
        System.out.println("1. Torre Básica");
        System.out.println("2. Torre de Rango");
        System.out.println("3. Torre de Área");
        System.out.println("4. Torre Ralentizadora");
        System.out.println("5. Torre Generadora");
        System.out.println("6. Barricada");
        System.out.println("7. Volver atrás");
    }

    public static void descripcionEnemigos() {
        System.out.println("¿Acerca de que Enemigo quieres saber más?");
        System.out.println("1. Humano");
        System.out.println("2. Elfo");
        System.out.println("3. Enano");
        System.out.println("4. Hobbit");
        System.out.println("5. Ent");
        System.out.println("6. Volver atrás");
    }
}
