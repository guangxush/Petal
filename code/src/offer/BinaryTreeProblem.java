package offer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: guangxush
 * @create: 2019/07/09
 * 二叉树问题求解
 */
public class BinaryTreeProblem {

    /**
     * 计算二叉树深度
     *
     * @param tree
     * @return
     */
    public static int calBinaryTreeLength(TreeNode tree) {
        if (tree == null) {
            return 0;
        } else {
            return 1 + Math.max(calBinaryTreeLength(tree.left), calBinaryTreeLength(tree.right));
        }
    }

    /**
     * 计算二叉树最小深度
     *
     * @param tree
     * @return
     */
    public static int calBinaryTreeMinLength(TreeNode tree) {
        if (tree == null) {
            return 0;
        } else {
            return 1 + Math.min(calBinaryTreeMinLength(tree.left), calBinaryTreeMinLength(tree.right));
        }
    }

    /**
     * 非递归实现镜像二叉树
     *
     * @param root
     */
    public static void mirrorBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode root1 = stack.pop();
            TreeNode temp = root1.left;
            root1.left = root1.right;
            root1.right = temp;
            if (root1.right != null) {
                stack.push(root1.right);
            }
            if (root1.left != null) {
                stack.push(root1.left);
            }
        }
    }

    /**
     * 二叉树镜像递归实现
     *
     * @param root
     * @return
     */
    public static TreeNode mirrorBinaryTreeRec(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirrorBinaryTree(root.left);
        }
        if (root.right != null) {
            mirrorBinaryTree(root.right);
        }
        return root;
    }

    /**
     * 层次遍历二叉树并打印
     *
     * @param root
     */
    public static void printBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        //层分隔符
        queue.add(null);
        queue.add(root);
        while (queue.size() != 1) {
            TreeNode temp = queue.removeFirst();
            //到达分割层
            if (temp == null) {
                Iterator<TreeNode> it = queue.iterator();
                while (it.hasNext()) {
                    System.out.print(it.next().data + " ");
                }
                System.out.println();
                queue.add(null);
                continue;
            }
            if (temp.left != null) {
                queue.addLast(temp.left);
            }
            if (temp.right != null) {
                queue.addLast(temp.right);
            }
        }
    }

    /**
     * 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树 中任意结点的左右子树的深度相差不超过1，那么他就是一棵平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalancedBinaryTree(TreeNode root) {
        int depth = 0;
        return isBalanced(root, depth);
    }

    private boolean isBalanced(TreeNode root, int depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        int left = 0, right = 0;
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left - right;
            if (diff <= 1&& diff >= -1) {
                depth = 1+(left>right?left:right);
                return true;
            }
        }
        return false;
    }

    public boolean hasSubTree(TreeNode root1,TreeNode
            root2){
        boolean result=false; if(root1!=null&&root2!=null){
        } }
if(root1.data==root2.data){ result=doesTree1HavaTree2(root1,root2); if(!result)
        result=hasSubTree(root1.leftNode, root2); if(!result)
        result=hasSubTree(root1.rightNode, root2); return result;
    }
    private boolean doesTree1HavaTree2(TreeNode root1, TreeNode root2) {
        if(root2==null){ return true;
        }else if(root1==null) return false;
        if(root1.data!=root2.data){ return false;
        }
        return doesTree1HavaTree2(root1.leftNode, root2.leftNode)&&
                doesTree1HavaTree2(root1.rightNode, root2.rightNode);
    }
}
