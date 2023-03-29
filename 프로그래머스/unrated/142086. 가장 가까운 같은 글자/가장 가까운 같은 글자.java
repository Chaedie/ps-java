class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);

            int sameIndex = -1;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == target) {
                    sameIndex = i-j;
                }
            }
            answer[i] = sameIndex;
        }
        
        return answer;
    }
}