class Solution {
    // getharshad , 숫자를 잘라서 더한값을 리턴, 
    // 나머지가 0이면 return true
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = getSumEach(x);
        
        return (x % sum == 0);
    }
    
    private int getSumEach(int num) {
        String[] strs = String.valueOf(num).split("");
        int sum = 0;
        for (String str : strs) {
            sum += Integer.parseInt(str);
        }
        
        return sum;
    }
}