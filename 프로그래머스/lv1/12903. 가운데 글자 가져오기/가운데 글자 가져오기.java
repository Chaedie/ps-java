class Solution {
    public String solution(String s) {
        String[] strs = s.split("");
        if (strs.length % 2 == 0) {
            return strs[(strs.length /2) - 1] + strs[strs.length / 2];
        }
        return strs[strs.length / 2];
    }
}