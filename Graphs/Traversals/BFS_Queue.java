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