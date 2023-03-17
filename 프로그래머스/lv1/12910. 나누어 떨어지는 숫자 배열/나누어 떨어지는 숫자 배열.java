import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            if (num % divisor == 0) {
                stack.push(num);
            }
        }
        
        if (stack.size() == 0) { 
            stack.push(-1);
        }
        return stack.stream().sorted().mapToInt(x->x).toArray();
    }
}