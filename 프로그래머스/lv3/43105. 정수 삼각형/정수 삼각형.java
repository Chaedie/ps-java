class Solution {
    public int solution(int[][] triangle) {
        // 순회하면서
        // 본인 밸류 = Math.max((왼쪽 부모 밸류 + 본인 밸류), (오른쪽 부모 밸류 + 본인 밸류))
        // 로 다 세팅하면 될듯
        // 그담 마지막 배열의 값중 최대값을 return
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if (j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);    
                }
            }
        }
        
        return getMax(triangle[triangle.length-1]);
    }
    
    private int getMax(int[] arr) {
        int max = 0;
        for (int num: arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}