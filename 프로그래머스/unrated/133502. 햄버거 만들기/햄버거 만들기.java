class Solution {
    public int solution(int[] ingredient) {        
        if (ingredient.length < 4) return 0;
        StringBuilder sb = new StringBuilder(1_000_000);
        for (int i = 0; i < ingredient.length; i++) {
            sb.append(ingredient[i] + "");
        }
        
        int count = 0;
        for (int i = 3; i < sb.length(); i++) {
            if (isHamburger(sb, i)) {
                sb.delete(i-3, i+1);
                count++;
                i -= 3;
                if (i < 4) {
                    i = 2;
                }
            }
        }
        
        return count;
    }
    
    private boolean isHamburger(StringBuilder sb, int i) {
        return sb.charAt(i-3) == '1'
            && sb.charAt(i-2) == '2'
            && sb.charAt(i-1) == '3'
            && sb.charAt(i) == '1';
    }
}