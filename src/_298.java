public class _298 {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val){
            this.val = val;
        }
    }

    int max = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max == 2 ? 1 : max;
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int ans = 1;
        int left = helper(root.left);
        int right = helper(root.right);
        if(root.left != null && root.val == root.left.val - 1){
            ans = left + 1;
        }
        if(root.right != null && root.val == root.right.val - 1){
            ans = Math.max(right + 1, ans);
        }
        max = Math.max(ans, max);
        return ans;
    }

    public static void main(String[] args) {
        _298 s = new _298();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        s.longestConsecutive(root);
    }
}
