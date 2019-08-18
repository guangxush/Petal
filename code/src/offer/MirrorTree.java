package offer;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * 镜像二叉树
 */
public class MirrorTree {
    public void Mirror(TreeNode root) {
        TreeNode temp;
        if(root!=null){
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left!=null){
                Mirror(root.left);
            }
            if(root.right!=null){
                Mirror(root.right);
            }
        }
    }
}
