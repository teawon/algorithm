/*
 * 7/3 구현 문제 - p118
 * NxM의 개수가 입력값으로 들어온다.
 * 현재 캐릭터의 좌표값과 바라보고있는 방향 [ ex) 1 1 0  : 1,1좌표에 북쪽(0)을 보고있는 캐릭터 ] 값이 주어진다. (북 , 동, 남 , 서)
 * 셋째 줄 부터는 좌표값에 대해 0(육지) 1(바다)의 정보가 주어진다.
 * 캐릭터는 바다로 이동할 수 없다
 * 캐릭터는 항상 자신이 바라보는 왼쪽방향을 바라보며 가보지 않은 칸이 있다면 왼쪽 방향으로 돌아보고 한 칸 전진한다.
 * 만약 왼쪽방향에 가보지 않은 칸이 없다면 왼쪽으로 회전만 하며 위 행동을 계속 반복한다.
 * 만약 네 방향 모두 가봤거나 바다라면 뒤로 한칸 돌아가고 이를 반복한다.
 * 
 * 총 캐릭터가 방문한 칸의 수를 출력하시오.
 */

import java.util.*;

public class Part4_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();

        int x=sc.nextInt(); //현재 x좌표 (row)
        int y=sc.nextInt(); //현재 y좌표 (col)
        int direct = sc.nextInt();
        int[][] map = new int[N][M];
        
        int nextX = 0;
        int nextY=  0;

        int count = 0;
        boolean flag=true;

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                map[r][c]= sc.nextInt();
            }
        }
    
        while(flag){

            switch(direct) { //바라보는 방향의 왼쪽칸이 목표 위치
                case 0: nextX =x;
                        nextY = y-1;
                        break;
                case 1: nextX =x-1;
                        nextY = y;
                        break;
                case 2: nextX =x;
                        nextY = y+1;
                        break;
                case 3: nextX =x+1;
                        nextY = y;
                        break;
            }

            if(
                ( (map[x+1][y] == 1) || (map[x+1][y] == 2) ) && ( (map[x-1][y] == 1) || (map[x-1][y] == 2) ) &&
                ( (map[x][y+1] == 1) || (map[x][y+1] == 2) ) && ( (map[x][y-1] == 1) || (map[x][y-1] == 2) ) //막다른 길 이라면
              ) {
            
                switch(direct) {  //방향은 유지한 채 뒤로간다. 단, 뒤로갔는데 바다라면 종료
                    case 0: nextX =x+1;
                            nextY = y;
                            break;
                    case 1: nextX =x;
                            nextY = y-1;
                            break;
                    case 2: nextX =x-1;
                            nextY = y;
                            break;
                    case 3: nextX =x;
                            nextY = y+1;
                            break;
                }
                    if(map[nextX][nextY] == 1 ){
                        flag = false;     
                    }
                    else{
                        x=nextX;
                        y=nextY;
                    }
              }
             
        

            if(map[nextX][nextY] == 0){ //왼쪽 방향이 새로운 곳이라면 전진 후 방향 그대로
                count++;
                map[nextX][nextY] = 2;
                x= nextX;
                y= nextY;
                direct = (direct+3) % 4; 
                //0 -> 3  , 1->0 , 2->1 , 3->2 .. 반복 (어떤 수의 % 4는 0 1 2 3 인데 원하는건 3 0 1 2 이므로 ..)
 
            }
            else if(map[nextX][nextY] == 2 || map[nextX][nextY] == 1 ){ //이미 가봤던 장소거나 바다라면 방향만 수정
                direct = (direct+3) % 4; 
            }
        }
    
       System.out.println(count);
 }
}

