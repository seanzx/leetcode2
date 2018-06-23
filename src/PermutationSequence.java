import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> l = new ArrayList();
        for(int i = 1; i <= n; i++){
            l.add(i);
        }
        int[] factor = new int[n];
        factor[0] = 1;
        for(int i = 1; i < n; i++){
            factor[i] = factor[i-1] * i;
        }
        k--;
        StringBuilder ans = new StringBuilder();
        for(int i = 1; i <= n; i++){
            int index = k/factor[n - i];
            ans.append(l.get(index));
            l.remove(index);
            k -= index * factor[n - i];
        }

        return ans.toString();
    }
}
