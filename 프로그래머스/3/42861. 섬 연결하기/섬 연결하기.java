import java.util.*;

// 크루스칼 알고리즘을 이용한 문제
// 부모 노드를 이용하여 합침이 되었는가를 판별할 수 있음(이런 건 어떻게 생각하는걸까)
// 부모 노드는 일반적으로 더 작은 수로 설정함 
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] node = new int[n];
        for (int i = 0; i < n; i++) {
            node[i] = i; // 자기 자신을 부모 노드로 먼저 설정
        }
        //costs를 비용 오름차순으로 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        // find-union 과정
        for (int i = 0; i < costs.length; i++) {
            int p1 = find(node, costs[i][0]);
            int p2 = find(node, costs[i][1]);
            if(p1 != p2) {
                node[p2] = p1;
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    // 가장 최상위 부모 노드를 찾아야 함
    public int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return find(parent, parent[node]);
    }
}