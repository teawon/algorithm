/*
 * 8/21 다이나믹 문제 - p220
 * N개의 식량창고 개수가 주어진다.
 * 각 식량창고마다 가지고있는 식량의 수 K가 차례대로 N만큼 주어질 때
 * 식량창고에서 가져올 수 있는 최대 값을 출력하라 (단 식량 창고에서 두 개의 인접한 식량을 연속적으로 가져올 수는 없다.)
 * (3 <= N <= 100)  // (0 <= K <= 1000)
 */

import java.util.*;


public class Part8_2_dynamic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] array = new int[N];
        int [] maxSum = new int[N];

        for(int i=0; i<N; i++){
            array[i] = sc.nextInt();
        }
        maxSum[0] = array[0];
        maxSum[1] = Math.max(array[0] , array[1]);

        for(int i=2; i<N; i++){
            maxSum[i] = Math.max(array[i] + maxSum[i-2], maxSum[i-1]);
        }
        System.out.println(maxSum[N-1]);
    }
}

/*
 * Dynamic Programing방식의 풀이.
 * 논리적으로 접근했을 때 새로운 값 + 이전 이전 값 vs 새로운값 버리고 이전값의 최대값 비교
 */