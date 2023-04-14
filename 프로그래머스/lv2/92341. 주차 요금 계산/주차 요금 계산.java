import java.util.*;

class Solution {
    // 입차 후 출차 없으면 23:59 출차
    // 누적 주차 시간을 구해야함
        // 기본 시간 이하면 기본 요금
        // 기본 초과면 기본 요금 + (단위 시간 * 단위요금) (올림))
    // fees = [기본시간, 기본 요금, 단위시간, 단위 요금]
    // records = "시각 차량번호 내역"
    // 시각은 HH:MM
    // 차량번호는 0~9인 4자리
    // 내역은 IN OUT
    
    // <차량번호, IN Time>
    private Map<String, String> inOutMap = new HashMap<>();
    // <차량번호, 누적 시간>
    private Map<String, Integer> timeMap = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        for (String recString : records) {
            String[] record = recString.split(" "); 
            String time = record[0];
            String carNum = record[1];
            String type = record[2];
            
            if (type.equals("IN")) {
                inOutMap.put(carNum, time);
            } else {
                outCar(time, carNum);
                inOutMap.remove(carNum);    
            }
        }

        for (String carNum: inOutMap.keySet()){
            outCar("23:59", carNum);
        }
        
        List<String> cars = new ArrayList<>();
        for (String carNum : timeMap.keySet()) {
            cars.add(carNum);
        }
        Collections.sort(cars);
        
        // fee 계산
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int accTime = timeMap.get(cars.get(i));
            answer[i] = calculateParkingFee(accTime, fees);
        }
        
        return answer;
    }
 
    // fees = [기본시간, 기본 요금, 단위시간, 단위 요금]   
    private int calculateParkingFee(int accTime, int[] fees) {
        int fee;
        if (accTime <= fees[0]) {
            fee = fees[1];
        } else {
            fee = fees[1] + ((int) Math.ceil((double)(accTime - fees[0]) / fees[2])) * fees[3];
        }
        
        return fee;
    }
    
    private void outCar(String time, String carNum) {
        String inTime = inOutMap.get(carNum);
        int accTime = formatTime(time) - formatTime(inTime);
        timeMap.put(carNum, timeMap.getOrDefault(carNum,0) + accTime);
    }
    
    private int formatTime(String time) {
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60 
                        + Integer.parseInt(time.substring(3, 5));
        return minutes;
    }
    
}