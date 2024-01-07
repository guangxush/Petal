## 二维数组中的查找

### 题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

### 解决思路
从数组的右上角开始找，比右上角的元素小说明在这一行，比右上角元素大说明在下一行

### 代码实现
```java
public class FindBinaryArrayElement {
    public static boolean find(int[][] array, int number) {
        if (array == null) {
            return false;
        }
        int column = array[0].length - 1;
        int row = 0;
        while (row < array.length && column >= 0) {
            if (array[row][column] == number) {
                return true;
            }
            if (array[row][column] > number) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}

```

## 替换空格

### 题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

### 解决思路
遍历字符串，遇到空格使用%20字符替换

### 代码实现
```java
public class ReplaceBlank {
    public static void main(String[] args) {
        String s="We are happy.";
        System.out.println(replaceBlank(s));
        System.out.println(s.replaceAll(" " ,"%20"));
    }
    public static String replaceBlank(String input){
        if(input==null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==' '){
                sb.append("%");
                sb.append("2");
                sb.append("0");
            }else{
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

}
```


## 从尾到头打印单链表

### 题目描述
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。


### 解决思路
1. 顺序遍历并且使用栈存储元素，然后元素出栈放入到链表里面
2. 递归的方式打印链表

### 代码实现
```java
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
```


## 重建二叉树

### 题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

### 解决思路
采用递归的方式，保存前序遍历，中序遍历和当前根节点

### 代码实现
```java
public class ConstructBinaryNode {
    public static void main(String[] args) throws Exception {
        int[] preSort = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inSort = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] postSort = {7, 4, 2, 5, 8, 6, 3, 1};
        TreeNode root = constructCore(preSort, inSort);
        TreeNode root2 = constructCore2(postSort, inSort);
    }

    public static TreeNode constructCore(int[] preorder, int[] inorder) throws Exception {
        if (preorder == null && inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            throw new Exception("长度不一致");
        }
        TreeNode root = new TreeNode();
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.value = inorder[i];
                System.out.println(root.value);
                root.left = constructCore(Arrays.copyOfRange(preorder, 1, i + 1),
                        Arrays.copyOfRange(inorder, 0, i));
                root.right = constructCore(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }

    public static TreeNode constructCore2(int[] postorder, int[] inorder) throws Exception {
        if (postorder == null && inorder == null) {
            return null;
        }
        if (postorder.length != inorder.length) {
            throw new Exception("长度不一致");
        }
        TreeNode root = new TreeNode();
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == postorder[n - 1]) {
                root.value = inorder[i];
                System.out.println(root.value);
                root.left = constructCore2(Arrays.copyOfRange(postorder, 0, i),
                        Arrays.copyOfRange(inorder, 0, i));
                root.right = constructCore2(Arrays.copyOfRange(postorder, i, n - 1),
                        Arrays.copyOfRange(inorder, i + 1, n));
            }
        }
        return root;
    }
}
```

根据前序和后序
```java
class Solution {
 public TreeNode constructFromPrePost(int[] pre, int[] post) {
    return dfs(pre, 0, pre.length - 1, post, 0, pre.length - 1);
 }
 private TreeNode dfs(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd){
    if(preStart > preEnd){
     return null;
    }
    TreeNode root = new TreeNode(pre[preStart]);
    // 已经遍历完成的，直接返回最后一个节点
    if (preStart == preEnd) {
     return root;
    }
    // post节点从初始位置开始数，直到当前节点等于 前序遍历当前节点的下一个节点，因为下一节点为左右节点分割线
    int postIndex = postStart;
    while(post[postIndex] != pre[preStart + 1]){
     postIndex++;
    }
    // 获取左侧节点的长度
    int len = postIndex - postStart + 1;
    // 左侧节点的pre为 start+1往后数len个长度；post节点为start开始往后到postIndex
    root.left = dfs(pre, preStart+1, preStart+len, post, postStart, postStart+len);
    // 右侧节点的pre为从preStart+len+1开始一直到结束preEnd；post节点为postStart+len开始到去掉最后的根结点
    root.right = dfs(pre, preStart+len+1, preEnd, post, postStart+len, postEnd - 1);
    // 注意pre都+1是因为第一个节点为根结点，要去掉
    return root;
 }
}
```

