class Solution {
    public long solution(long price, long money, long count) {
        for (long i = 0; i < count; i++) {
            money -= price * (i + 1);
        }
        if (money >= 0) {
            return 0;
        }
        return -money;
    }
}