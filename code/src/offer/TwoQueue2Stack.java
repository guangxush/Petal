package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: guangxush
 * @create: 2019/07/09
 */
public class TwoQueue2Stack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int i) {
        if (!queue1.isEmpty()) {
            queue1.offer(i);
        } else {
            queue2.offer(i);
        }
    }

    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new IllegalArgumentException("no elements");
        }
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else{
            while (queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }
}
