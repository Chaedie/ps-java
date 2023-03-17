class Solution {
    public int solution(long num) {
        if (num == 0) { return 0; }
        if (num == 1) { return 0; }
        
        int i = 0;
        while(true) {
            i++;
            num = num % 2 == 0 ? num / 2 : (num * 3) + 1;
            
            if (num == 1) {
                return i;
            }
            if (i == 500) {
                return -1;
            }
        }
    }
}