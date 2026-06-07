import java.util.*;

public class nqueen {

    static int N;

    static boolean isSafe(int board[][],
                          int row,
                          int col) {

        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (int i = row, j = col;
             i >= 0 && j >= 0;
             i--, j--)

            if (board[i][j] == 1)
                return false;

        for (int i = row, j = col;
             i < N && j >= 0;
             i++, j--)

            if (board[i][j] == 1)
                return false;

        return true;
    }

    static boolean solve(int board[][], int col) {

        if (col >= N) {
            print(board);
            return true;
        }

        boolean res = false;

        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {

                board[i][col] = 1;

                res = solve(board, col + 1) || res;

                board[i][col] = 0;
            }
        }

        return res;
    }

    static void print(int board[][]) {

        System.out.println();

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        N = sc.nextInt();

        int[][] board = new int[N][N];

        solve(board, 0);
    }
}