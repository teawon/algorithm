/*
 * 8/21 다이나믹 문제 - p220
 * N개의 식량창고 개수가 주어진다.
 * 각 식량창고마다 가지고있는 식량의 수 K가 차례대로 N만큼 주어질 때
 * 식량창고에서 가져올 수 있는 최대 값을 출력하라 (단 식량 창고에서 두 개의 인접한 식량을 연속적으로 가져올 수는 없다.)
 * (3 <= N <= 100)  // (0 <= K <= 1000)
 */

import java.util.*;


public class Part8_2 {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] array = new int[N];
        int max_sum = 0;

        for(int i=0; i<N; i++){
            array[i] = sc.nextInt();
        }
        

        int curIndex = N-1;
        int selectedIndex = 0;
        while(curIndex >= 0){

            if(curIndex == 0) selectedIndex = curIndex;

            else if(array[curIndex] > array[curIndex-1]) selectedIndex = curIndex;

            else selectedIndex = curIndex-1;

            max_sum+=array[selectedIndex];
            curIndex = selectedIndex-2;
        }
    
        System.out.println(max_sum);

    }
}

/*
 * 다이나믹 프로그래밍을 사용하지 않고 수학적으로 접근해서 푼 방식
 * (다이나믹으로 접근할 지능이 안됐다. 2 3 4 5 6 에서는 2 4 6을 고르는데, 2 3 4 5 6 7 에서는 3 5 7 을 고르게되니까 
 * 특정 인덱스까지의 최대값이 계속 바뀔것(?) 이라고 생각했기 때문
 */