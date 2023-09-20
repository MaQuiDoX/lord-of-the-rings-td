package Jugador;

import Celda.Celda;
import Celda.CeldaCamino;
import Celda.CeldaTerreno;
import Estructuras.Barricada;
import Torre.*;

import java.util.ArrayList;


/**
 * Clase que representa al jugador.
 * @version 1.1, 19/9/23
 * @author Ignacio Coppede Santos */
public class Jugador {

    private static int magia;
    private static int puntuacion;
    private ArrayList<Torre> torresOnField;
    public int oleada = 0;

    /**
     * Getter de oleada.
     * @return Numero de la oleada, entre 0 y 5.
     */
    public int getOleada(){
        return oleada;
    }
    /**
     * Setter de oleada.
     * @param oleada1 La oleada eligida *
     */
    public void setOleada(int oleada1){
        this.oleada = oleada1;
    }

    /**
     * Getter de magia.
     * @return Magia del jugador *
     */
    public int getMagia(){
        return magia;
    }
    /**
     * Setter de magia.
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
     * Setter de puntuacion.
     * @param puntuacion nueva puntuacion que va a tener el jugador.
     */
    public void setPuntuacion(int puntuacion){
        this.puntuacion=puntuacion;
    }

    /**
     * Devuelve la lista de Torres que se encuentran dentro del mapa.
     * @return Un ArrayList con los objetos torres que estan en el mapa.
     */
    public ArrayList<Torre> getTorresOnField(){
        return torresOnField;
    }


    /**
     * Constructor del jugador con todos los valores por default.
     */
    public Jugador(){
        magia=500;
        puntuacion=0;
        torresOnField = new ArrayList<Torre>();
    }

