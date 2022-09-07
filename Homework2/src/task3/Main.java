package task3;

import java.util.stream.Collectors;

public class Main {
    public static boolean fuzzySearch(String searchString, String input) {
        String result = input.chars().mapToObj(i -> (char) i)
                .filter(x -> searchString.contains("" + x))
                .map(String::valueOf)
                .collect(Collectors.joining());

        return result.contains(searchString);
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
