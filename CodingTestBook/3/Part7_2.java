/*
 * 8/19 탐색 문제 - p201
 * N개의 떡의 개수와 , 필요한 떡의 길이 M이 주어진다.
 * 각 떡은 각각 특정 길이를 가지고있는데 "설정 높이"값보다 각 떡의 길이가 높으면 자르게 된다.
 * 잘린 떡의 길이의 합이 M이상이 되도록하는 "설정 높이"의 최대값을 출력하라
 * M의 값은 1 ~ 20000000000
 */

import java.util.*;


public class Part7_2 {

public static int search(Integer[] array, int start, int end, int requestSum){ //최대의 높이 값을 가지는 height값을 찾는다.
    
   int max_height = 0;
   while(true) {
        if(start > end) break;

        int mid = (start + end) /2;
        int sum = cal_length(array,mid);

        //System.out.println("height : " + mid + " sum : " + sum); //이진 탐색의 내용확인을 위한 출력문

        if(sum >= requestSum){
            max_height = mid;
            start = mid+1;
        }
        else{
            end = mid - 1;
        }
   }
   
  return max_height;
   
}

public static int cal_length(Integer[] array, int height){  //특정 길이에 대한 전체 떡의 길이 반환 함수
    int sum = 0;

    for(int i=0; i<array.length; i++){
        if(array[i] > height){
            sum += (array[i] - height);
        }
    }
    return sum;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //떡의 개수
        int M = sc.nextInt(); //필요한 떡의 총 길이
        int max_height;

        Integer[] rice_array = new Integer[N];

        for(int i=0; i<N; i++){
            rice_array[i] = sc.nextInt();
        }

        max_height = search(rice_array, 0, 2000000000, M);
        System.out.println(max_height);


       
    }
}

/*
 * 처음에는 0부터 임의의 수까지 구하고자 하는 임의의 X값을 찾기 위해 하나씩 모든 값을 넣어 계산을 했다.
 * 그러나 이렇게 숫자가 클 경우 하나하나 모든 값을 넣어 찾는게 아니라 이진탐색 방법을 사용해야한다는걸 꼭 잊지 말자.
 */