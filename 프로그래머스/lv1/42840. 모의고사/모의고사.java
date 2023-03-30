import java.util.*;

class Solution {
    
    public int[] solution(int[] answers) {
        int[] order = {0,0,0};
        
        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % 5]){
                order[0] += 1;
            }
            if (answers[i] == second[i % 8]){
                order[1] += 1;
            }
            if (answers[i] == third[i % 10]){
                order[2] += 1;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int[] answer = {};
        int max = Math.max(Math.max(order[0], order[1]), order[2]);
        for (int i = 0; i < order.length; i++) {
            if (order[i] == max) {
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
    
    private int[] first = {1,2,3,4,5};
    private int[] second = {2,1,2,3,2,4,2,5};
    private int[] third = {3,3,1,1,2,2,4,4,5,5};
}