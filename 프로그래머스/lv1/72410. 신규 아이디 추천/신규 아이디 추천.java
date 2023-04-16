class Solution {
    public String solution(String new_id) {
        String id = new_id.toLowerCase();
        id = id.replaceAll("[^a-z0-9\\-_\\.]", "");
        id = id.replaceAll("\\.{1,}",".");
        id = id.replaceAll("^\\.","");
        id = id.replaceAll("\\.$","");
        if (id.equals("")) id = "a";
        if (id.length() >= 16) id = id.substring(0,15);
        id = id.replaceAll("\\.$","");
        
        while (id.length() <=2) {
            id += id.charAt(id.length() - 1);
        }
        
        return id;
    }
}