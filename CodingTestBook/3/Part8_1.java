/*
 * 8/21 다이나믹 문제 - p217
 * 정수 X가 주어진다.
 * 5로 나누어지면 5로 나누고
 * 3으로 나누어지면 3으로 나누고
 * 2로 나누어지면 2로 나눈다
 * 그렇지 않다면 1을 뺀다
 * X를 1로 만들기 위한 최소 연산 횟수를 출력하라.
 */

import java.util.*;




public class Part8_1 {

    public static int[] array = new int[30000];
    public static void setValue(int value) {

        int min_count = array[value-1];

        if(value % 5 == 0){
            if(min_count > array[value/5]) min_count = array[value/5];
        }
        else if(value % 3 == 0){
            if(min_count > array[value/3]) min_count = array[value/3];
        }
        else if(value % 2 == 0){
            if(min_count > array[value/2]) min_count = array[value/2];
        }
        array[value] = min_count + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        for(int i=2; i<30000; i++){
            setValue(i);
        }
       System.out.println(array[X]);
    }
}

/*
 * 처음에는 수학적으로 접근하려했지만 답이 나오지 않았다. 그래서 방향성을 바꾼게 모든 값을 다 구해서 처리하는 방법을 사용했다.
 * 특히 최소값의 경우 Math.min( a, b )함수를 사용하면 코드가 더 간결해진다.
 * 
 * 초기에는 5 , 3,  2로 나누었을 때 나오는 값 vs 1을 빼고 5로나누어지는지, 1을 뺐을때 3으로나누어지는 지 등 모든 경우의 수를 다 찾으려했는데 생각해보면
 * 전체 경우의 수는 1을 빼기, 5로 나누기, 3으로 나누기, 2로 나누기였다. 이미 이전값의 최소값은 다 구해져있으니까
 */