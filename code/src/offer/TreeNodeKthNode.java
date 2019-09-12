package offer;

/**
 * @author: guangxush
 * @create: 2019/09/12
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class TreeNodeKthNode {
    //思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
    //所以，按照中序遍历顺序找到第k个结点就是结果。
    private int index = 0; //计数器
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot!=null){
            TreeNode node = KthNode(pRoot.left, k);
            if(node!=null){
                return node;
            }
            index ++;
            if(index==k){
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if(node!=null){
                return node;
            }
        }
        return null;
    }
}
