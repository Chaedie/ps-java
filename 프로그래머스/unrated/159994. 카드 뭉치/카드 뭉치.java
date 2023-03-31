class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 투포인터
        // goal을 순회하면서
        // i j 중 goal의 값이랑 맞는게 있으면 i++ || j++ 해주고 goal index 넘김
        // 안되면 return false
        // 끝까지 가면 return true
        int p1 = 0;
        int p2 = 0;
        for (String word : goal) {
            if (p1 < cards1.length && cards1[p1].equals(word)) {
                p1++;
                continue;
            }
            if (p2 < cards2.length && cards2[p2].equals(word)) {
                p2++;
                continue;
            }
            return "No";
        }

        return "Yes";
    }
}