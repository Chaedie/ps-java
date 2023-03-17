import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int sum = Arrays.stream(numbers).reduce((x,y) -> x + y).getAsInt();
        int total = 45;
        return (total - sum);
    }
}