package task3;

public class Main {
    public static boolean fuzzySearch(String searchString, String input) {
        if (searchString == null || input == null) {
            return false;
        }

        int searchStringIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            if (searchString.charAt(searchStringIndex) == input.charAt(i)) {
                searchStringIndex++;
                if (searchStringIndex == searchString.length()) {
                    return true;
                }
            }
        }

        return false;
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
