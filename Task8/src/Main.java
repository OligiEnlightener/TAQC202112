import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private final static String WRONG_SEQUENCE_OR_NEGATIVE = "Your start-index is smaller then end-index or one of " +
                                                            "indexes is negative!";
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Main m = new Main();
        UserDialogue ud = new UserDialogue();

        ud.getTheBounds(args);
        int start = ud.getStart();
        int end = ud.getEnd();
        m.getFibonacciNumbersUpTo(end);
        m.printFibonacciNumbersInBounds(start, end);

    }
    void getFibonacciNumbersUpTo(int end){
        list.add(0);
        list.add(1);
        for(int i = 2; i <= end; i++){
            int previousZero = list.get(i-2);
            int previousFirst = list.get(i-1);
            list.add(previousZero + previousFirst);
        }
    }
    void printFibonacciNumbersInBounds(int start, int end){
        for(int i = start; i <= end; i++){
            if(i != end){
                System.out.print(list.get(i).toString() + ", ");
            }
            else{
                System.out.print(list.get(i).toString() + ".");
            }
        }
    }
}
