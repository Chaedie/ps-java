import java.util.*;

class Solution {
    // 가장 낮은 두개의 음식을 섞기
    // 섞은 음식의 지수 = 가장 맵지 않은 + (두번째 맵지않은 * 2);
    // 최하가 k이상일때까지 반복
    // 최소 횟수를 return
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = initPQ(scoville);
        
        int count = 0;
        while(pq.peek() < K) {
            if (pq.size() == 1) return -1;
            int first = pq.poll();
            int second = pq.poll();
            int mixed = first + (2 * second);
            pq.add(mixed);
            count++;
        }
       
        return count;
    }
    
    private PriorityQueue<Integer> initPQ(int[] scoville) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : scoville) {
            pq.add(num);
        }
        return pq;
    }
}