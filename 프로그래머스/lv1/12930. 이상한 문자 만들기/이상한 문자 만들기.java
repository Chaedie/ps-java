class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strs = s.split("");
        
        int idx = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(" ")) {
                idx = 0;
            } else {
                if (idx % 2 == 0) {
                    strs[i] = strs[i].toUpperCase();
                } else {
                    strs[i] = strs[i].toLowerCase();
                }
                idx++;
            }
        }
        
        return String.join("", strs);
        
        
    };
}