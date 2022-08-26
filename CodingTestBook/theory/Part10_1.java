/*
 * 8/26 서로소 집합 알고리즘
 * 첫째줄에 N과 M이 주어진다. 각 학생은 0번부터 N번까지의 번호를 가지게된다.
 * 초기 학생들은 각각 개인이 한 팀으로 총 N+1의 팀이 존재하게된다.
 * 여기서 M번의 다음 연산이 주어질 때 "같은 팀 여부 확인" 연산 결과를 출력하라
 * 0. "팀 합치기" - 두 팀을 합침
 * 1. "같은 팀 여부 확인" - 두 학생이 같은 팀이라면 Yes, 아니면 No 출력
 * ( 0 a b) -> a,b합침
 * ( 1 a b) -> a,b팀 여부 확인
 *
 */

import java.util.*;


public class Part10_1 {
    
    public static int[] parentNode = new int[999999];

    public static int findParent(int index){ //특정 팀의 부모노드를 찾는다. 
        if(parentNode[index] == index) {
          return index;
        }
        return parentNode[index] = findParent(parentNode[index]);
    }


    public static void sumParent(int team1, int team2){ //두 팀을 합친다 (부모노드를 같게 한다)
        int team1_parant = findParent(team1);
        int team2_parant = findParent(team2);

        if(team1_parant < team2_parant) parentNode[team2_parant] = parentNode[team1_parant];
        else parentNode[team1_parant] = parentNode[team2_parant];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        for(int i=0; i<N; i++){ //초기 부모노드의 값을 자기 자신으로 초기화
            parentNode[i] = i;
        }
        for(int i=0; i<M; i++){
            int type = sc.nextInt();
            int team1 = sc.nextInt();
            int team2 = sc.nextInt();

            if(type == 0){
                sumParent(team1, team2);
            }
            else{
                if(findParent(team1) == findParent(team2)){
                    System.out.println("YES");
                }
                else System.out.println("NO");
            }
        }
      
    }
}   
