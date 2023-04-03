class Solution {
    // 슬라이딩 윈도우
    public int[] solution(int num, int total) {
        
        int left = 1;
        int right = num;
        int sum = ((right + 1) * (right)) / 2;
        while (true) {
            if (sum == total) {
                break;
            } else if (sum < total) {
                sum -= left;
                left++;
                right++;
                sum += right;
            } else {
                sum-= right;
                right--;
                left--;
                sum+=left;
            }
        }
        
        int[] answer = new int[num];
        for (int i = 0; i < num; i++) {
            answer[i] = left++;
        }
        return answer;
    }
}