class Solution {
    public int solution(int chicken) {
        // 1치킨 -> 1쿠폰
        // 10쿠폰 -> 1치킨 + 1쿠폰
        int coupon = chicken;
        int service = 0;
        int total = 0;
        while (true) {
            service = coupon / 10;
            if (service == 0) { break; }
            
            coupon = (coupon % 10) + service;
            total += service;
        }
        
        return total;
    }
}