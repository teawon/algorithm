import java.util.*;

/*
 * 6/30 그리드 문제 - p92
 * 첫째 줄에 N , M , K의 자연수가 주어진다.
 * 총 N개의 배열원소 중 M개를 더하는데 특정 인덱스 번호가 K번 이상 연속해서 나올 수 없다.
 * 나올 수 있는 최대 값을 출력하라
 */
public class Part3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        Integer[] array = new Integer[N];

        for(int i=0; i<N; i++){
            array[i]=sc.nextInt();
        }
        // 초기 input 값 설정 
        Arrays.sort(array, Collections.reverseOrder());
        Integer result = 0;
       

        // int count = 0;
        // while(true){
        //     for(int j=0; j<K; j++){
        //         result+= array[0];
        //         if(++count == M) break;
        //     }
        //     result+= array[1];
        //     if(++count == M) break;
        // }
          
     
        // 초기에는 다음과 같이 모든 연산에 대해 계산했으나 if문을 매번 확인하는 방법은 좋지 않다.
        // 따라서 미리 몇 회 연산이 될 지 계산을 해서 다음과 같이 계산해야 속도면에서 훨씬 유리하다.
        // 3 + 3 + 3 + 2 + 3 + 3+ 3 + 2 ..... 

        int notMaxAddCount = M / (K+1);
        result = array[0]* (M-notMaxAddCount) + array[1]*notMaxAddCount; 
        System.out.println(result);
    }


}