package offer;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2019/08/18
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
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
