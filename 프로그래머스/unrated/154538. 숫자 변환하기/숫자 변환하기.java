import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // if (num == y) count++
        // if (num > y) return;
        // +n, *2, *3 을 bfs로 돌리면됨
        // 근데 bfs를 못돌리겟네 큐에뭘넣어야할지를 모르겠다...
        // 그냥 재귀 돌려야할듯..
        // 재귀는 시간 초과
        // bfs도 시간초과되었다. 
        // dp요소를 추가해야겠다. 중복계산하지 않도록
        // 중복계산이면 (이전에 계산한 숫자면) return 하도록
        
        int[] dp = new int[1_000_001];
        Queue<int[]> q = new LinkedList<>();
        // x, count
        q.add(new int[]{x,0});
        while(!q.isEmpty()) {
            int[] nums = q.poll();
            int num = nums[0];
            int count = nums[1];
            if (num == y) { return count; }
            if (num > y || num > 1_000_000) { continue; }
            if (dp[num] == 0) {
                dp[num] = count;    
            } else if (dp[num] <= count){
                continue;
            } else {
                dp[num] = count;
            }
            
            
            
            q.add(new int[]{num * 3, count + 1});
            q.add(new int[]{num * 2, count + 1});
            q.add(new int[]{num + n, count + 1});
        }
        return -1;
    }
}


//  public int solution(int x, int y, int n) {
//     // if (num == y) count++
//     // if (num > y) return;
//     // +n, *2, *3 을 bfs로 돌리면됨
//     // 근데 bfs를 못돌리겟네 큐에뭘넣어야할지를 모르겠다...
//     // 그냥 재귀 돌려야할듯..

//     dfs(x, y, n, 0);


//     return min == Integer.MAX_VALUE ? -1 : min;
// }

// private int min = Integer.MAX_VALUE;
// private void dfs(long x, int y, int n, int count) {
//     if (x > y) return;
//     if (x == y) {
//         min = Math.min(min, count);
//         return;
//     } 
//     dfs(x + n, y, n, count + 1);
//     dfs(x * 2, y, n, count + 1);
//     dfs(x * 3, y, n, count + 1);

//     return;
// }