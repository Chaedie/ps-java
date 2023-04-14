import java.util.*;

class Solution {
    // Map에 <name, yearning>으로 담고
    // photo 순회하면서 합산하기
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        for (int j = 0; j < photo.length; j++) {
            String[] people = photo[j];
            int total = 0;
            for (int i = 0; i < people.length; i++) {
                total += map.getOrDefault(people[i], 0);
            }    
            answer[j] = total;
        }
        
        return answer;
    }
}