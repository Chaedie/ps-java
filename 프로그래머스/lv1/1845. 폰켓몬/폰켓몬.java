import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // n/2 와 종류의 갯수 중 Math.min()하면될듯
        
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        
        return Math.min(nums.length / 2, set.size());
    }
}