import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int from = commands[i][0];
            int to = commands[i][1];
            int index = commands[i][2];
            int[] sorted = Arrays.copyOfRange(array, from-1, to);
            Arrays.sort(sorted);
            answer[i] = sorted[index - 1];
        }
        
        return answer;
    }
}