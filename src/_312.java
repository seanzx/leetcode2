public class _312 {
    private int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i][i] = nums[i]*(i-1>=0 ? nums[i-1]: 1)*(i+1<nums.length ?nums[i+1]:1);
        }

        for(int s = 1; s < nums.length; s++){
            for(int i = 0; i < nums.length - s; i++){
                int j = i + s;
                for(int k = i; k <= j; k++){
                    int left = i - 1 >= 0 ? nums[i-1] : 1;
                    int right = j + 1 < nums.length ? nums[j+1] : 1;
                    int coin = nums[k] * left * right;
                    dp[i][j] = Math.max(dp[i][j], (k-1 >= i ? dp[i][k-1] : 0) + (k+1 <= j ? dp[k+1][j]:0) + coin);
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    public static void main(String[] args){
        _312 s = new _312();
        s.maxCoins(new int[]{3,1,5,8});
    }
}
