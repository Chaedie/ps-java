class Solution {
    // 앞뒤에게만 빌려줄수있음 
    // int[] ={0,0,0,0...}; 만들어서 일단 다 있게 만듬
    // lost에 해당하는 애들은 --;
    // reserve에 해당하는 친구들은 ++;
    // 순회하면서 0인경우 앞이나 뒤에 2가있음 걔 -- 나 ++
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n];
        
        for (int lostIndex : lost) arr[lostIndex-1]--;
        for (int reserveIndex : reserve) arr[reserveIndex-1]++;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                if (i > 0 && arr[i-1] == 1) {
                    arr[i-1]--;
                    arr[i]++;
                } else if (i < n-1 && arr[i+1] == 1) {
                    arr[i+1]--;
                    arr[i]++;
                }
            }
        }
        
        int count = 0;
        for (int num: arr) {
            if (num >= 0) count++;
        }
        
        return count;
    }
}