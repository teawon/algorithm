import java.util.*;

/*
 * 8/27 그리디 문제
 * 0과 1로 이루어진 문자열 S가 첫번째줄에 주어진다.
 * 다솜이는 각 문자열을 모두 1로 만들어야하는데 한 번에 할 수 있는 행동은 "연속된 숫자"를 1로, 혹은 0으로 뒤집을 수 있다.
 * 모든 문자열을 같게 만들 수 있는 최소의 행동 횟수를 출력하라
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int preValue = S.charAt(0) - '0';
        int count_0 = 0;
        int count_1 = 0;

        if(preValue == 0) count_0 ++;
        else count_1 ++;

        for(int i=1; i<S.length(); i++){
            if(preValue == S.charAt(i) - '0') continue;
            else{
                preValue = S.charAt(i) - '0';
                if(S.charAt(i) - '0' == 0) count_0++;
                else count_1++;

            }
        }
        
        System.out.println(Math.min(count_0, count_1));
       
    }


}

/*
 * 풀이 : 0묶음의 수와 1묶음의 수를 계산해서 적은 값 출력하기
 *  */