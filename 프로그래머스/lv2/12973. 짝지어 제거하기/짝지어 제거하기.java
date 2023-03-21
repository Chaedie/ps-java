import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // stack 비면 push
            if (stack.size() == 0) { 
                stack.push(ch);
            // stack 최상단과 ch가 같으면 pop
            } else if (stack.peek() == ch) {
                stack.pop();
            // stack 최상단과 ch가 다르면 push
            } else {
                stack.push(ch);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}