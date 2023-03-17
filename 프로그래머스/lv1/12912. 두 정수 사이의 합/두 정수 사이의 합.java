class Solution {
    public long solution(long a, long b) {
        if (a == b) {
            return a;
        } else if (a < b) {
            return getSumFromTo(a,b);
        } 
        
        return getSumFromTo(b,a);
    }
    
    private long getSumFromTo(long smaller, long bigger) {
        long sum = 0;
        for (long i = smaller; i <= bigger; i++) {
            sum += i;
        }
        return sum;
    }
}