package offer;

/**
 * @author: guangxush
 * @create: 2019/09/10
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationListNode {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode result = pHead;
        while(pHead.next!=null){
            if(pHead.data!=pHead.next.data){
                pHead = pHead.next;
            }else{
                pHead.next = pHead.next.next;
            }
        }
        return result;
    }
}
