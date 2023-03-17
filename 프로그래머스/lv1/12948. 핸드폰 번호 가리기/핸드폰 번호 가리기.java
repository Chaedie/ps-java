class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String[] strs = phone_number.split("");
        for (int i = 0; i < strs.length - 4; i++) {
            strs[i] = "*";
        }
        
        return String.join("", strs);
    }
}