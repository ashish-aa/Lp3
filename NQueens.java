import java.util.*;

public class NQueens {
    
    // Function to check if it's safe to place a queen at board[r][c]
    public static boolean isSafe(int r, int c, int[][] board, int n) {
        int i = r, j = c;

        // Upper-left diagonal
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        // Lower-left diagonal
        i = r;
        j = c;
        while (i < n && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i++;
            j--;
        }

        // Left column
        i = r;
        j = c;
        while (j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            j--;
        }

        // Upper-right diagonal
        i = r;
        j = c;
        while (i >= 0 && j < n) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        // Lower-right diagonal
        i = r;
        j = c;
        while (i < n && j < n) {
            if (board[i][j] == 1) {
                return false;
            }
            i++;
            j++;
        }

        // Right column
        i = r;
        j = c;
        while (j < n) {
            if (board[i][j] == 1) {
                return false;
            }
            j++;
        }

        return true;
    }

    // Function to print the board
    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "Q " : ". ") + " ");
            }
            System.out.println();
        }
        System.out.println(); // New line after the board
    }

    // Function to solve the N-Queens problem using backtracking
    public static void solve(int col, int col1, int[][] board, int n, int[] cnt) {
        // If all queens are placed
        if (col == n) {
            cnt[0]++;
            System.out.println("Solution " + cnt[0] + " found:");
            printBoard(board);
            return;
        }

        // If the current column is the one with the pre-placed queen
        if (col == col1) {
            solve(col + 1, col1, board, n, cnt);
            return; // Skip placing another queen in this column
        }

        // Try placing queen in each row of the current column
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col, board, n)) {
                board[i][col] = 1; // Place queen
                System.out.println("Placing queen at (" + i + ", " + col + "):");
                printBoard(board); // Print the board after placing a queen
                solve(col + 1, col1, board, n, cnt); // Recur to place rest of the queens
                board[i][col] = 0; // Backtrack
                System.out.println("Removing queen from (" + i + ", " + col + "):");
                printBoard(board); // Print the board after removing a queen
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the matrix: ");
        int n = sc.nextInt();
        
        int[][] board = new int[n][n]; // Initialize the board with 0s
        System.out.println("Enter the first queen's position (row and column): ");
        
        System.out.print("Row: ");
        int r = sc.nextInt();
        
        System.out.print("Column: ");
        int c = sc.nextInt();
        
        // Place the first queen
        board[r][c] = 1;

        // Show the initial placement
        System.out.println("Initial board with queen placed at (" + r + ", " + c + "):");
        printBoard(board);

        int[] cnt = {0}; // Solution counter (using array to pass by reference)
        solve(0, c, board, n, cnt); // Start solving

        if (cnt[0] == 0) {
            System.out.println("No possible solutions for the given input.");
        } else {
            System.out.println("Total solutions found: " + cnt[0]);
        }

        sc.close();
    }
}
