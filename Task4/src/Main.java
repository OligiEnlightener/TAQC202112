
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    private final static String INTRO = "Hello this is file parser to count and replace substrings in given file \n";
    private final static String INSTRUCTION = " Program has two mods:  \n 1) Counting the amount of substring " +
          "occurrence in the given string \n 2) Replacing of substring in the given string with substring from user \n";
    private final static String EXAMPLE = "Examples of use: \n 1) <Path to file> <Sample string to count> \n " +
            "2) <Path to file> <Sample string to find> <Replacement string> \n";
    private final static String WRONG_ARGUMENTS = " You are using this program with incorrect parameters. \n";
    private final static String OVERWRITTEN = "Substrings are overwritten! ";


    public static void main(String[] args) {
        operateArguments(args);
    }

    private static void operateArguments(String[] args) {
        System.out.println(INTRO);
        switch(args.length){
            case 2:
                try {
                    String text = Files.readString(Path.of(args[0]));
                    String sample = args[1];
                    countEntrance(text, sample);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                Path pathToFile = Path.of(args[0]);

                String toReplace = null;
                String withString = null;
                try {
                    toReplace = args[1];
                    withString = args[2];
                } catch (Exception e) {
                    e.printStackTrace();
                }

                replaceSubstring(pathToFile, toReplace, withString);
                break;

            default:
                System.out.println(WRONG_ARGUMENTS + INSTRUCTION + EXAMPLE);
                break;
        }
    }

    public static void countEntrance(String text, String sample) {
        List<Integer> amountOfEntrance = KMPSearch(text, sample) ;
        System.out.println("Substring is " + amountOfEntrance.size() + " times given.");
    }

    public static void replaceSubstring(Path path, String toReplace, String withString){
        String text = null;

        try {
            text = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList <Integer> indexesOfEntrance = KMPSearch(text, toReplace) ;
        StringBuilder sb = new StringBuilder(text);
        for(int start : indexesOfEntrance){
            int end = start + toReplace.length();
            sb.replace(start, end, withString);
        }

        try {
            Files.write(path, Collections.singleton(sb));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(OVERWRITTEN);
    }

    private static int[] prefixFunction(String sample){
        int [] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();

        int[] prefixFunc = prefixFunction(sample);

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return found;
    }
}
