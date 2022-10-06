import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11047
 * 문제 접근 방법 & 사용 알고리즘: 
*/

public class P_11047 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //동전의 종류
        int K =  Integer.parseInt(st.nextToken()); //가치의 합
        
        int[] moneyArr = new int[N];
        for(int i=0; i<N; i++){
            moneyArr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int curMoney = K;
        int j = 0;
        while(curMoney != 0){
            if(curMoney < moneyArr[N-1-j]){
                j++;
            }
            else{
            count += curMoney / moneyArr[N-1-j];
            curMoney %=  moneyArr[N-1-j];
            }
        }
        

        System.out.println(count);
    }
}

