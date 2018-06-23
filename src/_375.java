public class _375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n][n];

        for(int s = 1; s < n; s++){
            for(int i = 0; i < n - s; i++){
                int j = i+s;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++){
                    dp[i][j]  = Math.min(dp[i][j], Math.max( k-1< 0 ? 0 :dp[i][k-1], k+1 >= n ? 0 : dp[k+1][j]) + k+1);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String args[]){

        _375 s = new _375();
        s.getMoneyAmount(10);
    }
}
