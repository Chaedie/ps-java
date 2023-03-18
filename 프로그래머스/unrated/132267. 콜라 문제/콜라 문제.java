class Solution {
    // 2병을 갖다주면
    // 1명을 준다
    public int solution(int a, int b, int n) {
        //a병을 갖다주면 
        //b명을 준다.
        //n병을 주면 몇병을 받나?

        int received = 0;
        
        while (true) {
            if (n < a) {
                break;
            }
            n = n - a + b;
            received += b;
        }
        
        return received;
    }
}