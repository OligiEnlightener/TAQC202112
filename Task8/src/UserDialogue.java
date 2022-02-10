import java.util.Scanner;

public class UserDialogue {
    private int[] bounds = new int[2];
    private final String EXAMPLE = "<Program name, int first, int last>";
    private final String NOT_ENOUGH_ARGUMENTS = "You have entered not enough arguments. ";
    private final String TOO_MUCH_ARGUMENTS = "You have entered too much arguments. ";
    private final String ANOTHER_TRY = "Try again in form: ";
    private final String WRONG_ARGUMENT = "You have entered wrong Argument";

    void getTheBounds(String[] args){
        //body of method
        if(args.length == 2){
            for(int i = 0; i < args.length; i++){
                Scanner scann = new Scanner(args[i]);
                if(scann.hasNextInt()){
                    bounds[i] = scann.nextInt();
                }
                else {
                    System.out.println(WRONG_ARGUMENT);
                    System.out.println(ANOTHER_TRY);
                    System.out.println(EXAMPLE);
                    break;
                }
            }

        }//if there are not 2 arguments, something went wrong and need to be reported!
        else{
            switch(args.length){
                case 0:
                case 1:
                    System.out.println(NOT_ENOUGH_ARGUMENTS);
                    System.out.println(ANOTHER_TRY);
                    System.out.println(EXAMPLE);
                    break;
                default:
                    System.out.println(TOO_MUCH_ARGUMENTS);
                    System.out.println(ANOTHER_TRY);
                    System.out.println(EXAMPLE);
                    break;
            }
        }
    }
    int getStart(){
        if(bounds.length > 0){ return bounds[0]; }
        return -1;
    }
    int getEnd(){
        if(bounds.length > 0){ return bounds[1]; }
        return -1;
    }
}
