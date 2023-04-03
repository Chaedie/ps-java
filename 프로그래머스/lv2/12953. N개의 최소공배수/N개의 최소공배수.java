class Solution {
    public int solution(int[] arr) {
        int gcd = getGCD(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;
        
        for (int i = 2; i < arr.length; i++) {
            gcd = getGCD(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        
        return lcm;
    }
    
    private int getGCD(int a, int b) {
        if (b==0) return a;
        return getGCD(b, a % b);
    }
}