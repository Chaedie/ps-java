import java.util.*;

class Solution {
    public int solution(int n) {
        String ternary = Integer.toString(n, 3); 
        String reverseTernary = new StringBuilder(ternary).reverse().toString();
        
        return Integer.parseInt(reverseTernary, 3);
    }
}