import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 키맵을 돌면서 모든 문자에대해 map에 <Character, Integer> <알파벳, 최단거리> 를 다 담는다.
        // 그다음 타겟을 돌면서 각 타겟의 알파벳의 최단거리의 합을 배열에담자
        
        //타겟을 합쳐서 treeset에 담기
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (String key: keymap) {
            for (int i = 0; i< key.length(); i++) {
                char ch = key.charAt(i);
                if (map.getOrDefault(ch, Integer.MAX_VALUE) > i + 1) {
                    map.put(ch, i + 1);
                }
            }
        }
        
        // 타겟돌면서 map값 get
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int result = 0;
            for (char ch : target.toCharArray()) {
                int count = map.getOrDefault(ch, -1);
                if (count == -1) {
                    result = -1;
                    break;
                } else {
                    result += count;
                }
            }
            answer[i] = result;
        }
        
        return answer;
    }
}