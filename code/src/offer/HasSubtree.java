package offer;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * root2是否为root1的子树
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1==null||root2==null){
            return false;
        }
        return isSubTree(root1, root2)||isSubTree(root1.left,root2)||isSubTree(root1.right, root2);
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2){
        if(root2==null){
            // 这个时候返回true
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root2.value==root1.value){
            return isSubTree(root1.left, root2.left)&&isSubTree(root1.right, root2.right);
        }else{
            return false;
        }
    }
}
