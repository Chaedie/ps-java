import java.util.*;

class Solution {
    public int solution(String s) {
        // 회전시켜서
        // 올바른 괄호 문자열로 만들수있으면 return 몇번 회전시켰는지
        // 만들수없으면 0
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (isRightParen(s)) { count++; }
            s = rotateStr(s);
        }
        
        return count;
    }
    
    private boolean isRightParen(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            // 비어있으면 그냥 push만하고
            // 뭐 들어있으면 peek해서 뭐있는지 확인하고 
                // push할놈이랑 같으면 pop하고
                // 다르면 push하기
            Character ch = s.charAt(i);
            if (stack.size() == 0) {
                stack.push(ch);
            } else {
                Character peek = stack.peek();
                // peek이 '('이면서 ch 이 ')'
                
                if (
                    peek=='(' && ch==')' ||
                    peek=='{' && ch=='}' ||
                    peek=='[' && ch==']'
                ) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        
        return stack.size() == 0;
    }
    
    private String rotateStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        sb.append(s.charAt(0));
        String newStr = new String(sb);
        return newStr;
    }
}