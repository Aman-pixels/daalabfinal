import java.util.*;

public class dijkstra1 {

    int minDistance(int dist[], boolean visited[], int V) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {

            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    void dijkstra(int graph[][], int src, int V) {

        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited, V);

            visited[u] = true;

            for (int v = 0; v < V; v++) {

                if (!visited[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("\nShortest distances from Source " + src + ":");

        for (int i = 0; i < V; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("Enter Adjacency Matrix:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter Source Vertex: ");
        int src = sc.nextInt();

        dijkstra1 obj = new dijkstra1();

        obj.dijkstra(graph, src, V);

        sc.close();
    }
}