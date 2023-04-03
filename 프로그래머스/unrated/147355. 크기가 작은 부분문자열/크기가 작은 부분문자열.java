class Solution {
    public int solution(String t, String p) {
        // 부분 문자열은 for문으로 골라야함
        
        Long longP = Long.valueOf(p);
        int count = 0;
        for (int i = 0; i < t.length() - (p.length() - 1); i++ ){
            String target = t.substring(i, i + p.length());
            Long num = Long.valueOf(target);
            if (num <= longP) { count++; }
        }
        
        return count;
    }
}