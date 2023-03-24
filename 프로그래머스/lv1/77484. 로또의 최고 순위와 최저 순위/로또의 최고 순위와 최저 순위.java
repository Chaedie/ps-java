class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int countSame = 0;
        int countZero = 0;
        for (int num: lottos) {
            if (num == 0) {
                countZero++;
            } else if (hasSameNumber(win_nums, num)){
                countSame++;
            }
        }

        int[] result = {6,6,5,4,3,2,1};
        int[] answer = {result[countSame + countZero], result[countSame]};
        return answer;
    }
    
    private boolean hasSameNumber(int[] win_nums, int target){
        for (int winNum: win_nums) {
            if (winNum == target) {
                return true;
            }
        }
        return false;
    }
}