package exercise_recursion_and_combinatorial_algorithms;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TowerOfHanoi {

    public static StringBuilder stringBuilder = new StringBuilder();

    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();

    public static int steps = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int disk = Integer.parseInt(scanner.nextLine());

        for (int i = disk; i >= 1; i--) {
            source.push(i);
        }

        printRods();
        solve(disk, source, destination, spare);

        System.out.println(stringBuilder.toString());

    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            steps++;
            stringBuilder
                    .append("Step #")
                    .append(steps)
                    .append(": Moved disk")
                    .append(System.lineSeparator());

            printRods();
        } else {
            solve(disk - 1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disk - 1, spare, destination, source);
        }
    }

    public static void printRods() {
       stringBuilder.append(String.format("Source: %s%nDestination: %s%nSpare: %s%n",
                formatRod(source),
                formatRod(destination),
                formatRod(spare)))
               .append(System.lineSeparator());
    }

    private static String formatRod(Deque<Integer> stack) {
        return stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
