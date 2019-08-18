package offer;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * 有序单链表合并
 */
public class MergeListNode {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        if(list1.data<list2.data){
            head = list1;
            head.next = Merge(list1.next, list2);
        }else{
            head = list2;
            head.next = Merge(list1, list2.next);
        }
        return head;
    }
}
