/*
 * 8/18 
 * 1,1의 좌표에서 N.M 좌표에 이동하기 위한 최소 이동 칸을 출력하라. (시작칸과 마지막칸도 개수에 포함한다.)
 * 단 각 좌표에서 벽으로 막혀있는 곳은 0 , 그렇지 않다면 1로 각 좌표 값이 제시된다.
 * [BFS]를 사용하여 재구현 (정답을 참조)
 */

import java.util.*;


class Node {
    private int x;
    private int y;

    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
}

public class Part5_2_BFS {

    public static int N,M;
    public static int[][] array = new int[999][999];

    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int find_by_bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for(int i=0; i<4; i++){
                int x_= x +  dx[i];
                int y_= y +  dy[i];

                if(x_ < 0 || x_ >= N || y_<0 || y_ >= M) continue;

                if(array[x_][y_] == 1)  {
                
                    q.offer(new Node(x_,y_));
                    array[x_][y_] = array[x][y]+1;
                }
            }

        }
        return array[N-1][M-1];
    
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

        System.out.println(find_by_bfs(0,0));
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");
        // 메모리 사용량은 6418272 bytes ( 5 * 6 일때)

 }
}

/*
 * - Que방식을 자바에서 어떻게 구현했는 지 다시 볼 것 
 * - {상 하 좌 우}를 탐색할 때 일일이 하기보다 for문으로 한번에 하는 방식 다시 볼 것
 * - 최단거리를 찾을 때는 BFS가 유리하다.
 * - 모든 경로를 탐색할때는 DFS, BFS 둘 다 괜찮다.
 */
