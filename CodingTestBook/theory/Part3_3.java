/*
 *  * 6/30 그리드 문제 - p96
 * N x M 형태로 카드가 놓여있다. (행 * 열)  
 * 뽑고자하는 행을 선택 후 해당 행에서 가장 작은 값의 카드를 뽑는다고 가정했을 때
 * 가장 큰 수를 뽑아야 한다. 뽑힌 가장 큰 수의 값은?
 * 
 */

import java.util.*;

public class Part3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] rowArr = new int[M]; //특정 행을 골랐을 때 해당 행의 카드 값
        int[] colMin = new int[N]; //특정 행들 중 가장 작은 값들의 모임

        for(int r =0; r< N; r++){
            for(int c=0; c<M; c++ ){
                rowArr[c]=sc.nextInt();
            }
            Arrays.sort(rowArr);
            colMin[r] = rowArr[0];

        }
        Arrays.sort(colMin);

        System.out.println(colMin[N-1]);




    }
}
