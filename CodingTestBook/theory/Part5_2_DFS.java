/*
 * 8/18 DFS/BFS문제
 * 1,1의 좌표에서 N.M 좌표에 이동하기 위한 최소 이동 칸을 출력하라. (시작칸과 마지막칸도 개수에 포함한다.)
 * 단 각 좌표에서 벽으로 막혀있는 곳은 0 , 그렇지 않다면 1로 각 좌표 값이 제시된다.
 */

import java.util.*;

public class Part5_2_DFS {

public static int N,M;
public static int[][] array = new int[999][999];
public static int min_count = 999999;

    public static void find_by_dfs(int x, int y, int count){

        if(x < 0 || x >= N || y<0 || y >= M) return;

        if(array[x][y] == 0) return;

        if(x==N-1 && y==M-1 && min_count > count+1) min_count = count+1; 

        array[x][y] = 0;
        find_by_dfs(x+1,y,count+1);
        find_by_dfs(x-1,y,count+1);
        find_by_dfs(x,y+1,count+1);
        find_by_dfs(x,y-1,count+1);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 버퍼 초기화

        for(int i=0; i<N; i++){
            String str = sc.nextLine();
            for(int j=0; j<M; j++){
                array[i][j] = str.charAt(j) - '0';
            }
        }

        
        find_by_dfs(0,0,0);

        System.out.println(min_count);

        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");
        // 메모리 사용량 6417296 bytes (5 * 6 일때)

 }
}

/*
 * 답지에서는 BFS로 문제를 풀이하였다. DFS의 경우 재귀함수를 사용하여 속도면에서 느린부분이 있다고하니 BFS를 사용해서 다시 구현해볼 것.
 *  - 검색 대상의 그래프가 클 때는 DFS가 유리
 *  - 특정 경로의 특징을 저장 (경로에 숫자가 있어서 가면 안된다거나 ..) 이럴 때는 DFS가 유리
 *  - 모든 경로를 탐색할때는 DFS, BFS 둘 다 괜찮다.
 */