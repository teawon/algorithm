/*
 * 7/3 구현 문제 - p115
 * 8 X 8 좌표평면의 특정 위치에 체스판의 나이트가 서있다.
 * 행의 위치는 1부터 8, 열의 위치는 a~h라고 표현하고 입력값으로 나이트의 위치가 선택된다면 
 * 이동 가능한 경우의 수를 출력하기 (ex - a1 , h3, c5)..
 */

import java.util.*;

public class Part4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.next();
        int row = input.charAt(1)-'0';  //char -> int
        int col = input.charAt(0)-96; //a의 아스키코드 값은 97 , b는 98 ....

        System.out.println(row+ "," +col);

        int count = 0;
  
        if(row+3 <9 && row+3 > 0){
            if(col+1 <9 && col+1 >0 )
            count ++;
            if(col-1 <9 && col-1 > 0)
            count ++;
        }
        if(row-3 <9 && row-3 > 0){
            if(col+1 <9 && col+1 >0 )
            count ++;
            if(col-1 <9 && col-1 > 0)
            count ++;
        }
        if(col+3 <9 && col+3 > 0){
            if(row+1 <9 && row+1 >0 )
            count ++;
            if(row-1 <9 && row-1 > 0)
            count ++;
        }
        if(col-3 <9 && col-3 > 0){
            if(row+1 <9 && row+1 >0 )
            count ++;
            if(row-1 <9 && row-1 > 0)
            count ++;
        }

       System.out.println(count);
 }
}

