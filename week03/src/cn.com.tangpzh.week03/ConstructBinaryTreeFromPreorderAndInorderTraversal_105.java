package cn.com.tangpzh.week03;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        ConstructBinaryTreeFromPreorderAndInorderTraversal_105 test = new ConstructBinaryTreeFromPreorderAndInorderTraversal_105();
        TreeNode node = test.method1(preorder, inorder);
        System.out.println(node);
    }

    // 暴力递归
    public TreeNode method1(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode tree = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                tree.left = method1(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                tree.right = method1(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return tree;
    }


}
