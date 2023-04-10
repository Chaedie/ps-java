import java.util.*;

class Solution {
    // length만큼만 올라갈수있고,
    // 1초에 1렝스만큼 지나갈수있음
    // weight 이하로만 올라갈수있음
    // 큐에 올리고, 바쁜대기로 큐의 initTIme과 현재 time을 확인하면서 poll해도 되는지 판단후 poll하기
    // 큐에 올릴떄는 제약사항에 안걸리면 올리고 아니면 time++하면서 기다리기
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // {weight, onTime}
        Queue<int[]> q = new LinkedList<>();
        int i = 0;
        int time = 0;
        int totalW = 0;

        while(true) {
            if (i < truck_weights.length) {
                if (q.size() < bridge_length && totalW + truck_weights[i] <= weight) {
                    totalW += truck_weights[i];
                    q.add(new int[]{truck_weights[i++], time});
                    
                }
            }
            time++;
            
            if (q.isEmpty() && i == truck_weights.length) break;
            
            int[] truck = q.peek();
            int w = truck[0];
            int onTime = truck[1];
            if (onTime <= time - bridge_length) {
                q.poll();
                totalW -= w;
            }
            
        }
        
        return time;
    }
}