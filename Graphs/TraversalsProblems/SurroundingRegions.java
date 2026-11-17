class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0 ; i< rows ; i++){
            for(int j = 0; j<cols ; j++){
                if(i == 0 || j == 0 || i == rows-1 || j == cols-1){
                    if(board[i][j] == 'O'){
                        q.offer(new int[]{i,j});
                        visited[i][j]=1;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            int[] delrow = new int[]{-1,0,0,+1};
            int[] delcol = new int[]{0,+1,-1,0};
            // check surrounding nodes with "0" and move put them in and check them as well and expand and mark them visited. and once over take 2 for loops and make all the unvisited zeros X
            for(int k = 0; k<4; k++){
                int nrow = row + delrow[k];
                int ncol = col + delcol[k];
                //check if in boundary? and 'O'??
                if(nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && board[nrow][ncol] == 'O' && visited[nrow][ncol] == 0){
                    q.offer(new int[]{nrow,ncol});
                    visited[nrow][ncol]=1;
                }
            }
        }
        for(int i = 0 ; i< rows ; i++){
            for(int j = 0; j<cols ; j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
}