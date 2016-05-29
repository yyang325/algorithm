package shortestWordDistance3;

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        Integer i1 = null, i2 = null;
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                i1 = i;
            }
            if(words[i].equals(word2)){
                if(word1.equals(word2)){
                    i1 = i2;
                }
                i2 = i;
            }
            if(i1 != null && i2 != null){
                min = Math.min(min, Math.abs(i1-i2));
            }
        }
        return min;
    }
}