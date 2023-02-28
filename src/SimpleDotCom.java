import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class SimpleDotCom {
    private ArrayList<String> toLocateShips;
    private ArrayList<Integer> locatedShips;
    private int numOfPushes;
    private String name;

    public ArrayList<String> getToLocateShips() {
        return toLocateShips;
    }

    public void setToLocateShips(ArrayList<String> toLocateShips) {
        this.toLocateShips = toLocateShips;
    }


    public ArrayList createShips(){
        int numOne = (int)(Math.random()*2);
        char[] array = {'A','B','C','D','E','F','G','H','I','G'};
        for(int j = 0; j < 3; j++) {
            if (numOne == 1) {
                int numOneLength = (int) (Math.random() * 7);
                char numOneWidth = array[(int) (Math.random() * 10)];
                for (int i = 0; i < 3; i++) {
                    String ship = Integer.toString(numOneLength + i) + Character.toString(numOneWidth);
                    toLocateShips.add(ship);
                }
            } else {
                int numOneLength = (int) (Math.random() * 10);
                int numOneWidth = (int) (Math.random() * 7);
                for (int i = 0; i < 3; i++) {
                    String ship = Integer.toString(numOneLength) + Character.toString(array[numOneWidth + i]);
                    toLocateShips.add(ship);
                }
            }
        }
        return toLocateShips;

    }
    public int checkPushes(String pushInt){
        /*if(pushInt < 1 | pushInt > 10) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Choose correct num [1, 10]");
                return 0;
            }
        }*/
        if(toLocateShips.indexOf(pushInt) < 0){
            System.out.println("Hit");
            return 0;
        }
        else {
            toLocateShips.remove(pushInt);
            if(toLocateShips.size() != 9 & toLocateShips.size() % 3 == 0) {
                System.out.println("Sank! Find others");
                return 1;
            }
            else{
                System.out.println("Got it");
                return 1;
            }
        }
    }

    public ArrayList<Integer> getLocatedShips() {
        return locatedShips;
    }

    public void setLocatedShips(ArrayList<Integer> locatedShips) {
        this.locatedShips = locatedShips;
    }

    public int getNumOfPushes() {
        return numOfPushes;
    }

    public void setNumOfPushes(int numOfPushes) {
        this.numOfPushes = numOfPushes;
    }

}
