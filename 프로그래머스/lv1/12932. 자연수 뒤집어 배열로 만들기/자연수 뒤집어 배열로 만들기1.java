import java.util.*;

class Solution {
    public int[] solution(long n) {
        char[] chars = Long.toString(n).toCharArray();
        
        int[] nums = new int[chars.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Character.getNumericValue(chars[chars.length - 1 - i]);
        }
        
        return nums;
    }
}
