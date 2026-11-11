class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
    private int solve(int n){
        if(n <= 1) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

// class Solution {
//     int[] dp;
//     public int climbStairs(int n) {
//         dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         return solve(n);
//     }
//     private int solve(int n){
//         if(n == 0) return 1;
//         if(n == 1) return 1;
//         if(dp[n] != -1) return dp[n];
//         dp[n] = solve(n-1)+solve(n-2);//but i need to also set the dp? here itself? somewhere?
//         return dp[n];
//     }
// }