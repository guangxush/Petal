package offer;

import java.util.Stack;

/**
 * @author: guangxush
 * @create: 2019/08/23
 */
public class StackWithMinFunction {

    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();
    Integer temp = null;

    public void push(int node) {
        if (temp != null) {
            if (node <= temp) {
                temp = node;
                min.push(node);
            }
            data.push(node);
        } else {
            temp = node;
            data.push(node);
            min.push(node);
        }

    }

    public void pop() {
        int num = data.pop();
        int num2 = min.pop();
        if (num != num2) {
            min.push(num2);
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
/**
 * 应用一个辅助栈，压的时候，如果A栈的压入比B栈压入大，B栈不压，小于等于，AB栈同时压入，出栈，如果，AB栈顶元素不等，A出，B不出。
 */
