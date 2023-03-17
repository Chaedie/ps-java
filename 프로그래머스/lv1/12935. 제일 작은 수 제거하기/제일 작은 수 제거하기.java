import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[0];
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(x->x != min).toArray();
    }
}