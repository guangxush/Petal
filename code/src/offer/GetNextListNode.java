package offer;

/**
 * @author: guangxush
 * @create: 2019/09/12
 */
public class GetNextListNode {
    public TreeLinkNode GetNext(TreeLinkNode node)
    {
        if(node == null){
            return null;
        }
        //如果有右子树，找到右子树的最左节点
        if(node.right!=null){
            node = node.right;
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }
        //没有右子树，找到第一个当前节点是父节点左孩子的节点
        while(node.next!=null){
            if(node.next.left==node){
                return node.next;
            }
            node = node.next;
        }
        //退到根节点也没有找到，返回null
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
