class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int components = 0;
        int[] visited = new int[V];
        for(int i = 0; i<V; i++){
            if(visited[i] != 1){
                components++;
                dfs(i,visited,edges);
                //call dfs on it. and let it finish naturally.
            } // else we skip and go to next index? huh? is this it?
        }
        return components;
    }
    private void dfs(int node, int[] visited, List<List<Integer>> edges){
        visited[node]=1;
        for(int neighbour : edges.get(node)){
            if(visited[neighbour]!=1){
                dfs(neighbour,visited,edges);
            }
        }
    }
}
