/*
 * 8/19 탐색 문제 - p197
 * N개의 고유한 번호를 가지고 있는 부품들이 있다.
 * 손님은 M개의 종류의 부품을 구매하려고 한다. 
 * N개의 고유한 번호를 가지고 있는 부품이 손님이 요구하는 부품에 모두 포함되는지 여부를 yes, no로 출력햐라
 */

import java.util.*;


public class Part7_1 {

    public static boolean isExist(Integer[] array, int target, int start, int end){
        if(start > end) return false;
        else{
            int mid = (start + end) / 2;

            if(array[mid] == target){
                return true;
            }

            if(target < array[mid]) {
                return isExist(array, target, start, mid-1);
            }
            else{
               return isExist(array, target, mid+1, end);
            }
        } 

        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] itemArray = new Integer[N];


        for(int i=0; i< N; i++){
            itemArray[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        Integer[] requestArray = new Integer[M];

        for(int i=0; i<M; i++){
            requestArray[i] = sc.nextInt();
        }

        Arrays.sort(itemArray);  //탐색을 용이하게 하기 위한 정렬
        Arrays.sort(requestArray);

        for(int i=0; i<M; i++){
            if(isExist(itemArray, requestArray[i], 0 , N-1)) System.out.print("yes ");
            else System.out.print("no ");
        }
 }
}

