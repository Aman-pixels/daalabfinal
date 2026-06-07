import java.util.*;

public class tsp1 {

    static int N;
    static int minCost = Integer.MAX_VALUE;

    static void tsp(int[][] graph,
                    boolean[] visited,
                    int currPos,
                    int count,
                    int cost,
                    int start) {

        if (count == N &&
            graph[currPos][start] > 0) {

            minCost = Math.min(
                    minCost,
                    cost + graph[currPos][start]);

            return;
        }

        for (int i = 0; i < N; i++) {

            if (!visited[i] &&
                graph[currPos][i] > 0) {

                visited[i] = true;

                tsp(graph,
                    visited,
                    i,
                    count + 1,
                    cost + graph[currPos][i],
                    start);

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        N = sc.nextInt();

        int[][] graph = new int[N][N];

        System.out.println("Enter cost matrix:");

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                graph[i][j] = sc.nextInt();

        boolean[] visited = new boolean[N];

        visited[0] = true;

        tsp(graph,
            visited,
            0,
            1,
            0,
            0);

        System.out.println("Minimum Cost = " + minCost);
    }
}