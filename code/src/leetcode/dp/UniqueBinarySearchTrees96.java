package leetcode.dp;

/**
 * @author: guangxush
 * @create: 2020/03/23
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 解题思路：卡特兰数，1的时候1种；1，2的时候2种；123的时候5种
 * 就跟斐波那契数列一样，我们把 n = 0 时赋为1，因为空树也算一种二叉搜索树，那么 n = 1 时的情况可以看做是其左子树个数乘以右子树的个数，左右子树都是空树，所以1乘1还是1。
 * 那么 n = 2 时，由于1和2都可以为根，分别算出来，再把它们加起来即可。n = 2 的情况可由下面式子算出（这里的 dp[i] 表示当有i个数字能组成的 BST 的个数）：
 * dp[2] =  dp[0] * dp[1]　　　(1为根的情况，则左子树一定不存在，右子树可以有一个数字)
 * 　　　　+ dp[1] * dp[0]　　  (2为根的情况，则左子树可以有一个数字，右子树一定不存在)
 *
 * 同理可写出 n = 3 的计算方法：
 * dp[3] =  dp[0] * dp[2]　　 　(1为根的情况，则左子树一定不存在，右子树可以有两个数字)
 * 　　　　 + dp[1] * dp[1]　　  (2为根的情况，则左右子树都可以各有一个数字)
 *  　　　  + dp[2] * dp[0]　　  (3为根的情况，则左子树可以有两个数字，右子树一定不存在)
 *
 * BST，每个元素都做根节点，算出每个元素做根节点时有几种情况，然后每个节点的几种情况相加。
 * 每个元素有几种情况，根据bst的特性，就是中序便利是排序的。所以：
 * 以n＝3为例。新建一个int res[]= int[3+1](循环1，2，3，每个数字对应所再index，而不是1对应0index，2对应1 index...)
 * 1是根节点的时候，1的左子树是0个，右子树是2，3（两个）。所以是1是根节点的种类数是：res[0]乘以res[2]情况数。
 * 2是根节点的时候，2的左子树是1（1个），右子树是1（1个）。所以是2是根节点的种类数是：res[1]乘以res[1]情况数。
 * 3是根节点的时候，3的左子树是1，2（2个），右子树是（0个）。所以是2是根节点的种类数是：res[2]乘以res[0]情况数。
 */
public class UniqueBinarySearchTrees96 {
    public int numTrees(int n) {
        if(n==0||n==1){
            return 1;
        }
        int[] res = new int[n+1];
        res[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                res[i]+=res[j]*res[i-j-1];
            }
        }
        return res[n];
    }
}
