class Solution {
    public int[] solution(int n, int s) {
        // 각 원소의 합이 s
        // 그런 집합중 원소의 곱이 최대
        
        // 합이 s가되는 자연수들을 찾아야됨
        // 근데 그 숫자들이 곱이 최대가 되기 위해선 중간값을 가져야함
        // 따라서, 연속된 숫자를 찾는게 베스트임 또는 중복만으로 이루어진게 제일 좋고
        
        // 뭔가 111부터 각각 1씩 더해서 합을 만드는게 맞아보이네
        // 그럼 s/n 을 base number로 해서 +1+1+1for문돌려보는게 맞을듯
        // s/n이 0이면 -1이고?
        
        if (s / n == 0) {
            return new int[]{-1};  
        } 
        
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = s / n;
        }

        for (int i = 0; i < (s % n); i++) {
            answer[answer.length - 1 - i] += 1;
        }
        
        return answer;
    }
}