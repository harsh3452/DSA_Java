import java.util.*;

class Solution {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        List<Integer> dfs = new ArrayList<>();
        int visited[] = new int[V];
        visited[0] = 1;
        Stack<Integer> st = new Stack<>();
        st.push(0);

        while (!st.isEmpty()) {
            int node = st.pop();
            dfs.add(node);
            for (int neighbour : edges.get(node)) {
                if (visited[neighbour] != 1) {
                    visited[neighbour] = 1;
                    st.push(neighbour);
                }
            }
        }
        return dfs;
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        List<Integer> bfs = new ArrayList<>();
        int visited[] = new int[V];
        Arrays.fill(visited, 0);
        visited[0] = 1;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbour : edges.get(node)) {
                if (visited[neighbour] != 1) {
                    visited[neighbour] = 1;
                    q.offer(neighbour);
                }
            }
            bfs.add(node);
        }
        return bfs;
    }
}

public class Main {
    private static List<List<Integer>> graph(int V, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // These test graphs are undirected, so add both directions.
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    private static void runTest(
            String name, int V, int[][] connections,
            List<Integer> expectedBfs, List<Integer> expectedDfs) {

        List<List<Integer>> adj = graph(V, connections);
        Solution solution = new Solution();

        List<Integer> actualBfs = solution.bfsOfGraph(V, adj);
        List<Integer> actualDfs = solution.dfsOfGraph(V, adj);

        boolean bfsPass = actualBfs.equals(expectedBfs);
        boolean dfsPass = actualDfs.equals(expectedDfs);

        System.out.println("=== " + name + " ===");
        System.out.println("Adjacency list: " + adj);
        System.out.println("BFS: " + actualBfs + " | Expected: " + expectedBfs
                + " | " + (bfsPass ? "PASS" : "FAIL"));
        System.out.println("DFS: " + actualDfs + " | Expected: " + expectedDfs
                + " | " + (dfsPass ? "PASS" : "FAIL"));
        System.out.println();
    }

    public static void main(String[] args) {
        // Test 1: Simple branching graph.
        runTest(
            "Test 1 - Simple graph",
            5,
            new int[][] {{0, 1}, {0, 2}, {1, 3}, {1, 4}},
            Arrays.asList(0, 1, 2, 3, 4),
            Arrays.asList(0, 2, 1, 4, 3)
        );

        // Test 2: Cycle. Confirms visited[] prevents repeated processing.
        runTest(
            "Test 2 - Graph with a cycle",
            4,
            new int[][] {{0, 1}, {1, 2}, {2, 0}, {2, 3}},
            Arrays.asList(0, 1, 2, 3),
            Arrays.asList(0, 2, 3, 1)
        );

        // Test 3: Disconnected graph. These methods intentionally start at 0,
        // so vertices 3 and 4 are not included in either traversal.
        runTest(
            "Test 3 - Disconnected graph",
            5,
            new int[][] {{0, 1}, {1, 2}, {3, 4}},
            Arrays.asList(0, 1, 2),
            Arrays.asList(0, 1, 2)
        );

        // Test 4: A single vertex and no edges.
        runTest(
            "Test 4 - Single vertex",
            1,
            new int[][] {},
            Arrays.asList(0),
            Arrays.asList(0)
        );

        // Test 5: A line graph.
        runTest(
            "Test 5 - Linear graph",
            5,
            new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}},
            Arrays.asList(0, 1, 2, 3, 4),
            Arrays.asList(0, 1, 2, 3, 4)
        );
    }
}
