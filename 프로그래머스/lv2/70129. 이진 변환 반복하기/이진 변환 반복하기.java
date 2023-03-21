class Solution {
    public int[] solution(String s) {
        int count = 0;
        int i = 0;
        while(!s.equals("1")) {
            int preLen = s.length();
            s = s.replaceAll("[0]","");
            int curLen = s.length();
            count += preLen - curLen;
            i++;
            s = Integer.toString(curLen, 2);
        }
        
        int[] answer = {i, count};
        return answer;
    }
    
}