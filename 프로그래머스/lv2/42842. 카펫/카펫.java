class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int[] answer = new int[2];
        int index = 0;
        for (int i = 1; i < brown; i++) {
            for (int j = 1; j < brown; j++) {
                if ((2 * i) + (2 * (j - 2)) == brown && i * j == sum) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;
    }
}