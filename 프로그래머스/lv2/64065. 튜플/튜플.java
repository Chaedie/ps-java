import java.util.*;

class Solution {
    public int[] solution(String s) {
        //다시
        // 빈도수 높은 순서대로란다. 
        // map으로 카운트하고
        // 밸류 기준으로 정렬하면 되겟네
        // 정렬할것도 없고, keySet().length()인것부터 마이너스로 순회하면서 순서대로 담으면됨
        // 그러려면 map두개만들어서 <숫자, 빈도수> <빈도수, 숫자> 이렇게 두개 만들어서 반대로 사용하면됨
        
        s = s.replaceAll("\\}", "");
        s = s.replaceAll("\\{", "");
        String[] strs = s.split(",");
        
        // number - count 맵 만들기
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (String str: strs) {
            Integer num = Integer.valueOf(str);
            numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
        }
        
        // count - number 맵 만들기
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: numberMap.entrySet()) {
            int key =  entry.getKey();
            int value = numberMap.get(key);
            countMap.put(value, key);
        }
        
        int len = countMap.size();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = countMap.get(len - i);
        }
        
        return answer;
    }
}