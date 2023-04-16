import java.text.*;
import java.util.*;

class Solution {
    // 모든 달은 28일까지있음
    // 수집일자로 부터 유효기간 이 지난 다음날 파기해야함
    // 28일, 12월만 잘 처리하면 될듯
    // today 오늘날짜
    // 유효기간 terms
    // privacies 수집된 정보
    // return 파기해야할 개인정보의 번호를 오름차순으로 담기
    public int[] solution(String today, String[] terms, String[] privacies) {
        // privacy 클래스 만들어서
        // 컨스트럭터에 파기되야할 날짜를 넣으면
        Map<String, Integer> termMap = new HashMap<>();
        for (String term: terms) {
            String[] termStrs = term.split(" ");
            termMap.put(termStrs[0], Integer.valueOf(termStrs[1]));
        }
        List<Privacy> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyStrs = privacies[i].split(" ");
            int term = termMap.get(privacyStrs[1]);
            list.add(new Privacy((long)i+1, term, privacyStrs[0], privacyStrs[1]));
        }
        
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String expireDate = list.get(i).expireDate;
            long id = list.get(i).id;
            if (hasExpired(today, expireDate)) {
                answers.add((int) id);
            }
        }

        return answers.stream().mapToInt(i->i).toArray();
    }
    
    private boolean hasExpired(String today, String expireDate) {
        String[] todays = today.split("\\.");
        String[] expires = expireDate.split("\\.");
        
        return setToDays(todays[0], todays[1], todays[2])  
            >= setToDays(expires[0], expires[1], expires[2]);
    }
    
    private long setToDays(String year, String month, String day) {
        long y = Long.valueOf(year) * 28 * 12;
        long m = (Long.valueOf(month) - 1)* 28;
        long d = Long.valueOf(day);
        return y + m + d;
    }
    
    class Privacy {
        public long id;
        public String createdAt;
        public String expireDate;
        public int term;
        public String termName; 
        
        public Privacy (long id, int term, String createdAt, String termName) {
            this.id = id;
            this.term = term;
            this.createdAt = createdAt;
            this.termName = termName;
            this.expireDate = getExpireDate(createdAt, term);
        }
        
        public String getExpireDate(String createdAt, int term) {
            String[] strs = createdAt.split("\\.");
            int month = term + Integer.valueOf(strs[1]);
            // 0x처리 decimalForamt
            int yearCarry = 0;
            while(month >12) {
                yearCarry++;
                month -= 12;
            }
            int year = Integer.valueOf(strs[0]) + yearCarry;
            StringBuilder sb = new StringBuilder();
            sb.append(year);
            sb.append('.');
            DecimalFormat formatter = new DecimalFormat("00");
            String monthStr = formatter.format(month).toString();
            sb.append(monthStr);
            sb.append('.');
            sb.append(strs[2]);
            
            return sb.toString();
        }
    }
}