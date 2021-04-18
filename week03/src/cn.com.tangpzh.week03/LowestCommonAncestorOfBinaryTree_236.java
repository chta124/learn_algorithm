package cn.com.tangpzh.week03;

public class LowestCommonAncestorOfBinaryTree_236 {

    public static void main(String[] args) {

        TreeNode root = TreeNode.initTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        LowestCommonAncestorOfBinaryTree_236 test = new LowestCommonAncestorOfBinaryTree_236();
        TreeNode targetNode1 = test.method1(root, new TreeNode(5), new TreeNode(1));
        System.out.println(targetNode1);
        TreeNode targetNode2 = test.method2(root, new TreeNode(5), new TreeNode(1));
        System.out.println(targetNode2);
    }

    private TreeNode ans;

    public LowestCommonAncestorOfBinaryTree_236() {
        this.ans = null;
    }

    public TreeNode method1(TreeNode root, TreeNode p, TreeNode q) {
        this.method1_dfs(root, p, q);
        return this.ans;
    }

    private boolean method1_dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 查找左子树上是否包含节点p或者q
        boolean lson = method1_dfs(root.left, p, q);
        // 查找右子树上是否包含节点p或者q
        boolean rson = method1_dfs(root.right, p, q);
        // 当左子树和右子树上分别找到了q和p
        // 或者左子树上找到了p和q中的一个，而另一个正好就是root节点
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode method2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = method2(root.left, p, q);
        TreeNode right = method2(root.right, p, q);
        if (left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }


}
