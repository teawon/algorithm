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
        int col = input.charAt(0)-'a'; //a의 아스키코드 값은 97 , b는 98 ....

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

/*
 * 동빈님의 코드 답지에서는 다음과 같이 접근했다.
 * // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }
 * 
 * -> 훨씬 더 코드가 직관적이고 깔끔한데 ƒor문으로 8가지 선택지에 대해 배열의 도움을 통해 표현함으로써 직관적인 코드의 가독성을 높일 수 있었다고 생각
 * 따라서 경우의 수가 정해져있다면 배열의 값을 통해 코드를 단순화 하는 연습을 해보자.
 * 
 * +) .charAt(0)-'96' 으로 특정 아스키값을 외워서 빼야했는데 사실 문자 그 값 자체를 빼주면 바로 0이 나오기때문에 
 * 문자 > 정수형으로 변환할 때 다음과 같은 방법을 사용하자. 
 */