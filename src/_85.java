import java.util.Arrays;

public class _85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int N = matrix[0].length;
        int[] left = new int[N];
        int[] right = new int[N];
        int[] height = new int[N];
        Arrays.fill(right, N);
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            int curLeft = 0;
            int curRight = N;
            for(int j = 0; j < N; j++){
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                }else{
                    height[j]++;
                }
                if(matrix[i][j] == '0'){
                    left[j] = 0;
                    curLeft = j + 1;
                }else{
                    left[j] = Math.max(left[j], curLeft);
                }
            }

            for(int j = N - 1; j >= 0; j--){
                if(matrix[i][j] == '0'){
                    right[j] = N;
                    curRight = j-1;
                }else{
                    right[j] = Math.min(right[j], curRight);
                }
                ans = Math.max(height[j] * (right[j] - left[j]), ans);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        _85 s = new _85();
        s.maximalRectangle(new char[][]{{'1','0'}});
    }
}
