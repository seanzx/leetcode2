
public class _337 {
    public int rob(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] helper(TreeNode root){
        if(root == null){
            return new int[2];
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int notContainsRoot = Math.max(right[0], Math.max(left[0],
                Math.max(left[1], right[1])));
        int containsRoot = Math.max(left[0], right[0]) + root.val;

        return new int[]{notContainsRoot, containsRoot};
    }

    public static void main(String[] args) {
        _337 s = new _337();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        s.rob(root);
    }
}
