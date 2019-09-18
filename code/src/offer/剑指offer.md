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