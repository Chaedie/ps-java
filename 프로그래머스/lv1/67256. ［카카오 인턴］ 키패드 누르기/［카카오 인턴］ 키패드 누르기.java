import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    
    public String solution(int[] numbers, String hand) {
        Hand left = new Hand('L');
        Hand right = new Hand('R');
       
        for (int num : numbers) {
            if (isLeftSide(num)) { 
                hitKeypad('L', left, num);
                continue;
            } 
            
            if (isRightSide(num)) {
                hitKeypad('R', right, num);
                continue;
            } 
            
            int distance = left.getDistance(num) - right.getDistance(num);
            
            if (distance > 0) {
                hitKeypad('R', right, num);
            } else if (distance < 0) {
                hitKeypad('L', left, num);
            } else {
                if (hand.equals("left")) {
                    hitKeypad('L', left, num);
                } else {
                    hitKeypad('R', right, num);
                }
            }
        }        

        return sb.toString();
    }
    
    private boolean isLeftSide(int num) {
        if (num == 1 || num == 4 || num == 7) {
            return true;
        }
        return false;
    }

    private boolean isRightSide(int num) {
        if (num == 3 || num == 6 || num == 9) {
            return true;
        }
        return false;
    }

    
    public void hitKeypad(Character target, Hand hand, int num) {
        sb.append(target);
        hand.setCurrent(num);
    }
    
    public static int[][] positions = new int[][]{
        new int[]{3,1},
        new int[]{0,0},new int[]{0,1},new int[]{0,2},
        new int[]{1,0},new int[]{1,1},new int[]{1,2},
        new int[]{2,0},new int[]{2,1},new int[]{2,2},
        new int[]{3,0},new int[]{3,1},new int[]{3,2}
    };

    class Hand {
        public Character hand;
        public int curI;
        public int curJ;
        
        public Hand(Character hand) {
            this.hand = hand;
            if (hand == 'L') {
                curI = 3;
                curJ = 2;
            } else {
                curI = 3;
                curJ = 0;        
            }
        }
        
        public void setCurrent(int num) {
            this.curI = positions[num][0];
            this.curJ = positions[num][1];
        }
        
        public int getDistance(int num) {
            int left = Math.abs(this.curI - positions[num][0]);
            int right = Math.abs(this.curJ - positions[num][1]);
            return left + right;
        }
    }
}