class Solution {

    private static int count = 0;
    
    private static int[] numbersArr;
    
    private void dfs(int index, int target, int sum) {
        if (index == numbersArr.length) {
            if (sum == target) {
                count++;
            }
        } else {
            dfs(index + 1, target, sum + numbersArr[index]);
            dfs(index + 1, target, sum - numbersArr[index]);
        }
    }
    
    public int solution(int[] numbers, int target) {
        numbersArr = numbers;
        dfs(0, target, 0);
        
        return count;
    }
}