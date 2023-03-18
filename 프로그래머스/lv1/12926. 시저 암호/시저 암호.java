import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int code = (int) chars[i];
            if (code >= 65 && code <= 90) {
                chars[i] = (char) (((code - 65 + n) % 26) + 65);
            } else if (code >= 97 && code <= 122) {
                chars[i] = (char) (((code - 97 + n) % 26) + 97);
            }
        }
        
        return String.valueOf(chars);
    }
}