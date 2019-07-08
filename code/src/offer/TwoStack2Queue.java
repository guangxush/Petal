package offer;

import java.util.Stack;

/**
 * @author: guangxush
 * @create: 2019/07/09
 */
public class TwoStack2Queue {
    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();

    public void offer(int i){
        stack1.push(i);
    }

    public int poll(){
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            throw new IllegalArgumentException("no elements");
        }
    }

    public int getLength(){
        return stack1.size()+stack2.size();
    }
}