二叉树其他题目
```java
public class BinaryTreeTraversal {

    /**
     * 先序遍历递归
     * @param node
     */
    public static void preOrderRecur(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    /**
     * 先序遍历非递归
     * 实现的思路：使用辅助的数据结构栈来实现，每一次循环出栈，先存放当前节点右边元素，再存放左边元素
     * @param node
     */
    public static void preOrderUnrecur(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.value+" ");
            if(temp.right!=null){
                stack.add(temp.right);
            }
            if(temp.left!=null){
                stack.add(temp.left);
            }
        }
    }

    /**
     * 后序遍历递归实现
     * @param node
     */
    public static void postOrderRecur(TreeNode node){
        if(node==null){
            return;
        }
        postOrderRecur(node.left);
        postOrderRecur(node.right);
        System.out.print(node.value+" ");
    }

    /**
     * 后序遍历非递归实现
     * @param node
     */
    public static void postOrderUnrecur(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if(temp.left!=null&&node!=temp.left&&node!=temp.right){
                // 左子树没有打印完毕
                stack.push(temp.left);
            }else if(temp.right!=null&&node!=temp.right){
                // 右子树没有打印完毕
                stack.push(temp.right);
            }else{
                System.out.print(stack.pop().value+" ");
                node = temp;
            }
        }
    }
    
    /**
     * 实现思路：上面我们实现了二叉树的先序遍历（中左右）也即当前节点，先将右孩子入栈，在将左孩子入栈，
     * 现在将其修改为中右左（也即当前节点，先将左孩子入栈，在将右孩子入栈），如此我们就实现中右左的结构
     * 但是在打印的时候，我们不打印，我们在将其存放到另外一个栈中去，然后在出栈，就会是（左右中）后续遍历
     */
    public static void postOrder(TreeNode head) {
        System.out.print("post-Order;");
        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.empty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历递归实现
     * @param node
     */
    public static void inOrderRecur(TreeNode node){
        if(node==null){
            return;
        }
        inOrderRecur(node.left);
        System.out.print(node.value+" ");
        inOrderRecur(node.right);
    }

    /**
     * 中序遍历非递归实现
     * 二叉树的中序遍历，非递归实现
     * 实现思路：使用辅助数组栈，从头节点开始，一路向左入栈，直到当前节点为空；然后当前节点指向栈顶弹出的元素
     * 打印当前节点，然后当前节点在指向当前节点的右节点。一直进行此过程。直到栈为空
     * @param node
     */
    public static void inOrderUnrecur(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||node!=null){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                System.out.print(node.value+" ");
                node = node.right;
            }
        }
    }

    /**
     * 广度优先遍历
     * @param node
     */
    public static void levelOrderTraversal(TreeNode node){
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            System.out.print(temp.value+" ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }

    /**
     * 深度优先遍历
     * @param node
     */
    public static void depthTraversal(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.value+" ");
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

}
```


## 两个栈实现一个队列

### 题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。


### 解决思路
使用stack1进队列，使用stack2出队列

### 代码实现
```java
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

```

两个队列实现栈:
```java
class MyStack {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!queue1.isEmpty()){
            queue1.offer(x);
        }else{
            queue2.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue1.isEmpty()){
            while(queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else{
            while(queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if(queue1.isEmpty()) {
            while(queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            int result = queue2.peek();
            queue1.offer(queue2.poll());
            return result;
        }else {
            while(queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            int result = queue1.peek();
            queue2.offer(queue1.poll());
            return result;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}

```

## 旋转数组的最小数字

### 题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

### 解决思路

二分法查找，注意边界

### 代码实现
```java
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int low = 0, high = array.length -1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(array[mid] > array[high]){
                low = mid +1;
            }else if(array[mid]>array[high]){
                high = high -1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }
}
/**
 * 二分查找的方法去做
 * 采用二分法解答这个问题，
 * mid = low + (high - low)/2
 * 需要考虑三种情况：
 * (1)array[mid] > array[high]:
 * 出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
 * low = mid + 1
 * (2)array[mid] == array[high]:
 * 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
 * 还是右边,这时只好一个一个试 ，
 * high = high - 1
 * (3)array[mid] < array[high]:
 * 出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
 * 边。因为右边必然都是递增的。
 * high = mid
 * 注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
 * 比如 array = [4,6]
 * array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
 * 如果high = mid - 1，就会产生错误， 因此high = mid
 * 但情形(1)中low = mid + 1就不会错误
 */
```

## 斐波那契数列

### 题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39


### 解决思路
尽量不要用递归，直接使用变量进行累加

### 代码实现

```java
public class Fibonacci {
    public int Fibonacci(int n) {
        int result = 0;
        int preOne = 0;
        int preTwo = 1;
        if(n==0){
            return preOne;
        }else if(n==1){
            return preTwo;
        }
        for(int i=2;i<=n;i++){
            result = preOne + preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return result;
    }
}
```


## 替换空格

### 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。


### 解决思路

采用递归的思想，从后往前推，最后一个台阶有两种，要么倒数第一个台阶走一步要么倒数第二个台阶走两步

### 代码实现
```java
public class JumpFloor {
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);

    }
}
```


## 矩形覆盖

### 题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

### 解决思路
被覆盖的目标矩形的形状： 2*n
每次新增加的一列
- 如果竖着放对应的情况与 target为 n-1 时相同；
- 如果横着放，对应的情况与 target 为 n-2 时相同。

### 代码实现
```java
public class RectCover {
    public int RectCover(int target) {
        // 被覆盖的目标矩形的形状： 2*n
        // 每次新增加的一列
        // （1）如果竖着放对应的情况与 target为 n-1 时相同；
        // （2）如果横着放，对应的情况与 target 为 n-2 时相同。
        if(target <= 2){
            return target;
        }else{
            return RectCover(target-1)+RectCover(target-2);
        }
    }
}
```


## 二进制中1的个数

### 题目描述

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。


### 解决思路
从n的2进制形式的最右边开始判断是不是1,该解法如果输入时负数会陷入死循环，因为负数右移时，在最高位补得是1
用1（1自身左移运算，其实后来就不是1了）和n的每位进行位与，来判断1的个数

### 代码实现
```java
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n&flag)!=0){
                count ++;
            }
            flag = flag<<1;
        }
        return count;
    }
}
```

