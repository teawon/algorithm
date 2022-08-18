/*
 *  [다시 풀어보기] - 자바의 입출력 / 함수 분리에 초점둘 것
 * 8/18 DFS/BFS문제
 * N * M의 얼음틀이 에서 구멍은 0, 칸막이는 1로 표시한다.
 * 구멍이 붙어있는 경우 서로 연결하고 있다고 간주할 때 임의의 얼음 틀 모양에서 생성되는 아이스크림의 수를 출력하시오
 *
 */

import java.util.*;


public class Part5_1 {


public static int N,M;
public static int[][] ice_array = new int[999][999];

    public static boolean dfs(int x, int y) {
        if(x < 0 || x >= N || y<0 || y >= M) return false;

        if(ice_array[x][y] == 1) return false;
    
         ice_array[x][y] = 1;
         dfs(x-1,y);
         dfs(x+1,y);
         dfs(x,y+1);
         dfs(x,y-1);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
     N = sc.nextInt();
     M = sc.nextInt();
     sc.nextLine(); // \n 버퍼 지우기
     int ct = 0;
    

    for(int i=0; i<N; i++){  //값 받아옴
        String str = sc.nextLine();

        for(int j=0; j<M; j++){
            ice_array[i][j] = str.charAt(j) - '0';
        }
    }
    
    
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            if(dfs(i,j)) 
                ct++;
     }
    }

    System.out.println(ct);
     
 }
}

/*
 * 유형이 익숙하지 않아 답을 많이 참고하였다. 향후 다시 풀어보기
 * 문제 자체보다 입/출력과 관련된 오류에 많이 부딫혔다.
 * 
 * 1. nextLine으로 꼭 버퍼를 지울 것 
 * 2. 전체 문자열을 받아 하나하나 파싱하여 배열에 넣기. 각 줄마다 받으므로 nextLine()함수를 사용할 것
 * 3. 함수를 분리하면 결국 전역변수로 선언해야 함.  초기에는 public static int[][] array = new int[N][M]를 사용했지만 초기화 되지 않는 값을 넣어서 안됨
 * 
 */