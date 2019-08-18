package offer;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast=null, result =null;
        fast = head;
        result = head;
        int a = k;
        int count = 0;
        while(fast!=null){
            fast = fast.next;
            count ++;
            if(k<1){
                result = result.next;
            }
            k--;
        }
        if(count<a){
            return null;
        }
        return result;
    }
}