## 数值的整数次方

### 题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0

### 解决思路
思路：把指数偶数的一分为2，奇数的乘本身再一分为2

### 代码实现
```java
public class Power {
    private double power(double base, int exponent) {
        if(exponent == 1){
            return base;
        }
        // 偶数
        if((exponent&1)==0){
            int temp = (int)power(base, exponent>>1);
            return temp*temp;
        }else{
            int temp = (int)power(base, (exponent-1)>>1);
            return temp*temp*base;
        }
    }
    public double Power(double base, int exp) {
        if (base == 0) {
            if (exp > 0){
                return 0;
            }
            else if (exp == 0){
                return 0;
            }
            else {
                throw new RuntimeException();
            }
        } else {
            if (exp > 0){
                return power(base, exp);
            }
            else if (exp == 0){
                return 1;
            }
            else{
                return 1 / power(base, -exp);
            }
        }
    }
}
/**
 * 思路：把指数偶数的一分为2，奇数的乘本身再一分为2
 */
```

## 调整数组顺序，使得奇数位于偶数前

### 题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。


### 解决思路
/**
 * 1.要想保证原有次序，则只能顺次移动或相邻交换。
 * 2.i从左向右遍历，找到第一个偶数。
 * 3.j从i+1开始向后找，直到找到第一个奇数。
 * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
 * 5.终止条件：j向后遍历查找失敗。
 */

### 代码实现
```java
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int i = 0, j = 1;
        while (i < array.length) {
            //i从左向右遍历，找到第一个偶数
            while (i < array.length && array[i] % 2 != 0) {
                i++;
            }
            j = i + 1;
            //j从i+1开始向后找，直到找到第一个奇数
            while (j < array.length && array[j] % 2 == 0) {
                j++;
            }
            if (j < array.length) {
                int temp = array[j];
                for (int j2 = j - 1; j2 >= i; j2--) {
                    array[j2 + 1] = array[j2];
                }
                array[i] = temp;
                i++;
            } else {
                break;
            }
        }
    }
}
```


## 链表中倒数第k个节点

### 题目描述
输入一个链表，输出该链表中倒数第k个结点。


### 解决思路
实现两个指针，一个先走k步，然后两个同时移动，直到第二个指针走到链表尾部

### 代码实现
```java
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
```

## 反转链表

### 题目描述
输入一个链表，反转链表后，输出新链表的表头。


### 解决思路
定义一个节点，前一个节点，当前节点，根据

### 代码实现
```java
public class LinkNodeProblem {
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
}
```


## 合并两个排序的列表

### 题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。


### 解决思路
建立一个新的链表，从头开始遍历，然后合并

### 代码实现
```java
public class MergeTwoSortList{
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
```

## 树的子结构

### 题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

### 解决思路
采用递归的思想，当前子树，左子树，右子树是不是A的子树

### 代码实现
```java
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1==null||root2==null){
            return false;
        }
        return isSubTree(root1, root2)||isSubTree(root1.left,root2)||isSubTree(root1.right, root2);
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2){
        if(root2==null){
            // 这个时候返回true
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root2.value==root1.value){
            return isSubTree(root1.left, root2.left)&&isSubTree(root1.right, root2.right);
        }else{
            return false;
        }
    }
}
```

## 二叉树的镜像

### 题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。

### 解决思路
一棵树交换左右节点，然后递归继续操作

### 代码实现
```java
public class MirrorTree {
    public void Mirror(TreeNode root) {
        TreeNode temp;
        if(root!=null){
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left!=null){
                Mirror(root.left);
            }
            if(root.right!=null){
                Mirror(root.right);
            }
        }
    }
}
```


## 顺时针打印矩阵

### 题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

### 解决思路
注意边界的判断

### 代码实现
```java
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int l=0, r=matrix[0].length-1,top=0,bottom=matrix.length-1;
        while(l<=r&&top<=bottom){
            for(int i=l;i<=r;i++){
                result.add(matrix[top][i]);
            }
            for(int i=top+1;i<=bottom;i++){
                result.add(matrix[i][r]);
            }
            if(top!=bottom){
                for(int i=r-1;i>=l;i--){
                    result.add(matrix[bottom][i]);
                }
            }
            if(l!=r){
                for(int i=bottom-1;i>top;i--){
                    result.add(matrix[i][l]);
                }
            }
            l++;r--;top++;bottom--;
        }
        return result;
    }
}
```

## 包含min函数的栈

### 题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

### 解决思路
使用两个栈，一个存储正常的数据，另一个存储最小值，如果当前节点小于temp,那么放入最小栈

### 代码实现
```java
public class StackImpl {

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
```

## 栈的压入、弹出序列

### 题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

### 解决思路
如果相等那么pushA和popA分别弹出元素，并且数组下标往后移动，否则pushA元素入栈，popA下标不动

### 代码实现
```java
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty()&&stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
```

## 从上往下打印二叉树

### 题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

### 解决思路
采用队列存储，每次弹出一个节点的同时，将他的左右子节点放入队列

### 代码实现
```java
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> link = new LinkedList<>();
        if(root==null){
            return list;
        }
        link.add(root);
        while(!link.isEmpty()){
            TreeNode temp = link.remove();
            list.add(temp.value);
            if(temp.left!=null){
                link.add(temp.left);
            }
            if(temp.right!=null){
                link.add(temp.right);
            }
        }
        return list;
    }
}
```

