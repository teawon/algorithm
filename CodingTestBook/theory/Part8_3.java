/*
 * 8/22 다이나믹 문제 - p223
 * 가로의 길이 N이 주어진다.  (1<N<1000)
 * 2 x N의 판이 있을 때
 * 2x1  / 1x2 / 2x2의 판으로 해당 판을 채울 수 있는 모둔 경우의 수를 출력하라
 */

import java.util.*;


public class Part8_3 {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[]  countCase= new int[1000];
        
        countCase[1] = 1;
        countCase[2] = 3;
        for(int i =3; i<1000; i++){
            countCase[i] = countCase[i-1] + countCase[i-2]*2;
        }
        System.out.println(countCase[N]);

    }
}   

/*
 * countCase[i-2]+2라고 처음에는 실수를 했다.
 * 수학적인 접근을 할 때 실수하지 말자
 */