import java.util.Scanner;

public class knapDp {

    // Function to solve 0-1 Knapsack problem using dynamic programming
    public static int knapsackDP(int capacity, int[] weights, int[] values, int n) {
        // Creating a DP table to store the maximum values
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // Maximize value by including or excluding the current item
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    // If item can't be included, carry forward the previous value
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        // Return the maximum value that can be achieved with the given capacity
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of items
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        // Input weights and values of the items
        System.out.println("Enter the weight and value of each item:");
        for (int i = 0; i < n; i++) {
            System.out.println("Item " + (i + 1));
            System.out.print("Weight: ");
            weights[i] = scanner.nextInt();
            System.out.print("Value: ");
            values[i] = scanner.nextInt();
        }

        // Maximum capacity of the knapsack
        System.out.print("Enter the maximum capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        // Compute the maximum value that can be achieved
        int maxValue = knapsackDP(capacity, weights, values, n);

        // Output the result
        System.out.println("Maximum value in knapsack: " + maxValue);

        scanner.close();
    }
}