## 二叉搜索树的后序遍历序列

### 题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

### 解决思路
对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。

### 代码实现
```java
public class VerifySequenceOfBST {
    public boolean VerifySequenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return IsTreeBST(sequence, 0, sequence.length-1);
    }
    public boolean IsTreeBST(int [] sequence,int start,int end){
        if(end <= start){
            return true;
        }
        int i = start;
        for(;i<end;i++){
            if(sequence[i]>sequence[end]){
                break;
            }
        }
        for(int j=i;j<end;j++){
            if(sequence[j]<sequence[end]){
                return false;
            }
        }
        return IsTreeBST(sequence, start, i-1)&&IsTreeBST(sequence, i, end-1);
    }
}
```

## 二叉树中和为某一值的路径

### 题目描述
输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

### 解决思路


### 代码实现
```java
public class FindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }
}
```

## 复杂链表的复制

### 题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

### 解决思路
解题思路：
1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
3、拆分链表，将链表拆分为原链表和复制后的链表

### 代码实现
```java
public class RandomListNodeClone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;
    RandomListNode(int label) {
        this.label = label;
    }
}
```

## 字符串的排列

### 题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

### 解决思路
采用递归的思路，先把当前的和第i个交换，然后后面的字符串采用同样的方式排列，

### 代码实现
```java
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() < 1) {
            return res;
        }
        TreeSet<String> set = new TreeSet<>();
        char[] chs = str.toCharArray();
        change(chs, 0, set);
        res.addAll(set);
        return res;
    }

    public void change(char[] chs, int start, TreeSet<String> set) {
        if (start == chs.length - 1) {
            set.add(String.valueOf(chs));
        }
        for (int i = start; i < chs.length; i++) {
            swap(chs, start, i);
            change(chs, start + 1, set);
            swap(chs, start, i);
        }
    }

    public void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
```

## 数组中出现超过一半的数字

### 题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

### 解决思路
如果当前值等于前一个结果值那么count++,否则count--,最后看下count的数目是不是超过result

### 代码实现
```java
public class MoreThanHalfNum {
    public int MoreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = array[i];
                count = 1;
            }
        }
        count = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==result){
                count++;
            }
        }
        if(count*2>array.length){
            return result;
        }
        return 0;
    }
}
```

## 最小的k个数字

### 题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

### 解决思路
采用最大堆，从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆,最终堆里的就是最小的K个数
采用快速排序，找到前k个元素为止

### 代码实现
```java
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbersOne(int[] array, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || k <= 0 || k > array.length) {
            return list;
        }
        int start = 0;
        int end = array.length - 1;
        int index = Partion(array, start, end);
        while (index != (k - 1)) {
            if (index > (k - 1)) {
                index = Partion(array, 0, index - 1);
            } else {
                index = Partion(array, index + 1, k - 1 - index);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(array[i]);
        }
        return list;
    }

    private int Partion(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int pivot = array[i];
        while (i < j) {
            while (i < j && pivot < array[j]) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                array[j] = pivot;
                i++;
            }
            while (i < j && pivot > array[i]) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                array[i] = pivot;
                j--;
            }
        }
        return i;
    }


    public ArrayList<Integer> GetLeastNumbersTwo(int[] array, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<>();
        if (array == null || k <= 0 || k > array.length) {
            return leastNumbers;
        }
        //初始化为最大堆
        for (int i = k / 2-1; i >= 0; i--) {
            adjustHeap(array, i, k);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆,最终堆里的就是最小的K个数
        for (int i = k; i < array.length; i++) {
            if (array[i] < array[0]) {
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                adjustHeap(array, 0, k);
            }
        }
        for (int i = 0; i < k; i++) {
            leastNumbers.add(array[i]);
        }
        return leastNumbers;
    }

    private void adjustHeap(int[] array, int parentIndex, int end) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < end) {
            if (childIndex + 1 < end && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (array[childIndex] < temp) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void main(String[] args) {
        int[] array = {7, 9, 3, 6, 1, 11, 2, 4, 5, 8, 10};
        int[] array2 = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        ArrayList<Integer> result = new ArrayList<>();
//        result = getLeastNumbers.GetLeastNumbersOne(array, k);
//        System.out.println(result.toString());
        result = getLeastNumbers.GetLeastNumbersTwo(array2, k);
        System.out.println(result.toString());
    }
}
```

## 连续子数组的最大和

### 题目描述
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)

### 解决思路
最大字段和，如果加上当前的数字比0小，那么当前数字作为sum，否则继续累加

### 代码实现
```java
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum < 0) {
                sum = array[i];
            }else{
                sum += array[i];
            }
            max = sum > max ? sum : max;
        }
        return max;
    }
}
```

## 整数中1出现的次数

### 题目描述
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。

### 解决思路
1. 采用传统的取数字的运算
2. 采用字符串操作，对字符中的1进行遍历

