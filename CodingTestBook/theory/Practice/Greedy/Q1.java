import java.util.*;

/*
 * 8/27 그리디 문제
 * 첫째줄에 모험가의 수 N이 주어진다.
 * 둘째 줄에 각 모험가들의 공포도 값이 자연수로 주어진다.
 * 공포도가 X인 모험가는 반드시 X명이상이 함께 파티를 꾸려 모험을 떠나야한다고 할 때
 * 여행을 떠날 수 있는 최대 그룹 수를 출력하라.
 * (모든 모험가가 파티를 구성해야하는건 아니다.)
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
      
        Arrays.sort(arr); //오름차순 정렬
        int count = 0;
        int index=0;
        while(true){
            if(arr[index] > arr.length - index -1) break;
            else {
                index += arr[index];
                count++;
            }
        }
        System.out.println(count);
        
    }


}