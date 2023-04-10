import java.util.*;

class Solution {
    // 큐에 담음
    // int count = 0;
    // int j = q.poll();
    // if(isPriority(q, j)) { count++; if(location == 0) return count; } else { q.add(j); }
    // 우선순위 확인하는 방법은, 
    // int[]를 sort한뒤에 작은거부터 스택에 담음 
    // stack.peek()이 q.poll()이랑 같으면 최댓값이라는거임 
    // 같으면 stack.pop()하면됨
    public int solution(int[] priorities, int location) {
        // {priority, location};
        Queue<int[]> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        int count = 0;
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{ priorities[i], i});
        }
        Arrays.sort(priorities);
        for (int i = 0; i < priorities.length; i++) {
            stack.push(priorities[i]);
        }
        
        while(!q.isEmpty()) {
            int[] j = q.poll();
            if (stack.peek() == j[0]) {
                count++;
                stack.pop();
                if (j[1] == location) break;
            } else {
                q.add(j);
            }
        }
            
        return count;
    }
    
}