import java.util.Arrays;

public class Chessboard {

    public static void main(String[] args) {
        int height = 0;
        int width = 0;
        if(args.length == 0){
            callManual(0);
        }
        else{
            try{
                height = Integer.parseInt(args[0]);
                width = Integer.parseInt(args[1]);
                createBoard(height, width);
            }
            catch (Exception e){
                callManual(1);
            }
        }
    }
    public static void createBoard(int height, int width ){
        String star = "*";
        String space = " ";
        boolean switcher = true; // This variable helps to see, whether it was star or space
        int widthForOdds = width * 3;
        for(int i = 0; i < height; i++){

            for(int j = 0; j < widthForOdds; j++){
                if(switcher){
                    System.out.print(space);
                    switcher = false;
                }
                else{
                    System.out.print(star);
                    switcher = true;
                }
            }
            /* The line below is neded to avoid the dissform of Chesboard*/
            if(width % 2 == 0){ switcher = !switcher; }


            System.out.println();
        }
    }
    public static void callManual(int status){
        if(status == 0){
            System.out.println("This program create an chessboard, that should be looking, like in given example.");
            System.out.println("To run the program you should enter program`s name with " +
                    "two ints in form: 'Chessboard + height + width' " );
            System.out.println("For example: ");
            System.out.println(" 'Chesboard 8 8' ");
        }
        else if(status == 1){
            System.out.println("You entered wrong arguments!");
            System.out.println("Start program without any parameters for the further instructions.");
        }

    }
}
