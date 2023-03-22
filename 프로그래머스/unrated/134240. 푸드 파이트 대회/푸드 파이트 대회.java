class Solution {
    public String solution(int[] food) {
        String answer = "";
        String reverse = "";
        for (int i = 1; i < food.length; i++) {
            String nthFood = Integer.toString(i).repeat(food[i] / 2);
            answer = answer + nthFood;
            reverse = nthFood + reverse;
        }
        answer = answer + "0" + reverse;
        
        return answer;
    }
}