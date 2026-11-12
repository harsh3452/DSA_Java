class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int visited[] = new int[V];
        int pro = 0;
        for(int i = 0; i<V; i++){
            if(visited[i]!=1){
                pro++;
                dfs(i,visited,isConnected);//call dfs and get all check.
            }
        }
        return pro;
    }
    private void dfs(int node, int[] visited, int[][] isConnected){
        visited[node]=1;
        for(int i = 0; i<isConnected.length; i++){
            if(isConnected[node][i] == 1){
                if(visited[i] != 1){
                    dfs(i,visited,isConnected);
                }
            }
        }
    }
}