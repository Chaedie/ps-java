import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        // 매일 1명 부름
        // 가수가 지금까지 출연가수중 k번째 이내면 명예의전당에 올림
        // k일까지는 모든 가수가 오름
        // 명예의 전당의 최하 점수를 발표함
        // 우선순위 큐로 명예의전당을만들면될듯
        // 오름차순이니까 그냥 선언하면되고,
        // peek이 당일 점수보다 낮으면 빼고 당일점수 넣기
        // answer배열에 매일매일 peek()해서 넣어주면됨
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                pq.add(score[i]);
                answer[i] = pq.peek();
            } else {
                if (pq.peek() < score[i]) {
                    pq.remove();
                    pq.add(score[i]);
                }
                answer[i] = pq.peek();
            }
        }
        
        return answer;
    }
}