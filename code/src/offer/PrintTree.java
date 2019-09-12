package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: guangxush
 * @create: 2019/09/12
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(pRoot==null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            list = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                list.add(temp.value);
            }
            res.add(list);
        }
        return res;
    }
}