### 代码实现
```java
public class NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp % 10 == 1) {
                    count++;
                }
                temp = temp / 10;
            }
        }
        return count;
    }

    public static int NumberOf1Between1AndN_Solution1(int n) {
        int count = 0;
        while(n>0){
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='1'){
                    count++;
                }
            }
        }
        return count;
    }

    public static int NumberOf1Between1AndN_Solution2(int n){
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=100;i<=n;i++){
            sb.append(i);
        }
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN.NumberOf1Between1AndN_Solution(1));
    }
}
```

## 把数组排成最小的数

### 题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

### 解决思路
打印最小的数字，调用集合的sort方法，输入两个数字，前面的+后面的要比后面的+前面的小

### 代码实现
```java
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> list = new ArrayList<>();
        int len = numbers.length;
        for(int i=0;i<len;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = ""+str1+str2;
                String s2 = ""+str2+str1;
                return s1.compareTo(s2);
            }
        });
        for(int j : list){
            sb.append(j);
        }
        return sb.toString();
    }
}
```

## 丑数

### 题目描述
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

### 解决思路
/**
 * 说下思路，如果p是丑数，那么p=2^x * 3^y * 5^z
 * 那么只要赋予x,y,z不同的值就能得到不同的丑数。
 * 如果要顺序找出丑数，要知道下面几个特点。
 * 对于任何丑数p：
 * （一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
 * （二）如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q
 * 现在说说算法思想：
 * 由于1是最小的丑数，那么从1开始，把2*1，3*1，5*1，进行比较，得出最小的就是1
 * 的下一个丑数，也就是2*1，
 * 这个时候，多了一个丑数‘2’，也就又多了3个可以比较的丑数，2*2，3*2，5*2，
 * 这个时候就把之前‘1’生成的丑数和‘2’生成的丑数加进来也就是
 * (3*1,5*1,2*2，3*2，5*2)进行比较，找出最小的。。。。如此循环下去就会发现，
 * 每次选进来一个丑数，该丑数又会生成3个新的丑数进行比较。
 * 上面的暴力方法也应该能解决，但是如果在面试官用这种方法，估计面试官只会摇头吧
 * 。下面说一个O（n）的算法。
 * 在上面的特中，既然有p<q, 那么2*p<2*q，那么
 * “我”在前面比你小的数都没被选上，你后面生成新的丑数一定比“我”大吧，那么你乘2
 * 生成的丑数一定比我乘2的大吧，那么在我选上之后你才有机会选上。
 * 其实每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
 * 数。也就是比较(2*x , 3*y, 5*z) ，x>=y>=z的，
 * 重点说说下面代码中p的作用：int p[] = new int[] { 0, 0, 0 }; p[0]表示最小用于
 * 乘2比较数在数组a中的【位置】。
 */
 
### 代码实现
```java
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int n) {
        if(n<=0){
            return 0;
        }
        int two = 0;
        int three = 0;
        int five = 0;
        int[] a = new int[n];
        a[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = getMin(a[two] * 2, a[three] * 3, a[five] * 5);
            if (a[i] >= a[two]*2) {
                two++;
            }
            if (a[i] >= a[three]*3) {
                three++;
            }
            if (a[i] >= a[five]*5) {
                five++;
            }
        }
        return a[n-1];
    }
    public int getMin(int i, int j, int k){
        int temp = Math.min(i, j);
        return Math.min(temp ,k);
    }
}
```

## 第一个只出现一次的字符

### 题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.

### 解决思路
采用map存储字符，然后遍历数组中的元素，获取在map中的数量，如果数量为1直接取出

### 代码实现
```java
public class FindFirstCharacter {
    HashMap<Character,Integer> map=new HashMap<>();
    String s = new String("");

    //Insert one char from string stream
    public void Insert(char ch)
    {
        s+=ch;
        if(!map.containsKey(ch)){
            map.put(ch, 1);
        }else{
            map.put(ch, map.get(ch)+1);
        }
    }
    //return the first appearance once char in current string stream
    public char FirstAppearingOnce()
    {
        char[] cs = s.toCharArray();
        for(char c:cs){
            if(map.get(c)==1){
                return c;
            }
        }
        return '#';
    }
}
```

## 数组中的逆序对

### 题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字

数据范围：

	对于%50的数据,size<=10^4

	对于%75的数据,size<=10^5

	对于%100的数据,size<=2*10^5

### 解决思路
采用归并排序的思想，如果超过的部分用min-i+1表示

### 代码实现
```java
public class InversePairs {
    private int count;

    public int InversePairs(int[] array) {
        count = 0;
        if (array != null) {
            mergeSort(array, 0, array.length - 1);
        }
        return count%1000000007;
    }

    public void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    public void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                count += mid - i + 1;
                if(count > 1000000007){
                    count = count%1000000007;
                }
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }
        for (k = 0; k < temp.length; k++) {
            a[start + k] = temp[k];
        }
    }
}
```

## 两个链表的第一个公共节点

### 题目描述
输入两个链表，找出它们的第一个公共结点。

### 解决思路
获取链表的长度，让长的链表先走k步，然后两个链表同时走，直到遇到相同的节点为止

### 代码实现
```java
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
```

## 数字在排序数组中出现的次数

### 题目描述
统计一个数字在排序数组中出现的次数。

### 解决思路
获取头部和尾部节点，如果都不为-1，做差+1即为结果

