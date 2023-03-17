class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            int[] answer = {-1};
            return answer;
        }
        
        int min = getMinOfArray(arr);
        
        int[] answer = new int[arr.length - 1];
        int j = 0;
        boolean hasNotMeet = true;
        for (int i = 0; i < arr.length; i++) {
            if (hasNotMeet && arr[i] == min) {
                hasNotMeet = false;
                continue;
            }
            
            answer[j++] = arr[i];
        }
        
        return answer;
    }
    
    private int getMinOfArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        
        return min;
    }
}