class Solution {
    public int numIslands(char[][] grid){
        int island = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    island++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return island;
    }
    private void dfs(int r, int c, char[][] grid, boolean[][] visited){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            //out of bound fuck off.
            return;
        }
        if(grid[r][c] == '1' && visited[r][c] == false){
            visited[r][c]=true;
            dfs(r+1,c,grid,visited);
            dfs(r-1,c,grid,visited);
            dfs(r,c+1,grid,visited);
            dfs(r,c-1,grid,visited);
        }

    }
}