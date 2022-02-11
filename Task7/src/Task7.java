import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task7 {
    private final static String TOO_MANY_OR_NOT_ENOUGH = "You have entered too many or not enough arguments. ";
    private final static String TRY_AGAIN = "Try again, by inputting int n, that bigger then 0";
    private final static String NOT_INTEGER = "You have entered not an Integer value! ";
    private final static String ZERO_VALUE = "You have entered 0-value";
    private List<Integer> collectNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Task7 t7 = new Task7();
        int n = t7.getN(args);
        t7.getNumberIfPowerFewerThen(n);
        printNumbers(t7.getCollectNumbers());
    }
    private int getN(String[] args){
        int n = 0;
        if(args.length == 1){
            Scanner scanner = new Scanner(args[0]);
            if(scanner.hasNextInt()){
                int temp = scanner.nextInt();
                if(temp != 0){
                    n = temp;
                }
                else{
                    System.out.println(ZERO_VALUE);
                    System.out.println(TRY_AGAIN);
                }
            }
            else{
                System.out.println(NOT_INTEGER);
                System.out.println(TRY_AGAIN);
            }
        }
        else{
            System.out.println(TOO_MANY_OR_NOT_ENOUGH);
            System.out.println(TRY_AGAIN);
        }
        return n;
    }
    private void getNumberIfPowerFewerThen(int n){
        for(int i = 1; i * i < n; i++){
            collectNumbers.add(i);
        }
        
    }
    private static void printNumbers(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            if(i != list.size() - 1 ){
                System.out.print(list.get(i) + ", ");
            }
            else{
                System.out.println(list.get(i) + ". ");
            }

        }
    }

    public List<Integer> getCollectNumbers() {
        return collectNumbers;
    }
}
