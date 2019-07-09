package offer;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author: guangxush
 * @create: 2019/07/09
 * 链表问题
 */
public class LinkNodeProblem {

    /**
     * 链表反转
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        while (now != null) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void printListNode(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 找出链表中第k个元素
     *
     * @param node
     * @param k
     * @return
     */
    public static int findLastKthElement(ListNode node, int k) {
        ListNode now = node;
        for (; now.next != null; k--) {
            now = now.next;
        }
        while (now != null) {
            node = node.next;
            now = now.next;
        }
        return node.data;
    }

    /**
     * 删除链表中第k个元素
     *
     * @param node
     * @param k
     * @return
     */
    public static ListNode deleteKthELement(ListNode node, int k) {
        ListNode now = node;
        for (int i = 0; i < k; i++) {
            now = now.next;
            if (now.next == null) {
                throw new IllegalArgumentException("the kth element not exist!");
            }
        }
        now.next = now.next.next;
        return node;
    }

    /**
     * 插入一个节点
     *
     * @param node
     * @param k
     * @param value
     * @return
     */
    public static ListNode insertKthElement(ListNode node, int k, int value) {
        ListNode now = node;
        for (int i = 0; i < k; i++) {
            now = now.next;
            if (now.next == null) {
                throw new IllegalArgumentException("the kth element not exist!");
            }
        }
        System.out.println(now.data);
        ListNode temp = new ListNode(value);
        ListNode next = now.next;
        now.next = temp;
        temp.next = next;
        return node;
    }

    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    public static boolean isCircle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对链表元素排序输出
     *
     * @param head
     */
    public static void sortListNode(ListNode head) {
        Set set = new TreeSet();
        while (head != null) {
            set.add(head.data);
            head = head.next;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    /**
     * 反向打印单链表
     *
     * @param head
     */
    public static void printListReverse(ListNode head) {
        Stack stack = new Stack();
        while (head != null) {
            stack.push(head.data);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    /**
     * 递归实现反向打印单链表
     *
     * @param head
     */
    public static void printListReverseRecur(ListNode head) {
        if (head != null && head.next != null) {
            printListReverseRecur(head.next);
        }
        System.out.println(head.data + " ");
    }

    /**
     * 合并两个有序的单链表
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeTwoSortList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = null;
        if (head1.data < head2.data) {
            head = head1;
            head.next = mergeTwoSortList(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeTwoSortList(head1, head2.next);
        }
        return head;
    }
}
