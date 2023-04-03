class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGcd(n,m);
        int lcm = (n * m) / gcd;
        int[] answer = {gcd, lcm};
        return answer;
    }
    
    private int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}