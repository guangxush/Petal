package offer;

/**
 * @author: guangxush
 * @create: 2019/09/10
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null||pHead.next.next==null){
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while(fast!=slow){
            if(fast.next!=null&& fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }else{
                //没有环,返回
                return null;
            }
        }
        fast=pHead;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
