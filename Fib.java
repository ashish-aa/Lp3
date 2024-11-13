public class Fib {
    // Recursive Fibonacci method
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci method
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        
        int prev1 = 0, prev2 = 1, current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        int n = 10;  // Number of terms to display

        System.out.println("Recursive Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();

        System.out.println("Iterative Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciIterative(i) + " ");
        }
    }
}
