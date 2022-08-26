/*
 * 6/30 그리드 문제 - p99
 * N이라는 자연수와 K라는 수가 주어진다.
 * N을 1로 만들기 위해 할수있는 랭동은 1. N에서 1을 빼거나 2. N이 K로 나누어진다면 나눌 수 있다.
 * 가장 최소의 횟수로 N을 1로 만들고자 할 때 그 횟수를 출력하라.
 */


import java.util.*;

public class Part3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;

        while(true){
            count += N % K;
            N = N/K;
            if(N == 0) break;
        }
        
        System.out.println(count--);

    }
}

//결국 나머지가 최우선시 되어야 하므로 나머지만큼 1을 빼는 연산 후, 해당 값을 나누는 것을 반복한다.