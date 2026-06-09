import java.util.*;

public class tsp1 {

    static int N;
    static int minCost = Integer.MAX_VALUE;

    static int[] bestPath;
    static int[] currentPath;

    static void tsp(int[][] graph,
                    boolean[] visited,
                    int currPos,
                    int count,
                    int cost,
                    int start) {

        if (count == N && graph[currPos][start] > 0) {

            int totalCost = cost + graph[currPos][start];

            if (totalCost < minCost) {

                minCost = totalCost;

                for (int i = 0; i < N; i++) {
                    bestPath[i] = currentPath[i];
                }
            }

            return;
        }

        for (int i = 0; i < N; i++) {

            if (!visited[i] && graph[currPos][i] > 0) {

                visited[i] = true;
                currentPath[count] = i;

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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[N];

        bestPath = new int[N];
        currentPath = new int[N];

        visited[0] = true;
        currentPath[0] = 0;

        tsp(graph, visited, 0, 1, 0, 0);

        System.out.println("\nMinimum Cost = " + minCost);

        System.out.print("Optimal Tour = ");

        for (int i = 0; i < N; i++) {
            System.out.print(bestPath[i] + " -> ");
        }

        System.out.println(bestPath[0]);

        sc.close();
    }
}