import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class SimpleDotCom {
    private ArrayList<Integer> locatedShips;
    private int numOfPushes;

    public int checkPushes(Integer pushInt){
        if(pushInt < 1 | pushInt > 10) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Choose correct num [1, 10]");
                return 0;
            }
        }
        if(locatedShips.indexOf(pushInt) < 0){
            System.out.println("Hit");
            return 0;
        }
        else {
            locatedShips.remove(pushInt);
            if(locatedShips.isEmpty()) {
                System.out.println("Sank");
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
