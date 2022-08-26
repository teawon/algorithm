/*
 * 8/26 크루스칼 알고리즘 (신장트리 만들기)
 * 집의 개수 N , 길의 개수 M이 주어진다. (1<M<1,000,000 / 2<N<100,000)
 * 집이 연결되어있는 하나의 도시를 두 개로 나누려고 할 때 
 * 나눠진 두 도시사이에는 어떠한 길도 없어도 된다. 추가로 각 도시사이에서 연결이 가능하다면 길을 지울 수 있다.
 * 각 길의 총합이 최소가되도록 도시를 분할하고 길을 지우고 그 값을 출력하라
 */

import java.util.*;

class HouseNode{
    private int start;
    private int end;
    private int distance;

    public HouseNode(int start, int end, int distance){
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
    

    public int getStart(){
        return start;
    }
    public int getEnd(){
        return end;
    }

    public int getDistance(){
        return distance;
    }
}

public class Part10_2 {

    public static int[] parentNode = new int[999999];

    public static int findParent(int index){ //특정 팀의 부모노드를 찾는다. 
        if(parentNode[index] == index) {
          return index;
        }
        return parentNode[index] = findParent(parentNode[index]);
    }


    public static void sumParent(int node1, int node2){ //두 팀을 합친다 (부모노드를 같게 한다)
        int node1_parent = findParent(node1);
        int node2_parent = findParent(node2);

        if(node1_parent < node2_parent) parentNode[node2_parent] = parentNode[node1_parent];
        else parentNode[node1_parent] = parentNode[node2_parent];
    }
    
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //집의 개수
        int M = sc.nextInt(); //길의 개수

        HouseNode[] houseArray = new HouseNode[M];

        for(int i=0; i<N; i++){  //각 집의 부모노드를 초기화
            parentNode[i] = i;
        }

        for(int i =0; i<M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();
            houseArray[i] = new HouseNode(start, end, distance);
        }
        
        Arrays.sort(houseArray, new Comparator<HouseNode>() {
            @Override
            public int compare(HouseNode n1, HouseNode n2) {
                return Integer.compare(n1.getDistance(),n2.getDistance()); //오름차순
            }
        });


        int max = -1;
        int sum_of_min = 0;

        for(int i=0; i<M; i++){
            int start = houseArray[i].getStart();
            int end = houseArray[i].getEnd();

            if(findParent(start) != findParent(end)){

                int distance = houseArray[i].getDistance();
                max = Math.max(max , distance);
                sum_of_min += distance;
                sumParent(start, end);
            }
        }
        System.out.println(sum_of_min-max);
        
    }
}   

/*
 * 접근방식1) 일단 싸이클이 생기지 않도록 각 노드를 다지우고 그 중 가장 큰 노드의 값을 지우면 2개의 도시가 나오지 않을까? -> 정답
 * 초기에는 부모노드가 곂치면 null값을 ArrayList에 갱신시키고, 모든 연산을 마치고 다시 한번 for문을 돌며 null이 아닐 때 각 거리를 연산했다
 * 하지만 위 for문에서 한 번에 처리하는 방법이 더 좋았다.
 * 
 * +)특정 객체의 정렬 방법
 * 1) class Edge implements Comparable<Edge> {
        *  @Override
            public int compareTo(Edge other) {
                if (this.distance < other.distance) {
                    return -1;
                }
                return 1;
        }
    }
 * }
 * 이후  Collections.sort(배열이름);
 * 
 * 
 * 
 * 2) Arrays.sort(houseArray, new Comparator<HouseNode>() {
            @Override
            public int compare(HouseNode n1, HouseNode n2) {
                return Integer.compare(n1.getDistance(),n2.getDistance()); //오름차순
            }
        });

    
    객체 자체에서 하는 방법이 더 깔끔한 것 같다. 
 */