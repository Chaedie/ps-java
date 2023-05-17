import java.util.*;

class Solution {
    public int solution(String s) {
        // 첫문자 x 읽고
        // x와 아닌 횟수가 같아지는 순간 멈추고 분리
        List<String> strs = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            String splitedStr = readAndSplit(i, s);
            strs.add(splitedStr);
            i += splitedStr.length() - 1;
        }
        
        return strs.size();
    }
    
    // 읽고 분리해서, 나머지 문자열을 반환
    private String readAndSplit(int i, String str) {
        StringBuilder sb = new StringBuilder();
        int countX = 0;
        int countY = 0;
        char x = str.charAt(i);
        for (int j = i; j < str.length(); j++) {
            sb.append(str.charAt(j));
            if (str.charAt(j) == x) {
                countX++;
            } else {
                countY++;
            }
            
            if (countX == countY) {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}