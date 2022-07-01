/*
 * 7/1 구현 문제 - p113
 * N이라는 자연수가 주어진다.
 * 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중 3이 하나라도 포함되는 경우의 수를 구하라
 */

import java.util.*;

public class Part4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int count = 0;
  
        for(int h=0; h<N+1; h++){
            for(int m=0; m<60; m++){
                for(int s=0; s<60; s++){
                    
                    if( s / 10 ==3 || s%10 ==3 || m/10 == 3 || m%10 ==3 | h%10 ==3)
                    count++;
                }
            
            }
       }

       System.out.println(count);
 }
}



//10의 자리 수 (number/10), 1의 자리수를 (number%3) 나타내고 3 , 6 , 9 식별을 위해 처음에는 3으로 나눴을 때 0이 나오도록 함 -> 0 , 1, 2 도 같이 들어간다.
// 3의 나머지로 처리하면? -> 3 , 6 , 9 , 0 까지 들어간다.
// 애초에 문제를 잘못 이해했다. 3 , 6, 9가 아니라 "3"만 포함되는 것을 찾아야 한다.  