import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11399
 * 
 * 문제 접근 방법 & 사용 알고리즘: 끝낼 사람은 빨리 끝나서 나가야한다. 즉 짧은 순으로 정렬 후 출력
 * 
*/

public class P_11399 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int N = Integer.parseInt(br.readLine()); 
        Integer[] peopleArr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            peopleArr[i] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.sort(peopleArr);
        
        int time = 0;
        int curTime = 0;

        for(int i=0; i<N; i++){
            time += peopleArr[i] + curTime;
            curTime += peopleArr[i];
        }

        System.out.println(time);
    }
}

