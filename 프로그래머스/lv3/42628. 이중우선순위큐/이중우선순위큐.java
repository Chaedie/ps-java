import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String str: operations) {
            String[] strs = str.split(" ");
            if (strs[0].equals("I")) {
                pq.add(Integer.valueOf(strs[1]));
                maxPq.add(Integer.valueOf(strs[1]));
            } else {
                if (pq.isEmpty()) continue;
                if (strs[1].equals("1")) {
                    int max = maxPq.poll();
                    pq.remove(max);
                } else {
                    int min = pq.poll();
                    pq.remove(min);
                }
            }
        }
        
        int[] answer = new int[2];
        if (!pq.isEmpty()) {
            answer[0] = maxPq.poll();
            answer[1] = pq.poll();
        }
        
        return answer;
    }
}