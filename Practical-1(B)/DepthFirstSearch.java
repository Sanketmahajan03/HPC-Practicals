import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstSearch {
    static List<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int startNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int currNode = stack.pop();

            if (!visited[currNode]) {
                visited[currNode] = true;
                System.out.print(currNode + " ");

                for (int adjNode : graph[currNode]) {
                    if (!visited[adjNode]) {
                        stack.push(adjNode);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes, edges, and start node: ");
        int n = scanner.nextInt(); // Number of nodes
        int m = scanner.nextInt(); // Number of edges
        int startNode = scanner.nextInt(); // Start node

        graph = new ArrayList[n];
        visited = new boolean[n];

        System.out.println("Enter pairs of edges:");
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            // u and v: Pair of edges
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(startNode);
    }
}
