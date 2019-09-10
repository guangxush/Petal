package offer;

import java.util.HashSet;

/**
 * @author: guangxush
 * @create: 2019/09/10
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationListNode {
    private HashSet<Integer> set = new HashSet<>();
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        if(pHead.data==pHead.next.data){//当前节点重复
            ListNode pNode = pHead.next;
            while(pNode!=null&&pNode.data==pHead.data){
                // 跳过与当前节点值相同的全部节点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        }else{// 当前节点不是重复节点
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}