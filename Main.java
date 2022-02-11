import java.io.IOException;
import java.util.Random;

public class Main {
    private static final Boolean flagStop = false;
    private static void genRandom (int[] arr){
        for(int i = 0; i < arr.length; ++i){
            arr[i] = (int)(Math.random()*8);
        }
    }
    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        //System.out.flush();
    }
    private static final String []colorArr = new String[8];
    private static void colorInit (){
        colorArr[0] = "\033[0m";  // Text Reset
        colorArr[1] = "\033[0;31m";     // RED
        colorArr[2] = "\033[0;32m";   // GREEN
        colorArr[3] = "\033[0;33m";  // YELLOW
        colorArr[4] = "\033[0;34m";    // BLUE
        colorArr[5] = "\033[0;35m";  // PURPLE
        colorArr[6] = "\033[0;36m";    // CYAN
        colorArr[7] = "\033[0;37m";   // WHITE
    }
    public static void main(String[] args) throws InterruptedException {
        colorInit();
        clearScreen();
        String sizeStr = System.getProperty("sizeArr");
        String updateTimeStr = System.getProperty("upTimeMs");
        int size = 40;
        int updateTimeMs = 100;
        if (sizeStr != null && !sizeStr.isEmpty()) {
            size = Integer.parseInt(sizeStr);
        }
        if (updateTimeStr != null && !updateTimeStr.isEmpty()) {
            updateTimeMs = Integer.parseInt(updateTimeStr);
        }
        int [] arr = new int[size*size];
        while(true){
            genRandom(arr);
            for(int i = 1; i <= arr.length; ++i){
                System.out.printf("%x %s", arr[i-1], colorArr[arr[i-1]]);
                if (i % size == 0)
                    System.out.println();
            }
            Thread.sleep(updateTimeMs);
            clearScreen();
            if (flagStop){
                break;
            }
        }
    }
}
