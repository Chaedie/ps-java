import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(new int[]{progresses[i], speeds[i]});
        }
        
        int day = 1;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            if (q.peek()[0] + (day * q.peek()[1]) >= 100) {
                q.poll();
                count++;
            } else {
                day++;
                if (count != 0) {
                    list.add(count);
                    count = 0;    
                }
            }
        }
        list.add(count);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}