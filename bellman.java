import java.util.*;

class Edge {
    int src, dest, weight;
}

public class bellman {

    static void bellmanFord(Edge[] edges, int V, int E, int src) {

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for (int i = 1; i < V; i++) {

            for (int j = 0; j < E; j++) {

                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + w < dist[v]) {

                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int j = 0; j < E; j++) {

            int u = edges[j].src;
            int v = edges[j].dest;
            int w = edges[j].weight;

            if (dist[u] != Integer.MAX_VALUE &&
                dist[u] + w < dist[v]) {

                System.out.println("Negative Weight Cycle Found");
                return;
            }
        }

        System.out.println("Shortest Distances:");

        for (int i = 0; i < V; i++)
            System.out.println(src + " -> " + i + " = " + dist[i]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter edges: ");
        int E = sc.nextInt();

        Edge[] edges = new Edge[E];

        System.out.println("Enter source destination weight:");

        for (int i = 0; i < E; i++) {

            edges[i] = new Edge();

            edges[i].src = sc.nextInt();
            edges[i].dest = sc.nextInt();
            edges[i].weight = sc.nextInt();
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        bellmanFord(edges, V, E, src);
    }
}