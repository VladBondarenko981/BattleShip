import java.io.IOException;
import java.util.Scanner;

public class SimpleDotCom {
    int[] locatedShips;
    int numOfPushes;

    public String checkPushes(String push){
        int pushInt = Integer.parseInt(push);
        if(pushInt < 1 | pushInt > 10){

        }
        String result = "";
        for(int i = 0; i < locatedShips.length; i++) {
            if (pushInt == locatedShips[i]) {
                numOfPushes++;
                if (numOfPushes == locatedShips.length) {
                    result = "Sank";
                    break;
                } else{
                    result = "Got it";
                    break;
                }
            }
            else {
                result = "Hit";
                continue;
            }
        }
        return result;
    }

    public void setLocatedShips(int[] locatedShips) {
        this.locatedShips = locatedShips;
    }

    public static void main(String[] args){
        SimpleDotCom example1 = new SimpleDotCom();
        Scanner sc = new Scanner(System.in);
        int[] array = {2,3,4};
        example1.setLocatedShips(array);
        int counter = 0;
        String[] attemptOld = new String[11];
        while(example1.numOfPushes < array.length) {
            System.out.println("***Enter the num between 1 and 10***");
            String attempt = "";
            while(true) {
                attempt = sc.next();
                if(Integer.parseInt(attempt) < 1 | Integer.parseInt(attempt) > 10){
                    try{
                    throw new IOException();
                    }catch (IOException e){
                        System.out.println("Choose correct num [1, 10]");
                        continue;
                    }
                }break;
            }
            boolean is_be = false;
            for(int i = 0; i < attemptOld.length;i++) {
                if (attempt.equals(attemptOld[i]))
                    is_be = true;
            }
            if(is_be){
                try{
                    throw new SimpleDogException();
                }catch (SimpleDogException e){
                    continue;
                }
            }
            attemptOld[counter] = attempt;
            System.out.println(example1.checkPushes(attempt));
            ++counter;
        }
        System.out.println("Game Over! You win!\nYou shot "+counter+" times");
    }
}
