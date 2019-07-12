package offer;

/**
 * @author: guangxush
 * @create: 2019/07/12
 * 最大子段和
 */
public class FindGreatestSubArray {
    public int findGreatestSubArray(int[] array){
        if(array == null){
            return 0;
        }
        int currentSum = 0, greatSum = 0;
        for(int i=0;i<array.length;i++){
            if(currentSum<0){
                currentSum = array[i];
            }else{
                currentSum = currentSum+array[i];
            }
            if(currentSum>greatSum){
                greatSum = currentSum;
            }
        }
        return greatSum;
    }
}
