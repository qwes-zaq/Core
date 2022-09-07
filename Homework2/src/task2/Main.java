package task2;

import java.util.Arrays;

public class Main {
    public static int[] getPair(int[] inputArray, int sum) {
        int[] arr = Arrays.stream(inputArray)
                .sorted()
                .filter(x -> x <= sum)
                .toArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i && arr[j] + arr[i] >= sum; j--) {
                if (arr[i] + arr[j] == sum) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] answer = getPair(new int[]{3, 4, 2, 7}, 10);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
