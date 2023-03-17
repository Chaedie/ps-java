import java.util.*;

class Solution {
    public String solution(String s) {
        String[] strs = s.split("");
        Arrays.sort(strs, Collections.reverseOrder());
        return String.join("", strs);
    }
}