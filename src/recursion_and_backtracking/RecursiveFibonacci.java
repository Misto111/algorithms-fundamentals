package recursion_and_backtracking;

import java.util.Scanner;

public class RecursiveFibonacci {

    static long fibonacci(int n) {
        if (n <= 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(fibonacci(scanner.nextInt()));

    }
}
