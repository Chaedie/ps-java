import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        long len = (right - left + 1);
        long k = left - (left % n);
        for (int i = (int) (left / n); i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = j < i ? i : j;      
                if (k >= left && k <= right) list.add(x+1);
                if (list.size() == len) return list.stream().mapToInt(num->num).toArray();
                k++;
            }    
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}
