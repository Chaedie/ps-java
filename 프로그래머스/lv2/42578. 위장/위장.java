import java.util.*;

class Solution {
    //map에 <종류, 갯수> <String, Integer>로 담는다.
    // 종류를 순회하면서 갯수를 다 곱해주면 경우의수
    // 카운트 + 1 끼리 곱하고, 아무것도 안입는 경우의 수 1을 빼주면 됨
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] strs: clothes) {
            map.put(strs[1], map.getOrDefault(strs[1], 0) + 1);
        }
        
        int answer = 1;
        for (int value : map.values()) {
            answer *= value + 1;
        }
        
        return answer - 1;
    }
}