package offer;

import java.util.Stack;

/**
 * @author: guangxush
 * @create: 2019/07/08
 * 题目:输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class PrintListReverse {
    public static void main(String[] args) {
        ListNode node1=new ListNode();
        ListNode node2=new ListNode();
        ListNode node3=new ListNode();
        node1.data=1;
        node2.data=2;
        node3.data=3;
        node1.next=node2;
        node2.next=node3;
        printListReverse(node1);
        printListReverse1(node1);

    }
    public static void printListReverse(ListNode headNode){
        Stack<ListNode> stack = new Stack<>();
        while(headNode!=null){
            stack.push(headNode);
            headNode = headNode.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().data);
        }
    }

    /**
     * 递归方式打印
     * @param headNode
     */
    public static void printListReverse1(ListNode headNode){
        if(headNode.next!=null){
            printListReverse1(headNode.next);
            System.out.println(headNode.data);
        }else{
            System.out.println(headNode.data);
        }
    }
}