### 代码实现
```java
public class GetNumberOfK {

    public int GetNumberOfK(int[] array, int k){
        if(array==null||array.length==0){
            return 0;
        }
        int first = getFirstK(array, k, 0, array.length-1);
        int last = getLastK(array, k, 0, array.length-1);
        if(first==-1||last==-1){
            return 0;
        }else{
            return last-first+1;
        }
    }

    public int getFirstK(int[] array, int k, int start, int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(k<array[mid]){
                end = mid -1;
            }else if(k>array[mid]){
                start = mid +1;
            }else{
                if(mid>0&&array[mid-1]!=k||mid==0){
                    return mid;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public int getLastK(int[] array, int k, int start, int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(k<array[mid]){
                end = mid-1;
            }else if(k>array[mid]){
                start = mid+1;
            }else{
                if(mid<array.length-1&&array[mid+1]!=k||mid==array.length-1){
                    return mid;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}
```

## 二叉树的深度

### 题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

### 解决思路
通过递归的思想，分别求左边和右边的树深度，然后返回结果

### 代码实现
```java
public class TreeDepth {
   public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }
}
```

## 平衡二叉树

### 题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。

### 解决思路

### 代码实现
```java
public class Solution {
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left-right)>1){
            isBalanced = false;
        }
        return left>right?left+1:right+1;
    }
}
```

## 数组中只出现一次的数字

### 题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

### 解决思路

### 代码实现
```java
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for (int i = 0; i < length; i++) {
            bitResult ^= array[i];
        }
        int index = findFirstOne(bitResult);
        for (int i = 0; i < length; i++) {
            if (isBitOne(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 找到第一个1的index，即为异或结果不同的
     *
     * @param bitResult
     * @return
     */
    private int findFirstOne(int bitResult) {
        int index = 0;
        while ((bitResult & 1) == 0 && index < 32) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    /**
     * 看当前的数字是否与该位相同
     *
     * @param target
     * @param index
     * @return
     */
    private boolean isBitOne(int target, int index) {
        return ((target >> index) & 1) == 1;
    }
}
```

## 和为S的连续正数序列

### 题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序


### 解决思路
采用滑动窗口的方法，将窗口范围不断扩大，把所有的数字加入结果集

### 代码实现
```java
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1; int phigh = 2;
        while(plow < phigh){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            if(cur == sum){
                //相等，那么就将窗口范围的所有数添加进结果集
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
            }else if(cur < sum){
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
                phigh ++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow ++;
            }
        }
        return result;
    }
}

```

## 和为S的两个数字

### 题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
对应每个测试案例，输出两个数，小的先输出。

### 解决思路
从后往前查找，每次计算和并与sum进行比较
### 代码实现
```java
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array == null || array.length<2){
            return list;
        }
        int i=0,j =array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }
        }
        return list;
    }
}
```

## 左旋字符串

### 题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！


### 解决思路
利用字符串截取的方法，但是要注意长度的控制

### 代码实现
```java
public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        str += str;
        n = n % length;
        return str.substring(n, length + n);
    }
}
```


## 旋转单词顺序列

### 题目描述
Fish每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

### 解决思路
按照空格分割没然后字符串反转

### 代码实现
```java
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] array = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i=array.length;i>0;i--){
            sb.append(array[i-1]);
            if(i>1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
```


## 扑克牌顺子

### 题目描述
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。

### 解决思路
记录最大值和最小值的区间范围

### 代码实现
```java
public class IsContinuousPai {
    /**
     * max 记录 最大值
     * min 记录  最小值
     * min ,max 都不记0
     * 满足条件
     * 1 max - min <5
     * 2 除0外没有重复的数字(牌)
     * 3 数组长度 为5
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        // 用于记录重复的数字
        int[] d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (d[numbers[i]] > 1) {
                return false;
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        if (max - min < 5) {
            return true;
        }
        return false;
    }
}
```


## 圆圈中最后剩下的数

### 题目描述
每年六一儿童节,都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

### 解决思路
/**
 * 把n个人的编号改为0~n-1，然后对删除的过程进行分析。
 * 第一个删除的数字是(m-1)%n，几位k，则剩余的编号为(0,1,...,k-1,k+1,...,n-1)，下次开始删除时，顺序为(k+1,...,n-1,0,1,...k-1)。
 * 用f(n,m)表示从(0~n-1)开始删除后的最终结果。
 * 用q(n-1,m)表示从(k+1,...,n-1,0,1,...k-1)开始删除后的最终结果。
 * 则f(n,m)=q(n-1,m)。
 *
 * 下面把(k+1,...,n-1,0,1,...k-1)转换为(0~n-2)的形式，即
 * k+1对应0
 * k+2对于1
 * ...
 * k-1对应n-2
 * 转化函数设为p(x)=(x-k-1)%n, p(x)的你函数为p^(x)=(x+k+1)%n。
 * 则f(n,m)=q(n-1,m)=p^(f(n-1,m))=(f(n-1,m)+k+1)%n，又因为k=(m-1)%n。
 * f(n,m)=(f(n-1,m)+m)%n;
 *
 * 最终的递推关系式为
 * f(1,m) = 0;                        (n=1)
 * f(n,m)=(f(n-1,m)+m)%n; （n>1）
 */
 
