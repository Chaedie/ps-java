import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        // 알파벳 스트링 만들어서
        // skip에있는 것들 하나씩 공백으로 replaceAll
        // s를 순회하면서 s의 인덱스를 찾고, (indexOf)
        // 그 인덱스에서 index만큼 더해서 length 만큼 모듈러
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] skips = skip.split("");
        for (String str: skips) {
            alphabet = alphabet.replaceAll(str, "");
        }
        
        String[] strs = s.split("");
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            int curPos = alphabet.indexOf(str);
            curPos = (curPos + index) % alphabet.length();
            sb.append(alphabet.charAt(curPos));
        }
        
        return new String(sb);
    }
}