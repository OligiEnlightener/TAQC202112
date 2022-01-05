import java.util.Scanner;

public class Main {
    private static double heightA;
    private static double widthB;
    private static double heightC;
    private static double widthD;

    public static void main(String[] args) {
            run();
    }

    private static void run(){
        introduction();

        System.out.println("Please enter the height of first envelope.");
        heightA = setValue();
        System.out.println("Please enter the width of first envelope.");
        widthB = setValue();
        System.out.println("Please enter the height of second envelope.");
        heightC = setValue();
        System.out.println("Please enter the width of second envelope.");
        widthD = setValue();

        Envelope first = new Envelope(heightA,widthB);
        Envelope second = new Envelope(heightC,widthD);
        first.checkBothEnvelopes(second);
        goNext();
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
    private static void introduction(){
        System.out.println("Hello. This program calculates, if an envelope can be putted into another one.");
    }
}
