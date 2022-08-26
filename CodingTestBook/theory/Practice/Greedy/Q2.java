import java.util.*;

/*
 * 8/27 그리디 문제
 * 첫째줄에 여러 숫자로 구성된 문자열 S가 주어진다.
 * 각 숫자 사이에 "X" or "+" 연산자를 넣어 만들 수 있는 가장 큰 수를 출력하라. 
 * (단 연산은 항상 왼쪽부터 차례대로 진행한다.)
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int sum = 1;
        for(int i=0; i<S.length(); i++){
            int number = S.charAt(i) - '0';
            if(number != 0){
                sum *= number;
            }
        }

        if(sum == 1) System.out.println(0);
        else System.out.println(sum);
    }


}

/*
 * 풀이 : 가장 큰 수는 결국 곱하는건데 0일때는 곱하면 안되니까 0은 아에 스킵하기.
 *  */