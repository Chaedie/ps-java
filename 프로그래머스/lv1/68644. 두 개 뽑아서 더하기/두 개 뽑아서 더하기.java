import java.util.*;

class Solution {
    // 이중 포문으로 다 더하면서 Set에 넣기
    // Set에서 list로 빼고 정렬하기
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        Set<Integer> set = new HashSet();
        
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        return set.stream().sorted().mapToInt(x->x).toArray();
    }
}