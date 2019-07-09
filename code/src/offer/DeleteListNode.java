package offer;

/**
 * @author: guangxush
 * @create: 2019/07/09
 * 题目:给定单向链表的头指针和一个结点指针，定义一个函数在 O(1)时间删除该结点
 */
public class DeleteListNode {
    public void deleteNode(ListNode head, ListNode delListNode) {
        if(head==null||delListNode==null){
            return;
        }
        if (head == delListNode){
            //删除头节点
            head = null;
        }else{
            //尾节点
            if(delListNode.next== null){
                ListNode pointListNode = head;
                while(pointListNode.next.next!=null){
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            }else{
                delListNode.data = delListNode.next.data;
                delListNode.next = delListNode.next.next;
            }

        }
    }
}
