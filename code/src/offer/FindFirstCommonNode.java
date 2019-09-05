package offer;

/**
 * @author: guangxush
 * @create: 2019/09/05
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        if (node1 == null || node2 == null) {
            return null;
        }
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        if (length1 >= length2) {
            int len = length1 - length2;
            while (len > 0) {
                node1 = node1.next;
                len--;
            }
        } else if (length1 < length2) {
            int len = length2 - length1;
            while (len > 0) {
                node2 = node2.next;
                len--;
            }
        }
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    private int getLength(ListNode pHead) {
        int length = 0;
        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
