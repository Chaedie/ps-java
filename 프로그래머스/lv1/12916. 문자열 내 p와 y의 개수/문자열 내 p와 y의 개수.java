class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // 루핑하면서 p || P 이면 countP += 1;
        // y
        // 두개 같으면 return true; 다르면 return false;
        char[] chars = s.toCharArray();
        System.out.println(chars);
        
        int countP = 0;
        int countY = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'p' || chars[i] == 'P') {
                countP += 1;
            }
            if (chars[i] == 'y' || chars[i] == 'Y') {
                countY += 1;
            }
        }

        return countP == countY;
    }
}