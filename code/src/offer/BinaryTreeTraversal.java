package offer;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author: guangxush
 * @create: 2019/07/08
 */
public class BinaryTreeTraversal {
    
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
 
        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        postOrderRecur(head);
        System.out.println();
 
        // unrecursive
        System.out.println("============unrecursive=============");
        System.out.print("pre-order: ");
        preOrderUnrecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderUnrecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        postOrderUnrecur(head);
        System.out.println();
        System.out.println("=============levelOrderTraversal============");
        levelOrderTraversal(head);
        System.out.println();
        System.out.println("============depthTraversal=============");
        depthTraversal(head);
    }

    /**
     * ==============recursive==============
     * pre-order: 5 3 2 1 4 8 7 6 10 9 11 
     * in-order: 1 2 3 4 5 6 7 8 9 10 11 
     * pos-order: 1 2 4 3 6 7 9 11 10 8 5 
     * ============unrecursive=============
     * pre-Order:5 3 2 1 4 8 7 6 10 9 11 
     * in-Order:1 2 3 4 5 6 7 8 9 10 11 
     * post-Order;1 2 4 3 6 7 9 11 10 8 5 
     * level-Order:5 3 8 2 4 7 10 1 6 9 11 
     */

    /**
     * 先序遍历递归
     * @param node
     */
    public static void preOrderRecur(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    /**
     * 先序遍历非递归
     * 实现的思路：使用辅助的数据结构栈来实现，每一次循环出栈，先存放当前节点右边元素，再存放左边元素
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
            System.out.print(temp.value+" ");
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
    public static void postOrderRecur(TreeNode node){
        if(node==null){
            return;
        }
        postOrderRecur(node.left);
        postOrderRecur(node.right);
        System.out.print(node.value+" ");
    }

    /**
     * 后序遍历非递归实现
     * @param node
     */
    public static void postOrderUnrecur(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if(temp.left!=null&&node!=temp.left&&node!=temp.right){
                // 左子树没有打印完毕
                stack.push(temp.left);
            }else if(temp.right!=null&&node!=temp.right){
                // 右子树没有打印完毕
                stack.push(temp.right);
            }else{
                System.out.print(stack.pop().value+" ");
                node = temp;
            }
        }
    }
    
    /**
     * 实现思路：上面我们实现了二叉树的先序遍历（中左右）也即当前节点，先将右孩子入栈，在将左孩子入栈，
     * 现在将其修改为中右左（也即当前节点，先将左孩子入栈，在将右孩子入栈），如此我们就实现中右左的结构
     * 但是在打印的时候，我们不打印，我们在将其存放到另外一个栈中去，然后在出栈，就会是（左右中）后续遍历
     */
    public static void postOrder(TreeNode head) {
        System.out.print("post-Order;");
        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.empty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历递归实现
     * @param node
     */
    public static void inOrderRecur(TreeNode node){
        if(node==null){
            return;
        }
        inOrderRecur(node.left);
        System.out.print(node.value+" ");
        inOrderRecur(node.right);
    }

    /**
     * 中序遍历非递归实现
     * 二叉树的中序遍历，非递归实现
     * 实现思路：使用辅助数组栈，从头节点开始，一路向左入栈，直到当前节点为空；然后当前节点指向栈顶弹出的元素
     * 打印当前节点，然后当前节点在指向当前节点的右节点。一直进行此过程。直到栈为空
     * @param node
     */
    public static void inOrderUnrecur(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||node!=null){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                System.out.print(node.value+" ");
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
            System.out.print(temp.value+" ");
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
            System.out.print(temp.value+" ");
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

}