    /**
     * Compra una torre, inicializandola y colocandola en el mapa.
     * @param celdaTorre Celda donde se encontrara la torre.
     * @param tipoTorre Un entero que indentifica que clase de torre se quiere comparar.
     * @param coorX La coordena en filas de la ubicacion de la torre que se quiere colocar.
     * @param coorY La coordena en columnas de la ubicacion de la torre que se quiere colocar.
     * @param primeraCelda La primera CeldaCamino del mapa.
     * @return Devuelve True si se pudo comprar la torre y False en caso contrario.
     */
    public Boolean comprarTorre(Celda celdaTorre, int tipoTorre,int coorX , int coorY, CeldaCamino primeraCelda){


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

    /**
     * Coloca un objeto torre en la celda que se le asigna.
     * @param tipoTorre un entero que representa que clase de torre se quiere colocar.
     * @param t  Celda donde se encontrara la torre.
     * @param currentCelda La primera CeldaCamino del mapa.
     * @param coorX La coordena en filas de la ubicacion de la torre que se quiere colocar.
     * @param coorY La coordena en columnas de la ubicacion de la torre que se quiere colocar.
     * @return Devuelve True si se pudo colocar la torre y False en caso contrario.
     */
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


    /**
     * Coloca todas las celdas dentro del rango de accion de una TorreActiva.
     * @param currentCelda La primera CeldaCamino del mapa.
     * @param coorX La coordena en filas de la ubicacion de la torre que se quiere colocar.
     * @param coorY La coordena en columnas de la ubicacion de la torre que se quiere colocar.
     * @param torre La Torre a la que se le tiene que cargar las celdas en su rango.
     */
    private void buscarCeldasEnRango(CeldaCamino currentCelda, int coorX, int coorY, TorreActiva torre){
        boolean b = Boolean.TRUE;
        int x;
        int y;
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

    /**
     * Coloca todas las celdas dentro del rango de accion de una TorreRalentizadora.
     * @param currentCelda La primera CeldaCamino del mapa.
     * @param coorX La coordena en filas de la ubicacion de la torre que se quiere colocar.
     * @param coorY La coordena en columnas de la ubicacion de la torre que se quiere colocar.
     * @param torre La Torre a la que se le tiene que cargar las celdas en su rango.
     */
    private void buscarCeldasEnRango(CeldaCamino currentCelda, int coorX, int coorY, TorreRalentizadora torre){
        boolean b = Boolean.TRUE;
        int x;
        int y;
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


    /**
     * Mejora de nivel la barricada, aumentandole la vida.
     * @param barricada Barricada que se quiere mejorar.
     * @return Devuelve True si se pudo mejorar la barricada y False en caso contrario.
     */
    public Boolean mejorarBarricada(Barricada barricada){
        puntuacion+=100;
        if (barricada.getNivel()>=3){
            return Boolean.FALSE;
        }
        if (barricada.getNivel()==0){
            barricada.setVida(barricada.getVida()+20);
        }
        if (barricada.getNivel()==1){
            barricada.setVida(barricada.getVida()+20);
        }
        if (barricada.getNivel()==2){
            barricada.setVida(barricada.getVida()+20);
        }
        barricada.setNivel(barricada.getNivel()+1);
        return Boolean.TRUE;
    }

    /**
     * Mejorar los distintos atributos de una determinada torre.
     * @param celdaDeTorre  Celda donde se encuentra la celda a mejorar.
     * @param primeraCelda La primera CeldaCamino del mapa.
     * @return Devuelve True si se pudo mejorar la torre y False en caso contrario.
     */
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

    /**
     * Mejorar la cantidad de magia que genera la torre.
     * @param torre TorreGeneradora que se desea mejorar
     * @return Devuelve True si se pudo mejorar la torre y False en caso contrario.
     */
    private Boolean mejorarTorreGeneradora(TorreGeneradora torre){
        if (torre.getNivel()>=3){
            return Boolean.FALSE;
        }
        if (torre.getNivel()==0){
            torre.setCantidad(torre.getCantidad()+50);
        }
        if (torre.getNivel()==1){
            torre.setCantidad(torre.getCantidad()+50);
        }
        if (torre.getNivel()==2){
            torre.setCantidad(torre.getCantidad()+50);
        }
        torre.setNivel(torre.getNivel()+1);
        torre.setCosteMejora(torre.getCosteMejora()+50);
        return Boolean.TRUE;
    }

    /**
     * Mejorar los distintos atributos de una determinada TorreActiva.
     * @param torre TorreActiva que se desea mejorar.
     * @return Devuelve True si se pudo mejorar la torre y False en caso contrario.
     */

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
        torre.setNivel(torre.getNivel()+1);
        return Boolean.TRUE;
    }

    /**
     * Mejorar los distintos atributos de una determinada TorreRalentizadora.
     * @param torre TorreRalentizadora que se desea mejorar.
     * @return Devuelve True si se pudo mejorar la torre y False en caso contrario.
     */

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
        torre.setNivel(torre.getNivel()+1);
        return Boolean.TRUE;
    }

    /**
     * Saca del mapa la torre y aumenta la cantidad de magia que tiene el jugador.
     * @param celda Celda donde se encuentra la torre a vender.
     * @return Devuelve True si se pudo vender la torre y False en caso contrario.
     */

    public Boolean venderTorre(CeldaTerreno celda){
        if (celda.getTorre()==null)
            return Boolean.FALSE;
        else{
            torresOnField.remove(celda.getTorre());
            celda.setTorre(null);
            return Boolean.TRUE;
        }
    }

    /**
     * Coloca un objeto barricada en la celda que se le asigna.
     * @param celda Celda donde se encontrara la barricada.
     * @return Devuelve True si se pudo colocar la torre y False en caso contrario.
     */

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


    /**
     * Muestra una pequena descripcion de los atributos del jugador y el glosario.
     */
    public static void mostrarInterfaz() {
        System.out.println(" ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Magia: " + magia + " - Puntuacion: " + puntuacion);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Glosario: C: CERRO");
        System.out.println("Enemigos: Hu: Humano -- El: Elfo -- En: Enano -- Ho: Hobbit -- Te: Ent -- Va: Varios enemigos");
        System.out.println("Torres: B: Torre Basica -- R: Torre Rango -- A: Torre Area -- L: Torre Ralentizadora");
        System.out.println("        G: Torre Generadora -- BBB: Barricada ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * Muestra las opciones del menu.
     */
    public static void mostrarOpciones() {
        System.out.println("¿Que desea hacer?:");
        System.out.println("1. Fortalecer defensas");
        System.out.println("2. Descripcion de Torres");
        System.out.println("3. Descripcion de Enemigos");
        System.out.println("4. Conocer siguientes oleadas");
        System.out.println("5. Comenzar oleada");
    }

    /**
     * Muestra las opciones cuando se desea fortalecer las defensas.
     */
    public static void mostrarOpcionesTorres() {
        System.out.println("¿Que desea hacer?:");
        System.out.println("1. Colocar una Torre");
        System.out.println("2. Mejorar una Torre (200 de magia por mejora)");
        System.out.println("3. Vender una Torre (+100 de magia por torre)");
        System.out.println("4. Volver para atras");
    }

    /**
     * Muestra las opciones cuando se desea comprar defensas.
     */
    public static void mostrarTienda(){
        System.out.println("1. Colocar Torre Basica (100 coste de magia)");
        System.out.println("2. Colocar Torre de Rango (150 coste de magia)");
        System.out.println("3. Colocar Torre de Area (300 coste de magia)");
        System.out.println("4. Colocar Torre Ralentizadora (400 coste de magia)");
        System.out.println("5. Colocar Torre Generadora (200 coste de magia)");
        System.out.println("6. Colocar Barricada (500 coste de magia)");
        System.out.println("7. Volver para atras");
    }

    /**
     * Muestra una descripcion de cada torre.
     */
    public static void descripcionTorres() {
        System.out.println("¿Acerca de que Torre quieres saber mas?");
        System.out.println("1. Torre Basica");
        System.out.println("2. Torre de Rango");
        System.out.println("3. Torre de Area");
        System.out.println("4. Torre Ralentizadora");
        System.out.println("5. Torre Generadora");
        System.out.println("6. Barricada");
        System.out.println("7. Volver atras");
    }

    /**
     * Muestra una descripcion de cada enemigo.
     */
    public static void descripcionEnemigos() {
        System.out.println("¿Acerca de que Enemigo quieres saber mas?");
        System.out.println("1. Humano");
        System.out.println("2. Elfo");
        System.out.println("3. Enano");
        System.out.println("4. Hobbit");
        System.out.println("5. Ent");
        System.out.println("6. Volver atras");
    }
}
