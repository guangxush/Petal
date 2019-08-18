package offer;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
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
