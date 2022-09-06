package task3;
import java.util.*;

public class Main {
    public static boolean fuzzySearch(String searchString, String input){
        // reverse every char in string to string
        int[] searchInt = searchString
                .chars()
                .toArray();

        // reverse every char in string to string and delete char, which doesn't contain in search string
        int[] inputInt = input
                .chars()
                .filter(x-> Arrays.stream(searchInt).anyMatch(i -> i == x))
                .toArray();

        char[] newInput = new char[inputInt.length];
        for (int i=0; i<inputInt.length; i++){
            newInput[i]=(char)inputInt[i];
        }

        return String.valueOf(newInput).contains(searchString);
    }
    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
    }
}
