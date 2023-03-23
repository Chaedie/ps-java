import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] arr = new int[n];
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = arr1[i] | arr2[i];
            strs[i] = Integer.toString(arr[i], 2);
            strs[i] = strs[i].replaceAll("1", "#");
            strs[i] = strs[i].replaceAll("0", " ");
            int length = strs[i].length();
            int diff = n - length;
            if (diff != 0) {
                strs[i] = " ".repeat(diff) + strs[i];
            }
        }
       
        return strs;
    }
}