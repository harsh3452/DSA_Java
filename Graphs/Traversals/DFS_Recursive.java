class Solution {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
      List<Integer> dfs = new ArrayList<>();
      int[] visited = new int[V];
      dfs(0,visited,edges,dfs);
      return dfs;
    }
    
    private void dfs(int node, int[] visited, List<List<Integer>> edges, List<Integer> dfs){
        visited[node]=1;
        dfs.add(node);
        for(int neighbour : edges.get(node)){
            if(visited[neighbour] != 1) {
                dfs(neighbour,visited,edges,dfs);
            }
        }
        return;
    }
}

