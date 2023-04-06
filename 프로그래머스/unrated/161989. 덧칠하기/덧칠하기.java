import java.util.*;

class Solution {
    // 큐에 넣어서 하나빼서 다음거 확인해서 m 안쪽이면 다음거확인
    // 그러다 큐가 비었거나 다음게 m보다 멀리있으면 count++;
    // 반복
    public int solution(int n, int m, int[] section) {
        Queue<Integer> q = new LinkedList<>();
        for (int num : section) {
            q.add(num);
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            while (!q.isEmpty()) {
                int next = q.peek();
                if (next - cur < m) {
                    q.poll();
                } else {
                    break;
                }
            }
            count++;
        }
        
        return count;
    }
}