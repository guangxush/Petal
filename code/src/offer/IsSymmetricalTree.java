package offer;

/**
 * @author: guangxush
 * @create: 2019/09/12
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetricalTree {
    boolean isSymmetrical(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.value==right.value&&isSymmetrical(left.left,right.right)&&isSymmetrical(left.right, right.left);
    }
}