### 代码实现
```java
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if(n<=0||m<=0){
            return -1;
        }
        int last = 0;
        for(int i=2;i<=n; i++){
            last = (last+m)%i;
        }
        return last;
    }
}
```


## 求1+2+3+...+n

### 题目描述
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

### 解决思路
采用递归的方法

### 代码实现
```java
public class Sum {
    public int Sum(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum(n-1))>0);
        return sum;
    }
}
```


## 不用加减乘除做加法

### 题目描述
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

### 解决思路
按照移位运算进行累加

### 代码实现
```java
public class Add {
    public int Add(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }
}
```

## 把字符串转换成整数

### 题目描述
将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。

### 解决思路
注意正负号，然后通过字符运算得到结果

### 代码实现
```java
public class String2Integer {
    public int StrToInt(String str) {
        if (str.equals("") || str.length() == 0) {
            return 0;
        }
        char[] a = str.toCharArray();
        int flag = 0;
        if (a[0] == '-') {
            flag = 1;
        }
        int sum = 0;
        for (int i = flag; i < a.length; i++) {
            if (a[i] == '+') {
                continue;
            }
            if (a[i] < 48 || a[i] > 57) {
                return 0;
            }
            sum = sum * 10 + (a[i] - 48);
        }
        return flag == 0 ? sum : sum * -1;
    }
}
```


## 数组中重复的数字

### 题目描述
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

### 解决思路
直接用数组做，尽量不使用map

### 代码实现
```java
public class FIndDuplicateNumber {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length==0){
            duplication[0] = -1;
            return false;
        }
        boolean[] k = new boolean[numbers.length];
        for(int i=0;i<numbers.length;i++){
            if(k[numbers[i]]==true){
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }
}
```


## 构建乘积数组

### 题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

### 解决思路
先求下三角，然后求正三角

### 代码实现
```java
public class CalculateMultiply {
    public int[] multiply(int[] A) {
        if(A==null||A.length==0){
            return A;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        for(int i=1;i<A.length;i++){
            B[i] = B[i-1]*A[i];
        }
        int temp = 1;
        for(int j=A.length-2;j>=0;j--){
            temp = temp * B[j+1];
            B[j] = B[j] * temp;
        }
        return B;
    }
}
```

## 正则表达式匹配

### 题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

### 解决思路

### 代码实现
```java
public class MatchString {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, 0, pattern, 0);
    }

    private boolean match(char[] str, int i, char[] pattern, int j) {
        if (j == pattern.length) {
            return str.length == i;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (j < pattern.length - 1 && pattern[j + 1] == '*') {
            if (i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                //模式后移2，视为x*匹配0个字符
                //视为模式匹配1个字符
                return match(str, i, pattern, j + 2) && match(str, i + 1, pattern, j);
            } else {
                //*匹配1个，再匹配str中的下一个
                return match(str, i + 1, pattern, j + 1);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if (i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
            return match(str, i + 1, pattern, j + 1);
        }
        return false;
    }
}
```

## 表示数值的字符串

### 题目描述
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

### 解决思路

### 代码实现
```java
public class StringIsNumeric {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
}
```

## 字符流中第一个不重复的字符

### 题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

### 解决思路

### 代码实现
```java
public class FindFirstCharacter {
    HashMap<Character,Integer> map=new HashMap<>();
    String s = new String("");

    //Insert one char from string stream
    public void Insert(char ch)
    {
        s+=ch;
        if(!map.containsKey(ch)){
            map.put(ch, 1);
        }else{
            map.put(ch, map.get(ch)+1);
        }
    }
    //return the first appearance once char in current string stream
    public char FirstAppearingOnce()
    {
        char[] cs = s.toCharArray();
        for(char c:cs){
            if(map.get(c)==1){
                return c;
            }
        }
        return '#';
    }
}
```

## 链表中环的入口节点

### 题目描述
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

### 解决思路
采用快慢指针，快指针先走两步，慢指针走一步，直到两个指针相遇后，慢指针继续走，快指针从头开始走，直到两个节点相遇

### 代码实现
```java
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
```

## 删除链表中重复的节点

### 题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

### 解决思路
创建一个新的节点，如果当前节点重复，继续遍历，直到一个不同的节点

### 代码实现
```java
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
```

## 二叉树的下一个节点

### 题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

### 解决思路
有右子树找到右子树的最左侧节点
没有右子树找到第一个当前节点的父节点

### 代码实现
```java
public class GetNextListNode {
    public TreeLinkNode GetNext(TreeLinkNode node)
    {
        if(node == null){
            return null;
        }
        //如果有右子树，找到右子树的最左节点
        if(node.right!=null){
            node = node.right;
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }
        //没有右子树，找到第一个当前节点是父节点左孩子的节点
        while(node.next!=null){
            if(node.next.left==node){
                return node.next;
            }
            node = node.next;
        }
        //退到根节点也没有找到，返回null
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

```

## 对称的二叉树

### 题目描述
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

### 解决思路
采用递归的思想，判断左侧值是不是等于右侧值，并且子树是不是对称的

### 代码实现
```java
public class IsSymmetricalTree {
    boolean isSymmetrical(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.value==right.value&&isSymmetrical(left.left,right.right)&&isSymmetrical(left.right, right.left);
    }
}
```

## 按之字形打印二叉树

### 题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

