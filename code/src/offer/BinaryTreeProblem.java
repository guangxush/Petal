package offer;

import javax.xml.soap.Node;
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
     * @param tree
     * @return
     */
    public static int calBinaryTreeLength(TreeNode tree){
        if(tree==null){
            return 0;
        }else{
            return 1+Math.max(calBinaryTreeLength(tree.left),calBinaryTreeLength(tree.right));
        }
    }

    /**
     * 计算二叉树最小深度
     * @param tree
     * @return
     */
    public static int calBinaryTreeMinLength(TreeNode tree){
        if(tree == null){
            return 0;
        }else{
            return 1+Math.min(calBinaryTreeMinLength(tree.left),calBinaryTreeMinLength(tree.right));
        }
    }

    /**
     * 非递归实现镜像二叉树
     * @param root
     */
    public static void mirrorBinaryTree(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode root1 = stack.pop();
            TreeNode temp = root1.left;
            root1.left = root1.right;
            root1.right = temp;
            if(root1.right!=null){
                stack.push(root1.right);
            }
            if(root1.left!=null){
                stack.push(root1.left);
            }
        }
    }

    /**
     * 二叉树镜像递归实现
     * @param root
     * @return
     */
    public static TreeNode mirrorBinaryTreeRec(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null){
            mirrorBinaryTree(root.left);
        }
        if(root.right!=null){
            mirrorBinaryTree(root.right);
        }
        return root;
    }

    /**
     * 层次遍历二叉树并打印
     * @param root
     */
    public static void printBinaryTree(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            System.out.println(root.value);
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        //层分隔符
        queue.add(null);
        queue.add(root);
        while(queue.size()!=1){
            TreeNode temp = queue.removeFirst();
            //到达分割层
            if(temp==null){
                Iterator<TreeNode> it = queue.iterator();
                while(it.hasNext()){
                    System.out.print(it.next().value+" ");
                }
                System.out.println();
                queue.add(null);
                continue;
             }
            if(temp.left!=null){
                queue.addLast(temp.left);
            }
            if(temp.right!=null){
                queue.addLast(temp.right);
            }
        }
    }
}
