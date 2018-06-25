public class _213 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 0){
            return 0;
        }
        return Math.max(helper(nums, 1, nums.length - 1), helper(nums, 0, nums.length - 2));
    }

    public int helper(int[] nums, int start, int end){

        int[] dp = new int[2];
        dp[0] = nums[start];
        dp[1] = 0;
        for(int i = start + 1; i <= end; i++){
            int tmp = dp[0];
            dp[0] = dp[1] + nums[i];
            dp[1] = Math.max(tmp, dp[1]);
        }
        return Math.max(dp[0],dp[1]);
    }

    public static void main(String[] args) {
        _213 s = new _213();
        s.rob(new int[]{1,2,3,1});
    }

}
