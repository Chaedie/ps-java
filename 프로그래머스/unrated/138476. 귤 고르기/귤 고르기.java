import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 종류의 갯수가 최소가 되도록 
        // 종류별로 묶어야됨 해시맵으로 count하면됨
        // value가 가장 큰 애들부터 세서 k이상이 되면 종류의 갯수 return
        Map<Integer, Integer> map = new HashMap<>();
        
        for (Integer tan: tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a,b) -> map.get(b).compareTo(map.get(a)));
        int count = 0;
        for (int i = 0; i < keys.size(); i++) {
            count += map.get(keys.get(i));
            
            if (count >= k) { return i + 1; }
        }
        
        return -1;
    }
}