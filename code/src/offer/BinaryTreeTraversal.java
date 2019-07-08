package offer;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author: guangxush
 * @create: 2019/07/08
 */
public class BinaryTreeTraversal {

    /**
     * 先序遍历递归
     * @param node
     */
    public static void preOrderRecur(TreeNode node){
        if(node==null){
            return;
        }
        System.out.println(node.value+" ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    /**
     * 先序遍历非递归
     * @param node
     */
    public static void preOrderUnrecur(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.value+" ");
            if(temp.right!=null){
                stack.add(temp.right);
            }
            if(temp.left!=null){
                stack.add(temp.left);
            }
        }
    }

    /**
     * 后序遍历递归实现
     * @param node
     */
    public static void posOrderRecur(TreeNode node){
        if(node==null){
            return;
        }
        preOrderRecur(node.left);
        preOrderRecur(node.right);
        System.out.println(node.value+" ");
    }

    /**
     * 后序遍历非递归实现
     * @param node
     */
    public static void posOrderUnrecur(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if(temp.left!=null&&node!=temp.left&&node.right!=temp.right){
                // 左子树没有打印完毕
                stack.push(temp.left);
            }else if(temp.right!=null&&node!=temp.right){
                // 右子树没有打印完毕
                stack.push(temp.right);
            }else{
                System.out.println(stack.pop().value+" ");
                node = temp;
            }
        }
    }

    /**
     * 中序遍历递归实现
     * @param node
     */
    public static void inOrderRecur(TreeNode node){
        if(node==null){
            return;
        }
        preOrderRecur(node.left);
        System.out.println(node.value+" ");
        preOrderRecur(node.right);
    }

    /**
     * 中序遍历非递归实现
     * @param node
     */
    public static void inOrderUnrecur(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||node!=null){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                System.out.println(node.value+" ");
                node = node.right;
            }
        }
    }

    /**
     * 广度优先遍历
     * @param node
     */
    public static void levelOrderTraversal(TreeNode node){
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            System.out.println(temp.value+" ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }

    /**
     * 深度优先遍历
     * @param node
     */
    public static void depthTraversal(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.value+" ");
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

}
