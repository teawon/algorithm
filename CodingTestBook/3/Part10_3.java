/*
 * 8/26 위상정렬알고리즘
 * 들어야 하는 강의의 수 N이 주어진다.
 * 다음 N개의 줄에서는 각 강의의 강의시간, 먼저 들어야 하는 강의번호가 주어진다.
 * 각 강의 번호의 각 줄은 -1로 끝난다.
 * N개의 강의를 총 수강하는데 걸리는 최소 시간을 한 줄에 하나씩 출력하라
 */

import java.util.*;



public class Part10_3 {


       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] times = new int[N]; //특정 과목을 듣는데 걸리는 이수시간 (선이수 포함 최소시간)
        for(int i=0; i<N; i++){
            int time = sc.nextInt(); //현재 강의의 수강시간
            int maxTime = 0; //선이수 과목들을 전부 듣는데 걸리는 시간
            while(true){
                int curseNum = sc.nextInt()-1;
                if(curseNum == -2) break; 
                maxTime = Math.max(maxTime, times[curseNum]);
                
            }

            times[i] = time + maxTime;
            System.out.println(times[i]);
        }

        
        
    }
}   
/*
 * 문제에서 의도한 방향은 위상정렬알고리즘을 사용하는 것 같은데 위 풀이가 정답이 맞는지는 모르겠다.
 */