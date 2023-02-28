import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        SimpleDotCom example1 = new SimpleDotCom();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list= new ArrayList<>();
        int num = (int)(Math.random()*8);
        for(int i = 0; i < 3; i++) {
            list.add(num + i + 1);
        }
        example1.setLocatedShips(list);
        int counter = 0, newCounter = 0;
        while(counter != 3) {
            System.out.println("***Enter the num between 1 and 10***");
            counter += example1.checkPushes(sc.nextInt());
            ++newCounter;
        }
        System.out.println("Game Over! You win! You needed "+newCounter+" attempts");
    }
}
