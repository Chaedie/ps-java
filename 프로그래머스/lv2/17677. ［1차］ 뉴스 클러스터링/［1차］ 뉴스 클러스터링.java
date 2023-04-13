import java.util.*;

class Solution {
    // 자카드 유사도는 (교집합 / 합집합)이다.
    // 각 집합은 중복이 허용된다.
    
    // 문자열사이의 유사도는
    // 두글자씩 끊어서, FR RA AN NC CE 이런식으로 끊고, (교집합/ 합집합)을 만들면된다.
    public int solution(String str1, String str2) {
        // 소문자로 변경
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 2글자씩 자르기
        Map<String, Integer> map1 = getSubstringMap(str1);
        Map<String, Integer> map2 = getSubstringMap(str2);
        
        // map1, map2의 키값을 각각 순회하면서 map3 map4를 만든다. 이때 map3는 min값으로, map4는 max값으로 만든다.
        Map<String, Integer> minMap = getMinMap(map1, map2);
        Map<String, Integer> maxMap = getMaxMap(map1, map2);
        
        // Math.floor((minMap의 밸류의 합 / maxMap의 밸류의 합 ) * 65536 )
        int minTotal = getTotalValueOfMap(minMap);
        int maxTotal = getTotalValueOfMap(maxMap);
        
        // 공집합 예외처리
        if (minTotal == 0 && maxTotal == 0) return 65536;

        return  (minTotal * 65536) / maxTotal;
    }
    
    private int getTotalValueOfMap(Map<String, Integer> map) {
        int total = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            int value = map.get(key);
            total += value;
        }
        return total;
    }
    
    private Map<String, Integer> getMaxMap(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, Integer> entry: map1.entrySet()) {
            String key = entry.getKey();
            int value = Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
            if (value != 0) {
                map.put(key, value);    
            }
        }
        for (Map.Entry<String, Integer> entry: map2.entrySet()) {
            String key = entry.getKey();
            int value = Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
            if (value != 0) {
                map.put(key, value);    
            }
        }
        return map;
    }
    
    private Map<String, Integer> getMinMap(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, Integer> entry: map1.entrySet()) {
            String key = entry.getKey();
            int value = Math.min(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
            if (value != 0) {
                map.put(key, value);    
            }
        }
        for (Map.Entry<String, Integer> entry: map2.entrySet()) {
            String key = entry.getKey();
            int value = Math.min(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
            if (value != 0) {
                map.put(key, value);    
            }
        }
        return map;
    }
    
    private Map<String, Integer> getSubstringMap(String str){
        Map<String, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            if ('a' <= chars[i] && chars[i] <= 'z' && 'a' <= chars[i + 1] && chars[i + 1] <= 'z' ){
                sb.append(chars[i]);
                sb.append(chars[i+1]);
                String key = sb.toString();
                map.put(key, map.getOrDefault(key,0) + 1);
                sb.deleteCharAt(0);
                sb.deleteCharAt(0);    
            }
        }
        
        return map;
    }
}