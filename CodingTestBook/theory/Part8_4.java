/*
[ 다시 풀어 보기]
 * 8/22 다이나믹 문제 - p226
 * 화폐의 종류 N , 구하고자 하는 합 M이 주어진다
 * 화폐의 종류 N만큼 각 화폐의 가치값이 주어진다.
 * 합 M을 구성하기 위한 화폐의 최소개수를 출력하라 (단 구할 수 없으면 -1 출력)
 * 1<N<100 , 1<M<10,000
 */

import java.util.*;


public class Part8_4 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] sumOfMoney = new int[10000];
        Arrays.fill(sumOfMoney, 99999);
        int[] moneys = new int[N];

        for(int i=0; i<N; i++){
            moneys[i] = sc.nextInt();
            sumOfMoney[moneys[i]] = 1;
        }

        
        for(int i=0; i<N; i++){
            int value =  moneys[i];
            for(int j=1; j<10000; j++){
                if(j-value>0) {
                    sumOfMoney[j] = Math.min(sumOfMoney[j] ,sumOfMoney[j-value]+1);
                }
            }
        }

        if(sumOfMoney[M] != 99999) System.out.println(sumOfMoney[M]);
        else System.out.print(-1);

        


        
    }
}   


/*
 * 고민했던 방법 1. a원 b원 c원..등 각각 중첩for문을 돌려 7원 1 5원 2 3원 2 ..등 모든 값을 다 구해서 배열의 Index의 개수를 저장하고 꺼내기 (종류가 M개라 취소)
 * -> 초기 고민했던 방향은 맞았지만 구현방식이 틀렸다.
 * 전체를 for문으로 모든 경우의 수를 구하는게 아니라,
 * 특정 index의 최소 화폐 개수를 배열로 넣고 2 3 4 5 6 7 ...하나씩 증가시켜갈 때 어떤식으로 코드에서 저장할 지 고민하는게 맞는 듯
 */