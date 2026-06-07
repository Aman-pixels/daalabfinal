import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class kruskal {

    static int find(int parent[], int i) {
        if (parent[i] == i)
            return i;

        return find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        Edge[] edges = new Edge[E];

        System.out.println("Enter source destination weight:");

        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
            edges[i].src = sc.nextInt();
            edges[i].dest = sc.nextInt();
            edges[i].weight = sc.nextInt();
        }

        Arrays.sort(edges);

        int[] parent = new int[V];

        for (int i = 0; i < V; i++)
            parent[i] = i;

        int count = 0;
        int cost = 0;

        System.out.println("Edges in MST:");

        for (int i = 0; count < V - 1 && i < E; i++) {

            Edge next = edges[i];

            int x = find(parent, next.src);
            int y = find(parent, next.dest);

            if (x != y) {

                System.out.println(
                        next.src + " - " +
                        next.dest + " : " +
                        next.weight);

                cost += next.weight;

                union(parent, x, y);

                count++;
            }
        }

        System.out.println("Total Cost = " + cost);
    }
}