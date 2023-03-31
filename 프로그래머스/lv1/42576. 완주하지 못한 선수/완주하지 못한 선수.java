import java.util.*;

class Solution {
     public String solution(String[] participant, String[] completion) {
        // map 두개 만들어서
        // 두개 비교하면서 count값 다르면 그놈 return

        Map<String, Integer> partMap = new HashMap<>();

        for (String name : participant) {
            Integer count = partMap.getOrDefault(name, 0);
            partMap.put(name, count + 1);
        }
        for (String name : completion) {
            Integer count = partMap.getOrDefault(name, 0);
            partMap.put(name, count - 1);
        }

        for (String name : participant) {
            if (partMap.get(name) != 0) {
                return name;
            }
        }

        return "";
    }
}

// public String solution(String[] participant, String[] completion) {
//     // 두 배열 정렬함  
//     // 정렬했는데 순회하다가 두개가 다른값이 나오면 그 값 리턴

//     Arrays.sort(participant);
//     Arrays.sort(completion);
//     for (int i = 0; i < participant.length-1; i++) {
//         if (!participant[i].equals(completion[i])) {
//             return participant[i];
//         }
//     }

//     return participant[participant.length - 1];
// }