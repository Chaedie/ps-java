import java.util.*;

class Solution {
    // 일단 가로 기준으로 정렬함
    // 그럼 가로가 가장 큰놈을 기준으로 잡고, 
    
    // 배열을 돌면서 각 0번째 배열이 큰값이 되도록 돌려줌
    // 0번쨰 값 기준으로 정렬함
    // 1번째 값중 가장 큰 놈을 곱하면 답
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 가로세로 중 큰값이 가로로 오도록
        for (int i = 0; i < sizes.length; i++) {
            int first = sizes[i][0];
            int second = sizes[i][1];
            if (first < second) {
                sizes[i][0] = second;
                sizes[i][1] = first;
            }
        }
        
        // 가로기준으로 내림차순 정렬
        Arrays.sort(sizes, (x, y) -> y[0] - x[0]);
        
        // 세로 중 가장 큰 값 찾기
        int max = 0;
        for (int[] size : sizes) {
            max = Math.max(max, size[1]);    
        }
        
        return max * sizes[0][0];
    }
}