import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int[] candidates = new int[] {0,1,2,3,4,5,6,7,8,9};
        for(int num : numbers) {
            candidates[num] = 0;
        }
        
        return Arrays.stream(candidates).reduce((acc,cur) -> acc+= cur).getAsInt();
    }
}