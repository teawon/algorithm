/*
 * 8/25 최단경로 문제
 * 첫째줄에 도시 N , 둘째줄에 통로 M , 그리고 출발지 C가 주어진다.
 * 둘째줄에서는 (출발지 , 목적지, 걸리는 시간)의 정보가 주어지는데
 * 도시 C에서 보낸 메세지를 받는 도시의 총 개수와 가장 오래걸리는 시간을 출력하라.
 * (단 통로는 단방향이다. A->B라면 B->A를 의미하는게 아님.)
 * [개선 - 우선순위 큐를 사용한 다익스트라 알고리즘]
 */

import java.util.*;

class Node2 implements Comparable<Node2>{
    private int cityNum;
    private int value;

    public Node2(int cityNum, int value){
        this.cityNum = cityNum;
        this.value = value;
    }

    public int getCityNum(){
        return cityNum;
    }
    
    public int getValue(){
        return value;
    }

    @Override //우선순위를 override하여 표현
    public int compareTo(Node2 target){
        if(this.getValue() < target.getValue()) return -1;
        
        return 1;
    }
}

public class Part9_2_v2 {
    
    public static int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //도시의 개수
        int M = sc.nextInt(); //통로의 개수
        int C = sc.nextInt()-1; //메세지를 보내는 도시

        int[][] graph = new int[N][N];


        for(int i=0; i<M; i++){
            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;
            int distance = sc.nextInt();

            graph[start][end] = distance;
        }

        int[] distance = new int[N];
        Arrays.fill(distance, INF);

        PriorityQueue<Node2> que = new PriorityQueue<>();

        que.offer(new Node2(C,0));
        distance[C] = 0;
            
        

        while(!que.isEmpty()){
            Node2 selected = que.poll();
            int selectedCity = selected.getCityNum();
            int selectedValue = selected.getValue();

            if(selectedValue>distance[selectedCity]) continue;
            
            for(int i=0; i<N; i++){
                if(graph[selectedCity][i]!=0 && graph[selectedCity][i] + selectedValue < distance[i] ){
                    que.offer(new Node2(i,graph[selectedCity][i]));
                    distance[i] = graph[selectedCity][i];
                }
            }

        }

        int count = 0;
        int max = -1;
        for(int i=0; i<N; i++){
            if(distance[i] == INF) continue;
            max = Math.max(max , distance[i]);
            count++;
        }

        System.out.println(count - 1+" "+max);
    }
}   

/*
 * 큐와 우선순위 뭐가 다를까?
 * 일단 "가장 작은 경로"를 큐에서 우선순위를 가져와 꺼내게된다면 불필요한 작업이 줄어든다.
 * 예를들어 4번경로가 가까워서 4번경로로 이어지는 최단경로 값으로 최종적으로 갱신이 되는게 정답이라면
 * 그냥 큐로 넣었을 때는 2번, 3번경로에 대한 최단경로 값을 구하고 또 마지막에 4번경로로 갱신하는 것과
 * 처음부터 4번경로로 갱신 후 2번, 3번경로의 갱신을 건너뛰는 것과는 상당한 차이가 있기 때문이다.
 * 
 * 
 * -> 우선순위 큐를 어떻게 구현하는 지 숙지하기 (Comparable상속과 compareTo를 활용한 클래스 만들기)
 * -> 자기 자신에 대한 경로는 0으로 초기화하여 INF와 구분할 수 있게 하기
 */