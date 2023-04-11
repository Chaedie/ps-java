import java.util.*;

class Solution {
    // 최소로 만들기 위해선 평균을 향해 내려보내야한다. 
    // 일단 다 더해서 n을 뺴면?
    // 4 + 3 + 3 - 4 = 6이 나옴, 이걸 works.length로 나누고, 
    // works.length 나머지를 하나씩 더해주고, works에 뿌림
    
    // 근데 만약 100, 0,0 이면?
    
    // 우선순위 큐에 넣어서, 가장 큰수를 n만큼 돌리면서 -1 해주면 평탄해지겠는데?
    
    public long solution(int n, int[] works) {
        Integer[] worksBox = Arrays.stream(works).boxed().toArray(Integer[]::new);
        Arrays.sort(worksBox, Collections.reverseOrder());
        
        // 젤 첨꺼 --하고
        // 반복 : 그담게 첨거보다 크면 그담거 --하고
        int i = 0;
        while(n > 0) {
            worksBox[i]--;
            n--;
            while (n > 0 && i+1 < worksBox.length && worksBox[i] < worksBox[i+1]) {
                i++;
                worksBox[i]--;
                n--;
            }
            i = 0;
        }
        
        return getSquredTotalOfWorks(worksBox);
    }
    
    private long getSquredTotalOfWorks(Integer[] worksBox) {
        long total = 0;
        for (int num: worksBox) {
            if (num <= 0) continue;
            total += num * num;
        }
        return total;
    }
}