/*
 * 8/25 최단경로 문제
 * 회사의 개수 N과 경로의 개수 M이 첫번째 줄에 주어진다
 * 이후 각 경로에 대한 정보가 2 ~ M+1번째 줄에 주어지고(회사1, 회사2) [거리는 1 고정]
 * M+2번째 줄 부터 목적지 X , K가 주어질 때
 * 회사원이 X를 거쳐 K까지 갈 수 있는 최단경로를 출력하라. (갈수 없다면 -1을 출력)
 * 
 */

import java.util.*;


public class Part9_1 {
    
    public static int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] floyd = new int[N][N]; //플로이셜 워셜 알고리즘 사용을 위한 초기화 및 변수 선언
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i == j){
                    floyd[i][j] = 0;
                }
                else floyd[i][j] = INF;
            }
        }

        for(int i=0; i<M; i++){
            int startPoint = sc.nextInt()-1;
            int endPoint = sc.nextInt()-1;
            floyd[startPoint][endPoint] = 1;
            floyd[endPoint][startPoint] = 1;
        }

        int X = sc.nextInt() - 1;
        int K = sc.nextInt() - 1;

        for(int selected=0; selected<N; selected++){
            for(int start =0; start<N; start++){
                if(start == selected) continue;

                for(int end=0; end<N; end++){
                    floyd[start][end] = Math.min(floyd[start][end] , floyd[start][selected] + floyd[selected][end]);
                }
            }
        }
        
        int sumOfdistance = floyd[0][K] + floyd[K][X];

        if(sumOfdistance >= INF) System.out.println(-1);
        else System.out.println(sumOfdistance);
    }
}   


/*
 * 특정 지점을 경유하며 지나가기 때문에 플로이드 워셜 알고리즘을 사용하였다.
 * 다익스트라 알고리즘을 2번 사용해서 A->B , B->C로 가는 최단경로 값을 더하는 것도 생각해보았지만 배열을 그럼 두번 만들게 되는 것 같아 취소.
 * 
 * (실수했던 점) - 통로 자체가 양방향읋 의미하기 때문에 [a][b]  , [b][a] 모두 배열의 값을 넣어야 했다.
 * 무한 설정 값을 위해 1e9를 상수로 정의해서 사용하면 가독성이 올라간다. 
 */