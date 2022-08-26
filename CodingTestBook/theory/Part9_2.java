/*
 * 8/25 최단경로 문제
 * 첫째줄에 도시 N , 둘째줄에 통로 M , 그리고 출발지 C가 주어진다.
 * 둘째줄에서는 (출발지 , 목적지, 걸리는 시간)의 정보가 주어지는데
 * 도시 C에서 보낸 메세지를 받는 도시의 총 개수와 가장 오래걸리는 시간을 출력하라.
 * (단 통로는 단방향이다. A->B라면 B->A를 의미하는게 아님.)
 * [초기 구현 방식 - 우선순위큐가 아니라 그냥 큐를 사용했다.]
 */

import java.util.*;

class Node_City{
    private int cityNum;
    private int value;

    public Node_City(int cityNum, int value){
        this.cityNum = cityNum;
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    
    public int getCityNum(){
        return cityNum;
    }
}

public class Part9_2 {
    
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

        ArrayList<Node_City> que = new ArrayList<Node_City>();
        
        for(int i=0; i<N; i++){
            if(graph[C][i]!=0){
                que.add(new Node_City(i,graph[C][i]));
                distance[i] = graph[C][i];
            }
        }

        while(!que.isEmpty()){
            Node_City selected = que.remove(que.size()-1);
            int selectedCity = selected.getCityNum();
            int selectedValue = selected.getValue();

            if(selectedValue>distance[selectedCity]) continue; //이미 선택된 적이 있으면 스킵
            
            for(int i=0; i<N; i++){
                if(graph[selectedCity][i]!=0 && graph[selectedCity][i] + selectedValue < distance[selectedCity] ){ //선택된 노드와 연결된 경로가 있고,  그 경로로 갔을 때 값이 더 작다면 갱신
                    que.add(new Node_City(i,graph[selectedCity][i]));
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

        System.out.println(count+" "+max);
    }
}   
