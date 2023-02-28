import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        GameMenu example2 = new GameMenu();
        example2.startGame();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list= new ArrayList<>();
        ArrayList<String> list2= new ArrayList<>();
        example2.setToLocateShips(list2);
        int num = (int)(Math.random()*8);
        for(int i = 0; i < 3; i++) {
            list.add(num + i + 1);
        }
        example2.setLocatedShips(list);
        int counter = 0, newCounter = 0;
        example2.createShips();
        while(counter != 9) {
            System.out.println("***Enter the num between 1 and 10***");
            counter += example2.checkPushes(sc.next());
            ++newCounter;
        }
        System.out.println("Game Over! You win! You needed "+newCounter+" attempts");
        example2.finishGame();
    }
}
