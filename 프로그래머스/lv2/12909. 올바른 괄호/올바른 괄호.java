import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        // 얼리리턴을 해줘야됨
        // 얼리리턴을 위해선 스택에 '('만 들어간다는걸 알아야됨
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.size() == 0) { return false; }
                stack.pop();
            }
        }
        
        return stack.size() == 0;
    }
}

//   Stack<Character> stack = new Stack<>();
        
//     for (int i = 0; i < s.length(); i++) {
//         if (stack.size() == 0) {
//             stack.push(s.charAt(i));        
//         } else if (stack.peek() == '(' && s.charAt(i) == ')') {
//             stack.pop();
//         } else {
//             stack.push(s.charAt(i));
//         }
//     }

//     return stack.size() == 0;