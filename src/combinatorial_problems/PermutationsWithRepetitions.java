package combinatorial_problems;

import java.util.HashSet;
import java.util.Scanner;

public class PermutationsWithRepetitions {
    public static String[] elements;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split(" ");

        permuteWithRepetitions(0);
    }

    public static void permuteWithRepetitions(int index) {
        if (index >= elements.length) {
            print(elements);
            return;
        } else {
            permuteWithRepetitions(index + 1);
            HashSet<String> swapped = new HashSet<>();
            swapped.add(elements[index]);
            for (int i = index + 1; i < elements.length; i++) {
                if (!swapped.contains(elements[i])) {
                    swap(elements, index, i);
                    permuteWithRepetitions(index + 1);
                    swap(elements, index, i);
                    swapped.add(elements[i]);
                }
            }
        }
    }

    private static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
