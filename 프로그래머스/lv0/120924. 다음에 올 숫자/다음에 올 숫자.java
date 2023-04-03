class Solution {
    
    public int solution(int[] common) {
        //등차 또는 등비
        //등차인지 확인
        boolean isDiff = true;
        int diff = common[1] - common[0];
        for (int i = 1; i < common.length; i++) {
            int preVal = common[i-1];
            int curVal = common[i];
            
            if (curVal - preVal != diff) {
                isDiff = false;
            }
            
        }
        if (isDiff) {
            return common[common.length - 1] + diff;
        }

        return common[common.length - 1] * (common[1] / common[0]);
    }
}