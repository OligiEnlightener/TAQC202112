import java.util.*;

public class Task3{
    private List<Triangle> triangles;

    private final String intro = "This program sorts given from user Triangles.\n To continue the program enter the name " +
            "                               of triangle and it`s sides in form:\n <Name>, <Side a>, <side b>, <side c>";
    private final String notEnoughArguments = "notEnoughArguments";
    private final String toManyArguments = "toManyArguments";
    private final String incorrectInput = "incorrectInput";
    private final String nextOr = "Would you like to add one more triangle? Y or Yes ";
    private final String outro = "============= Triangles list: ===============";
    private final String notAStatement = "Wrong arguments, try again!";


    public static void main(String[] args) {
        Task3 t3 = new Task3();
        t3.run();

    }
    // метод добавляет треугольник в коллекцию треугольников
    public void run(){
        System.out.println(intro);
        createAndAddTriangleToCollection();
        sortTriangles();
        printTriangles();

    }
    private void createAndAddTriangleToCollection(){
        triangles = new ArrayList<Triangle>();
        Triangle t = dataFromUser();
        triangles.add(t);
        while(continueOrNot()){
            t = dataFromUser();
            triangles.add(t);
        }
    }
    private void sortTriangles(){
        triangles.sort(Comparator.comparing(Triangle::getArea));
        Collections.reverse(triangles);
    }
    private void printTriangles(){
        System.out.println(outro);
        for(Triangle triangle : triangles){
            triangle.getResult();
        }
    }
    private Triangle dataFromUser() {
        System.out.println("Please add triangle: ");

        Scanner scanKeyboardInput = new Scanner(System.in);
        if(scanKeyboardInput.hasNextLine() ){
            //Read the whole input from user and transfer it to String[] array;
            String[] parametersOfTriangle = scanKeyboardInput.nextLine().split(",");
            return scan(parametersOfTriangle);
        }
        System.out.println("You added no triangle. Please try again!");
        return dataFromUser();
    }

    private boolean continueOrNot(){
        System.out.println(nextOr);
        String currentAnswer = "";
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()){
            currentAnswer = scanner.next();
            if(currentAnswer.equalsIgnoreCase("yes") || currentAnswer.equalsIgnoreCase("y")){
                return true;
            }
        }
        return false;
    }

    //sub-method to get separated arguments from String that user gave
    private Triangle scan(String[] parameters){
        String name = "";
        float a =0, b = 0, c = 0;
        if(parameters.length == 4){
            for(int i = 0; i < 4; i++){
                Scanner scanner = new Scanner(parameters[i]);
                if(i == 0){
                    name = parameters[i];
                }
                else if (scanner.hasNextFloat()){
                    if( i == 1){
                        a = scanner.nextFloat();
                    }
                    else if(i == 2){
                        b = scanner.nextFloat();

                    }
                    else if(i == 3){
                        c = scanner.nextFloat();
                    }

                }
                else{
                    System.out.println(notAStatement);
                    dataFromUser();
                }
            }
        }
        return new Triangle(name, a, b, c);
    }


}