### 解决思路
判断当前层是奇数层还是偶数层，分别采用两个栈存储元素的节点，一个先存储左值右值，另一个存储右值左值

### 代码实现
```java
public class PrintZTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while(!s1.isEmpty()||!s2.isEmpty()){
            if(layer%2!=0){
                ArrayList<Integer> temp = new ArrayList<>();
                while(!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    if(node!=null){
                        temp.add(node.value);
                        System.out.println(node.value+" ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if(!temp.isEmpty()){
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                while(!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    if(node!=null){
                        temp.add(node.value);
                        System.out.println(node.value+" ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if(!temp.isEmpty()){
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }
}
```

## 把二叉树打印成多行

### 题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

### 解决思路
按照先左后右的思路将节点放入队列

### 代码实现
```java
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(pRoot==null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            list = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                list.add(temp.val);
            }
            res.add(list);
        }
        return res;
    }
    
}
```

## 序列化二叉树

### 题目描述
请实现两个函数，分别用来序列化和反序列化二叉树

二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
### 解决思路

### 代码实现
```java
public class SerializeTree {
    private   int  index = -1;
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.value+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        TreeNode node = null;
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strArray = str.split(",");
        if(!strArray[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strArray[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
```

## 二叉搜索树的第k个节点

### 题目描述
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。

### 解决思路
思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
所以，按照中序遍历顺序找到第k个结点就是结果。
    
### 代码实现
```java
public class TreeNodeKthNode {
    private int index = 0; //计数器
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot!=null){
            TreeNode node = KthNode(pRoot.left, k);
            if(node!=null){
                return node;
            }
            index ++;
            if(index==k){
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if(node!=null){
                return node;
            }
        }
        return null;
    }
}
```

## 滑动窗口的最大值

### 题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

### 解决思路
 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
 1.判断当前最大值是否过期
 2.新增加的值从队尾开始比较，把所有比他小的值丢掉

### 代码实现
```java
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0){
            return res;
        }
        int begin;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<num.length;i++){
            //begin是用于保存当前窗口的第一个值在原始数组中的【下标】
            begin = i-size+1;
            if(queue.isEmpty()){
                queue.add(i);
            }else if(begin>queue.peekFirst()){
                queue.pollFirst();
            }
            while((!queue.isEmpty())&&num[queue.peekLast()]<=num[i]){
                queue.pollLast();
            }
            queue.add(i);
            if(begin>=0){
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;
    }
}
```

## 排序

### 题目实现

```java
public class Sort {
    public static void main(String[] args) {
        System.out.println("sort:");
        int[] a = new int[]{1, 8, 2, 9, 6, 7, 5, 0, 4, 3};
        // quickSort(a, 0, a.length - 1);
        // mergeSort(a, 0, a.length - 1);
        // heapSort(a);
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pivot = a[start];
            int i = start;
            int j = end;
            while (i < j) {
                while (i < j && pivot < a[j]) {
                    j--;
                }
                if (i < j) {
                    a[i] = a[j];
                    a[j] = pivot;
                    i++;
                }
                while (i < j && pivot > a[i]) {
                    i++;
                }
                if (i < j) {
                    a[j] = a[i];
                    a[i] = pivot;
                    j--;
                }
            }
            quickSort(a, start, i - 1);
            quickSort(a, i + 1, end);
        }
    }

    private static void mergeSort(int[] a, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(a, begin, mid);
            mergeSort(a, mid + 1, end);
            merge(a, begin, mid, end);
        }
    }

    private static void merge(int[] a, int begin, int mid, int end) {
        int[] temp = new int[a.length];
        int i = begin;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = a[i++];
        }
        while (j <= end) {
            temp[t++] = a[j++];
        }
        t = 0;
        while (begin <= end) {
            a[begin++] = temp[t++];
        }
    }

    private static void adjustHeap(int[] a, int parentIndex, int length) {
        int temp = a[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && a[childIndex + 1] > a[childIndex]) {
                childIndex++;
            }
            if (temp >= a[childIndex]) {
                break;
            }
            a[parentIndex] = a[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        a[parentIndex] = temp;
    }

    private static void heapSort(int[] a) {
        for (int i = (a.length - 2) / 2; i >= 0; i--) {
            adjustHeap(a, i, a.length);
        }
        System.out.println(Arrays.toString(a));
        for (int i = a.length - 1; i >= 0; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            adjustHeap(a, 0, i);
        }
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] a) {
        int n = a.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            temp = a[i];
            for (; j >= 0 && a[j] > temp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }

    public static void selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int temp = i;
            int value = a[i];
            for (int j = i + 1; j < n; j++) {
                if (a[j] < value) {
                    temp = j;
                    value = a[j];
                }
            }
            a[temp] = a[i];
            a[i] = value;
        }
    }


    public static void shellSort(int[] a) {
        int b = a.length;
        int temp = 0;
        while (true) {
            b = b / 2;
            for (int i = 0; i < b; i++) {
                for (int j = i + b; i < a.length; i += b) {
                    int k = j - b;
                    temp = a[j];
                    for (; k >= 0 && temp < a[k]; k -= b) {
                        a[k + b] = a[k];
                    }
                    a[k + b] = temp;
                }
            }
            if (b == 1) {
                break;
            }
        }
    }

}
```