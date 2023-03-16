class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        System.out.println(s);
        
        long countP = s.chars().filter(x -> x == 'p').count();
        long countY = s.chars().filter(x -> x == 'y').count();

        return countP == countY;
    }
}