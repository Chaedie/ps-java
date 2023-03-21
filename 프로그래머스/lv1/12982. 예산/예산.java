import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int count = 0;
        Arrays.sort(d);
        for (int dep : d) {
            budget -= dep;
            if (budget < 0) { 
                return count;
            }
            count++;
        }
        
        return count;
    }
}