import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        // 상하좌우로 이동 가능
        // 147은 왼속
        // 369는 오른손
        // 2580은 두 엄지중 가까운거
            // 두 엄지가 같다면 오른손 잡이는 오른손, 왼손잡이는 왼손
        
        // 현재 왼손이 어딘지, 현재 오른손이 어딘지 알아야됨
        // answers.add() 해준다음 현재 위치도 세팅해줘야됨
        // 현재위치는 어떤식으로 세팅할까?
        // 0,0 0,1 0,2
        // 1,0 1,1 1,2
        // 2,0 2,1 2,2
        //     3,1
        // 이렇게 해두고 그럼 비교는 어케함 ? 뭐가 가까운지? 
        // 직선거리의 제곱인 (x1 - x2)**2 + (y1-y2) **2 로 하면 될듯
        
        // 1 2 3
        // 4 5 6
        // 7 8 9
        //   9
        
        StringBuilder sb = new StringBuilder();
        Hand left = new Hand('L');
        Hand right = new Hand('R');
        
        System.out.println(Arrays.toString(numbers));
        for (int num : numbers) {
            System.out.println(num);
            
            if (num == 1 || num == 4 || num == 7) {
                sb.append('L');
                left.setCurrent( num);
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append('R');
                right.setCurrent(num);
            } else {
                if (left.getDistance(num) < right.getDistance(num)) {
                    sb.append('L');
                    left.setCurrent(num);
                } else {
                    sb.append('R');
                    right.setCurrent(num);
                }
            }
        }        

        return sb.toString();
    }

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
        
        public static int[][] positions = new int[]{
            new int[]{3,1},
            new int[]{0,0},new int[]{0,1},new int[]{0,2},
            new int[]{1,0},new int[]{1,1},new int[]{1,2},
            new int[]{2,0},new int[]{2,1},new int[]{2,2},
            new int[]{3,0},new int[]{3,1},new int[]{3,2}
        };
        
        public void setCurrent(int num) {
            this.curI = Hand.positions[num][0];
            this.curJ = Hand.positions[num][1];
        }
        
        public int getDistance(int num) {
            int left = (int) Math.pow(this.curI - Hand.positions[num][0], 2);
            int right = (int) Math.pow(this.curJ - Hand.positions[num][1], 2);
            return left + right;
        }
    }
}