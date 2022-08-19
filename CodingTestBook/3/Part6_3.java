/*
 * 8/19 정렬 문제 - p183
 * N개로 구성된 두 배열 A와 B가 있다.
 * 총 K번 A와 B의 요소의 값을 바꿔치기 할 수 있다고 할 때
 * 배열 A의 모든 원소 값이 최대가 되도록 하는 최댓값을 출력하라
 */

import java.util.*;


public class Part6_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        int sum_max = 0;

        Integer[] array_A = new Integer[N];
        Integer[] array_B = new Integer[N];

        for(int i=0; i<N; i++){
            array_A[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++){
            array_B[i] = sc.nextInt();
        }

        Arrays.sort(array_A);
        Arrays.sort(array_B, Comparator.reverseOrder());

        for(int i=0; i<K; i++){
            if(array_A[i] > array_B[i]) break;
            Integer temp = array_A[i];
            array_A[i] = array_B[i];
            array_B[i] = temp;
        }


        for(int i=0; i<N; i++){
            sum_max += array_A[i];
        }
        
        System.out.println(sum_max);
       
 }
}

/*
 * Array.sort를 사용할 때 임의의 클래스를 사용한다면 Overried를 통해 어떤 값으로 정렬할 지 정의할 것
 */