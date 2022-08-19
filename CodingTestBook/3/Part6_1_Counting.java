/*
 * 8/19 정렬 문제 - p178
 * N개의 숫자가 주어진다
 * 둘째 줄 부터 N+1번째 줄 까지 총 N개의 수가 차례대로 입력될 때 이 수를 내림차순으로 정렬하여 출력하시오
 */

import java.util.*;

public class Part6_1_Counting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] array = new int[100000];

        for(int i=0; i<N; i++){
            int number = sc.nextInt();
            array[number]++;
        }


        for(int i=array.length-1; i>=0; i--){
            for(int j=0; j<array[i]; j++){
                System.out.print(i + " ");
            }
        }
 }
}
