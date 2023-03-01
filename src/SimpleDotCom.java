import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class SimpleDotCom {
    private ArrayList<String> toLocateShips;
    private ArrayList<Integer> locatedShips;
    private ArrayList<String> uncorrectPositions;
    private int numOfPushes;
    private String name;
    private String[][] table = new String[10][10];

    public ArrayList<String> getToLocateShips() {
        return toLocateShips;
    }

    public void setToLocateShips(ArrayList<String> toLocateShips) {
        this.toLocateShips = toLocateShips;
    }

    public ArrayList<String> getUncorrectPositions() {
        return uncorrectPositions;
    }

    public void setUncorrectPositions(ArrayList<String> uncorrectPositions) {
        this.uncorrectPositions = uncorrectPositions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTable(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++)
                table[i][j] = "-";
        }
    }
    public ArrayList createShips(){
        int numOne = (int)(Math.random()*2);
        char[] array = {'A','B','C','D','E','F','G','H','I','G'};
        while (toLocateShips.size() != 9) {
            if (numOne == 1) {
                int numOneLength = (int) (Math.random() * 7);
                char numOneWidth = array[(int) (Math.random() * 10)];
                String[] ship = new String[3];
                for (int i = 0; i < 3; i++) {
                    ship[i] = Integer.toString(numOneLength + i) + Character.toString(numOneWidth);
                }
                boolean count = false;
                for (int j = 0; j < 3; j++) {
                    count = uncorrectPositions.contains(ship[j]);
                    if (count == true)
                        break;
                }
                if (count == false) {
                    for (String number : ship)
                        toLocateShips.add(number);
                    for (int j = -1; j < 5; j++) {
                        uncorrectPositions.add(Integer.toString(numOneLength + j) + Character.toString(numOneWidth - 1));
                        uncorrectPositions.add(Integer.toString(numOneLength + j) + Character.toString(numOneWidth));
                        uncorrectPositions.add(Integer.toString(numOneLength + j) + Character.toString(numOneWidth + 1));
                    }
                }
            } else {
                int numOneLength = (int) (Math.random() * 10);
                int numOneWidth = array[(int) (Math.random() * 7)];
                String[] ship = new String[3];
                for (int i = 0; i < 3; i++) {
                    ship[i] = Integer.toString(numOneLength) + Character.toString(numOneWidth+i);
                }
                boolean count = false;
                for (int j = 0; j < 3; j++) {
                    count = uncorrectPositions.contains(ship[j]);
                    if (count == true)
                        break;
                }
                if (count == false) {
                    for (String number : ship)
                        toLocateShips.add(number);

                    for (int j = -1; j < 5; j++) {
                        uncorrectPositions.add(Integer.toString(numOneLength - 1) + Character.toString(numOneWidth + j));
                        uncorrectPositions.add(Integer.toString(numOneLength) + Character.toString(numOneWidth + j));
                        uncorrectPositions.add(Integer.toString(numOneLength + 1) + Character.toString(numOneWidth + j));
                    }
                }
            }
        }
        return toLocateShips;

    }
    public int checkPushes(String pushInt){
        table[pushInt.charAt(0)-'0'][pushInt.charAt(1)-'A'] = "1";
        if(pushInt.length() > 2 | pushInt.charAt(0) < 48 | pushInt.charAt(0) > 57 | pushInt.charAt(1) > 90 | pushInt.charAt(1) < 65) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Choose correct position.");
                return 0;
            }
        }
        if(toLocateShips.indexOf(pushInt) < 0){
            System.out.println("Hit");
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    System.out.print(table[i][j]+" ");
                }
                System.out.println();
            }
            return 0;
        }
        else {
            toLocateShips.remove(pushInt);
            int newCount = 0;
            for(int i = 0; i < toLocateShips.size(); i++)
                if(((int)(Math.abs(pushInt.charAt(0) - (toLocateShips.get(i)).charAt(0))) < 2) && ((int)(Math.abs(pushInt.charAt(1) - (toLocateShips.get(i)).charAt(1))) < 2)) {
                    newCount += 1;
                    break;
                }
            if(toLocateShips.size() != 9 & newCount == 0) {
                System.out.println("Sank! Find others");
                table[pushInt.charAt(0)-'0'][pushInt.charAt(1)-'A'] = "*";
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        System.out.print(table[i][j]+" ");
                    }
                    System.out.println();
                }
                return 1;
            }
            else{
                System.out.println("Got it");
                table[pushInt.charAt(0)-'0'][pushInt.charAt(1)-'A'] = "*";
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        System.out.print(table[i][j]+" ");
                    }
                    System.out.println();
                }
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
