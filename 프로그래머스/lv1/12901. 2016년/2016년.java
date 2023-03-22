class Solution {
    private static final int[] months = {31,29,31,30,31,30,31,31,30,31,30,31};
    
    private static final String[] days= {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    
    private static int getTotalDateByMonths(int month) {
        int sumDateByMonths = 0;
        for (int i = 0; i < month - 1; i++) {
            sumDateByMonths += months[i];
        }
        
        return sumDateByMonths;
    }
    
    public String solution(int a, int b) {
        int sumDate = getTotalDateByMonths(a) + (b - 1); 
        String day = days[(sumDate + 5) % 7];
        
        return day;
    }
}