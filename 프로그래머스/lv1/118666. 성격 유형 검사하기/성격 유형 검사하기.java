import java.util.*;

class Solution {
    // AN 1매우 비동의 A3 A2 A1 , N1N2N3
    // 어떤 문항인지 확인
    // 123이면 question.chatAt(0)
    // 한 map에 다넣어서 나중에 가를지
    // 갈라서 게산하고 마지막에 편할지
    
    // 일단 map 하나로 무작정 계산하는게 쉽겟다.
    private Map<Character, Integer> map = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        for (int i = 0; i < survey.length; i++) {
            setMapBySurvey(survey[i], choices[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        setType(sb, 'R', 'T');
        setType(sb, 'C', 'F');
        setType(sb, 'J', 'M');
        setType(sb, 'A', 'N');
        
        return sb.toString();
    }
    
    private void setType(StringBuilder sb, char first, char second) {
         if (map.getOrDefault(first,0) < map.getOrDefault(second,0)) {
            sb.append(second);
        } else {
            sb.append(first);
        }
        
    }
    
    private void setMapBySurvey(String question, int choice) {
        char first = question.charAt(0);
        char second = question.charAt(1);
        if (choice == 1) {
            map.put(first, map.getOrDefault(first,0) + 3);
        } else if (choice == 2) {
            map.put(first, map.getOrDefault(first,0) + 2);
        }else if (choice == 3) {
            map.put(first, map.getOrDefault(first,0) + 1);
        }else if (choice == 5) {
            map.put(second, map.getOrDefault(second,0) + 1);
        }else if (choice == 6) {
            map.put(second, map.getOrDefault(second,0) + 2);
        }else if (choice == 7) {
            map.put(second, map.getOrDefault(second,0) + 3);
        }
    } 
}