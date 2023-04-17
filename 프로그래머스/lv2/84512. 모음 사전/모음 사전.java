import java.util.*;

class Solution {
    // a aa aaa aaaa aaaaa
    // aeiou
    private String[] dict = {"A", "E", "I", "O", "U"};
    private List<String> list = new ArrayList<>();
    
    public int solution(String word) {    
        
        dfs(0, "");
        
        return list.indexOf(word);
    }
    private void dfs(int depth, String str) {
        if (depth == 6) return;
        
        list.add(str);
        for (int i = 0; i < dict.length; i++) {
            dfs(depth + 1, str + dict[i]);
        }
    }
}