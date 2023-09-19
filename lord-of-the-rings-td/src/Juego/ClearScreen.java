package Juego;

public class ClearScreen {
    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
