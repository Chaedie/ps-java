import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = n + 1;
        int countOne = Integer.bitCount(n);
        while (i <= 1_000_000) {
            if (Integer.bitCount(i) == countOne) { break; }
            i++;
        }
        
        return i;
    }
}