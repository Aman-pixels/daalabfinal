import java.util.*;

public class topological {

    static void topologicalSortUtil(int v, boolean[] visited,
                                    Stack<Integer> stack,
                                    ArrayList<ArrayList<Integer>> adj) {

        visited[v] = true;

        for (int i : adj.get(v)) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack, adj);
            }
        }

        stack.push(v);
    }

    static void topologicalSort(int V,
                                ArrayList<ArrayList<Integer>> adj) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack, adj);
            }
        }

        System.out.println("Valid Task Execution Order:");

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int V = sc.nextInt();

        System.out.print("Enter number of dependencies: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter dependencies (source destination):");

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }

        topologicalSort(V, adj);
    }
}