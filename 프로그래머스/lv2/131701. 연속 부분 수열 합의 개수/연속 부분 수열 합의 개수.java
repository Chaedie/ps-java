import java.util.*;

class Solution {
    // elements를 두배로 만들어서 합치고
    // for문 두개돌려서 합을 set에 넣으면됨
    public int solution(int[] elements) {
        int[] arr = new int[elements.length * 2];
        
        for (int i = 0; i < elements.length; i++) {
            arr[i] = elements[i];
            arr[i + elements.length] = elements[i];
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            for (int j = 1; j <= elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < j; k++) {
                    sum += arr[i + k];
                } 
                set.add(sum);
            }
        }
        
        return set.size();
    }
}