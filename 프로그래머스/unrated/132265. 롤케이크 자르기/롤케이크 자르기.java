import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // map 2개를 만들어서
        // 순회하면서 넣고 뺴고 하면서 
        // 키값의 갯수를 비교해서 같으면 count++
        
        // 토핑종류, 갯수
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        map1.put(topping[0], 1);
        for (int i = 1; i < topping.length; i++) {
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        }
        
        // 순회하면서 넣고 빼기
        int count = 0;
        if (map1.keySet().size() == map2.keySet().size()) { 
            count++;
        }
        
        for (int i = 1; i < topping.length; i++) {
            map1.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
            map2.put(topping[i], map2.get(topping[i]) - 1);
            if(map2.get(topping[i]) == 0) {
                map2.remove(topping[i]);
            }
            
            if (map1.keySet().size() == map2.keySet().size()) { 
                count++; 
            }
        }
        
        return count;
    }
}