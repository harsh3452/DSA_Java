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