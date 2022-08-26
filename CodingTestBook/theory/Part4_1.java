/*
 * 7/1 구현 문제 - p110
 * N이라는 자연수가 주어진다.
 * N만큼 L R U D의 문자가 주어지고 N,N좌표평면 내에서 키워드에 맞게 한 칸씩 이동을 할 때
 * 입력된 문자에 대한 최종 위치의 좌표는? (1,1에서 시작 , NXN밖으로 나가는 명령은 무시)
 */

import java.util.*;

public class Part4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        char input;
        
        int x = 1;
        int y = 1;
        int i = 0;
        while(i<5) {
            input = sc.next().charAt(0);
            switch (input) {
                case 'R':  if(y<N) {y++; i++;}
                         break;
                case 'L':  if(y>1) {y--; i++;};
                         break;
                case 'U':  if(x>1) {x--; i++;};
                         break;
                case 'D':  if(x<N) {x++; i++;};
                         break;
             
                default: break;
            }
           
        }

            System.out.println(x + "," + y);
        

    }
}

//비효율적인것 같지만 그냥 직관적으로 풀었다. 수학적으로 접근하기에도 순서에 따라 위치가 달라서 매번 이동경우에 대한 확인이 필요할 것 같음