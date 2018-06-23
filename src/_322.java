public class _322 {
    private int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i <= amount; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i/coins[0];
            }else{
                dp[0][i] = -1;
            }
        }

        for(int j = 0; j <= amount ;j++){
            for(int i = 1; i < coins.length; i++){
                dp[i][j] = dp[i-1][j];
                if(j - coins[i] >= 0 && dp[i][j-coins[i]] >= 0){
                    if(dp[i][j] == -1){
                        dp[i][j] = dp[i][j-coins[i]] + 1;
                    }else
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i]] + 1);
                }
            }
        }

        return dp[coins.length - 1][amount];
    }

    public static void main(String[] args){
        _322 s = new _322();
        s.coinChange(new int[]{2,5, 10,1},27);
    }
}
