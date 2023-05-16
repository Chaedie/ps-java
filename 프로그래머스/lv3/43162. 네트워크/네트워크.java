import java.util.*;

class Solution {
    
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        int count = 0;  
        
        // 노드를 전부 돌면서 visit안했음 bfs돌거임
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                bfs(i, computers);
                count++;
            }
        }
        
        return count;
    }
    
    private void bfs(int i, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visit[i] = true;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            
            for (int j = 0; j < computers.length; j++) {
                if (!visit[j] && computers[x][j] == 1 && x != j) {
                    visit[j] = true;
                    q.add(j);
                }
            }
        }
    }
}