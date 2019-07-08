package offer;

import java.util.Arrays;

/**
 * @author: guangxush
 * @create: 2019/07/08
 */
public class ConstructBinaryNode {
    public static void main(String[] args) throws Exception {
        int[] preSort = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inSort = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] postSort = {7, 4, 2, 5, 8, 6, 3, 1};
        TreeNode root = constructCore(preSort, inSort);
        TreeNode root2 = constructCore2(postSort, inSort);
    }

    public static TreeNode constructCore(int[] preorder, int[] inorder) throws Exception {
        if (preorder == null && inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            throw new Exception("长度不一致");
        }
        TreeNode root = new TreeNode();
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.value = inorder[i];
                System.out.println(root.value);
                root.left = constructCore(Arrays.copyOfRange(preorder, 1, i + 1),
                        Arrays.copyOfRange(inorder, 0, i));
                root.right = constructCore(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }

    public static TreeNode constructCore2(int[] postorder, int[] inorder) throws Exception {
        if (postorder == null && inorder == null) {
            return null;
        }
        if (postorder.length != inorder.length) {
            throw new Exception("长度不一致");
        }
        TreeNode root = new TreeNode();
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == postorder[n - 1]) {
                root.value = inorder[i];
                System.out.println(root.value);
                root.left = constructCore2(Arrays.copyOfRange(postorder, 0, i),
                        Arrays.copyOfRange(inorder, 0, i));
                root.right = constructCore2(Arrays.copyOfRange(postorder, i, n - 1),
                        Arrays.copyOfRange(inorder, i + 1, n));
            }
        }
        return root;
    }
}
