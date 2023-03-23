class Solution {
    private String[] strs = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int solution(String s) {
        for (int i = 0; i < strs.length; i++) {
            s = s.replaceAll(strs[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}