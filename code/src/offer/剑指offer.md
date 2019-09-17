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

## 旋转数组的最小数字

### 题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

### 解决思路

### 代码实现


## 替换空格

### 题目描述

### 解决思路

### 代码实现


## 替换空格

### 题目描述

### 解决思路

### 代码实现


## 替换空格

### 题目描述

### 解决思路

### 代码实现


## 替换空格

### 题目描述

### 解决思路

### 代码实现