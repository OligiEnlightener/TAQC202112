import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        introduction();
        run();
    }

    private static void introduction(){
        System.out.println("Hello. This program calculates, if an envelope can be putted into another one.");
    }

    private static void run(){
        Envelope first = new Envelope();
        Envelope second = new Envelope();

        System.out.println("Please enter the height of first envelope.");
        first.setHeight(setValue());
        System.out.println("Please enter the width of first envelope.");
        first.setWidth(setValue());
        System.out.println("Please enter the height of second envelope.");
        second.setHeight(setValue());
        System.out.println("Please enter the width of second envelope.");
        second.setWidth(setValue());

        first.checkBothEnvelopes(second);
        goNext();
    }

    private static double setValue(){
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextDouble()){
            double side = scanner.nextDouble();
            if(side < 0){
                System.out.println("Value can`t be negative. Please enter any positive value!");
                return setValue();
            }
            else{
                return side;
            }
        }
        else{
            System.out.println("Not a number. Please enter any positive value!");
            return setValue();
        }
    }

    private static void goNext(){
        String[] positiveResults = {"y", "Y", "Yes", "yes"};
        System.out.println("Would you like to compare another paar of envelopes? ");
        System.out.println("Type \"Y\" or \"Yes\" to continue, otherwise the program will be terminated. ");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()){
            String answer = scanner.next();
            for(String s : positiveResults){
                if(answer.equals(s)){
                    run();
                }
            }
        }
    }

}
