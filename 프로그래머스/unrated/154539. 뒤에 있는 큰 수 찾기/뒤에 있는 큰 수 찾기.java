import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        
        stack.push(0);
        
        for (int i = 1; i < numbers.length; i++) {
            // 스택이 비어있지 않으면서, 
            // 스택의 최상단인덱스의 밸류값이 순회중인 넘버보다 작으면 (다음큰수를 찾으면)
            // answer에 큰수로 채운다.
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}