class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        for (String tree: skill_trees) {
            tree = tree.replaceAll("[^"+skill+"]", "");
            if (checkTree(tree, skill)){
                count++;
            }
        }
        return count;
    }
    
    private boolean checkTree(String tree, String skill) {
        int index = 0;
        for (int i = 0; i < tree.length(); i++) {
            if (tree.charAt(i) != skill.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}