public class _221 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    int a = i-1 >= 0 && j-1 >= 0 ? dp[i-1][j-1] : 0;
                    int b = i-1 >= 0 ? dp[i-1][j] : 0;
                    int c = j-1 >= 0 ? dp[i][j-1] : 0;
                    dp[i][j] = Math.min(Math.min(a, b), c) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _221 s = new _221();
        s.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
}
