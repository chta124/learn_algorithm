package cn.com.tangpzh.week03;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    private static TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode node = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            node = new TreeNode(value);
            node.left = createBinaryTreeByArray(array, 2 * index + 1);
            node.right = createBinaryTreeByArray(array, 2 * index + 2);
            return node;
        }
        return node;
    }

    public static TreeNode initTreeNode(Integer[] array) {
        return TreeNode.createBinaryTreeByArray(array, 0);
    }


}