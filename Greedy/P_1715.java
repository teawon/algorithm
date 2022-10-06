import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1715
 * 정렬된 두 묶음의 숫자 카드가 있다고 하자. 각 묶음의 카드의 수를 A, B라 하면 보통 두 묶음을 합쳐서 하나로 만드는 데에는 A+B 번의 비교를 해야 한다.
 *  이를테면, 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요하다.

    매우 많은 숫자 카드 묶음이 책상 위에 놓여 있다. 이들을 두 묶음씩 골라 서로 합쳐나간다면, 고르는 순서에 따라서 비교 횟수가 매우 달라진다.
     예를 들어 10장, 20장, 40장의 묶음이 있다면 10장과 20장을 합친 뒤, 합친 30장 묶음과 40장을 합친다면 (10 + 20) + (30 + 40) = 100번의 비교가 필요하다. 
     그러나 10장과 40장을 합친 뒤, 합친 50장 묶음과 20장을 합친다면 (10 + 40) + (50 + 20) = 120 번의 비교가 필요하므로 덜 효율적인 방법이다.

    N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하시오.


 * 문제 접근 방법 & 사용 알고리즘: 1,2,3,4 카드가 있다면 1,2  / 3,4 를 비교후 두 카드를 합치는게 좋다. 
 * 즉 문제의 요지는 합쳐진 카드의 수를 포함해서 가장 작은 두 수를 합쳐나가는 것.
 * 
 * 더해진 카드더미를 "포함"해서 작은게 뭔지 찾아야하므로 우선순위 큐를 이용해 항상 정렬된 상태를 유지하도록 하였다.
 * 
 * 
*/

public class P_1715 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int N = Integer.parseInt(br.readLine());  //카드 묶음 수
      

        PriorityQueue<Integer> pQue = new PriorityQueue<>(); 
        for(int i=0; i<N; i++){
            pQue.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        while(pQue.size()!= 1){  //마지막 한 묶음(끝)이 나올 때 까지 가장 작은 두 카드더미를 합친다.
            int number1 = pQue.poll();
            int number2 = pQue.poll();

            pQue.add(number1+number2);
            count+=number1+number2;
        }
        

        System.out.println(count);
    }
}

