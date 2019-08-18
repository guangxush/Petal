package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> link = new LinkedList<>();
        if(root==null){
            return list;
        }
        link.add(root);
        while(!link.isEmpty()){
            TreeNode temp = link.remove();
            list.add(temp.value);
            if(temp.left!=null){
                link.add(temp.left);
            }
            if(temp.right!=null){
                link.add(temp.right);
            }
        }
        return list;
    }
}
