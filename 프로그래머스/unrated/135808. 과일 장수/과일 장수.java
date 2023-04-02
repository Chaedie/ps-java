import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        score = reverseSort(score);
        
        int total = 0;
        for (int i = 0; i < (score.length / m); i++) {
            total += getPriceOfBox(score, i, m);
        }
        
        return total;
    }
    
    private int getPriceOfBox(int[] score, int startIndex, int m) {
        int min = Integer.MAX_VALUE; // 최저 점수
        for (int i = startIndex * m; i < startIndex * m + m; i++) {
            min = Math.min(min, score[i]);
        } 
        
        return min * m;
    }
    
    private int[] reverseSort(int[] arr) {
        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedArr[i] = arr[arr.length - 1 - i];
        }
        return sortedArr;
    }
}