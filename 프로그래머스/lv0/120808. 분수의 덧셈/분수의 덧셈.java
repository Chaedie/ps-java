class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 분모는 최소 공배수로 만들어주고
        // 분자는 각각 그 최소 공배수를 만들어주는 곱을 곱해서 둘다 더한뒤에         
        // 결과값의 분모와 분자의 최대 공약수를 구해서 나눗셈하면됨
        int gcd = getGCD(denom1, denom2);
        int lcm = (denom1 * denom2) / gcd;
        
        numer1 = (lcm/denom1) * numer1;
        numer2 = (lcm/denom2) * numer2;
        
        int[] result = {numer1 + numer2, lcm};
        
        // 분모 분자의 최대공약수를 구해서 그걸로 둘다 나눠주면됨
        int gcdOfResult = getGCD(result[0], result[1]);
        result[0] /= gcdOfResult;
        result[1] /= gcdOfResult;
        
        return result;
    }
    
    private int getGCD(int a, int b) {
        if (b == 0) { return a;}
        return getGCD(b, a % b);
    }
}