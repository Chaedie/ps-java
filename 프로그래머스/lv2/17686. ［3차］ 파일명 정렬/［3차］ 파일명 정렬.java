import java.util.*;

class Solution {
    // head, number, tail을 나눠야한다.
    // head 는 "^[a-zA-Z]"
    //숫자가 무조건 있음
    //숫자가 있는 부분을 순회로 찾아서, 그 앞까지 substring해서 head
    // 거기부터 숫자 아닌부분까지 찾아서 substring해서 number
    // 그 뒤는 tail
    
    // head는 사전순 정렬 (대소문자 구분 안함)
    // number 는 넘버순 정렬
    // had, number같으면 files입력순 (id)
    
    //class Comparable로 짜자..
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(new File(i, files[i]));
        }
        Collections.sort(list);

        return list.stream().map(x->x.fileName).toArray(String[]::new);
    }
    
    class File implements Comparable<File> {
        public int id;
        public String fileName;
        public String head;
        public String numberString;
        public long numberLong;
        private int numberStartIndex;
        private int numberEndIndex;
        
        public File (int id, String fileName) {
            this.id = id;
            this.fileName = fileName;
            getNumberIndex();
            this.head = fileName.toLowerCase().substring(0,numberStartIndex);
            this.numberString = fileName.substring(numberStartIndex,numberEndIndex);
            this.numberLong = Long.valueOf(numberString);
        }
        
        private void getNumberIndex() {
            for (int i = 0; i < fileName.length(); i++) {
                if (Character.isDigit(fileName.charAt(i))) {
                    this.numberStartIndex = i;
                    break;
                }
            }
            this.numberEndIndex = fileName.length();
            for (int i = numberStartIndex; i < fileName.length(); i++) {
                if (!Character.isDigit(fileName.charAt(i))) {
                    this.numberEndIndex = i;
                    return;
                }
            }
        }
        
        @Override
        public int compareTo(File file) {
            if (this.head.equals(file.head)) {
                if (this.numberLong== file.numberLong) {
                    return this.id - file.id;
                }
                return (int) (this.numberLong - file.numberLong);
            } 
            
            return this.head.compareTo(file.head);
        }
    }
}