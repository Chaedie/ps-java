class Solution {
    public int solution(int[] number) {
        int len = number.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}