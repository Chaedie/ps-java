import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int p = 0;
        for (int i = 1; i <= 1_000_000; i++) {
            if (i > order.length) break;
            
            if (order[p] == i) {
                count++;
                p++;
            } else {
                stack.push(i);
            }
            
            while(!stack.isEmpty() && stack.peek() == order[p]) {
                count++; 
                p++;
                stack.pop();    
            }
        }
        
        return count;
    }
}