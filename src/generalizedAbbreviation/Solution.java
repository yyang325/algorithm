package generalizedAbbreviation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if(word == null || word.length() < 1) return res;
        
        for(int i = 0; i < word.length(); i++){
            if(i == 0) {
                res.add(String.valueOf(word.charAt(0)));
                res.add("1");
                continue;
            }
            int size = res.size();
            for(int j = 0; j < size; j++){
                String temp = res.get(j);
                StringBuilder sb = new StringBuilder(temp);
                sb.append(word.charAt(i));
                res.set(j, sb.toString());
            }
            
            for(int j = 0; j < size; j++){
                String temp = res.get(j).substring(0, res.get(j).length()-1);
                int[] count = new int[1];
                String removed = removeInteger(temp, count);
                StringBuilder sb = new StringBuilder();
                sb.append(removed).append(count[0]);
                res.add(sb.toString());
            }
        }
        
        return res;
    }
    
    public String removeInteger(String s, int[] count){
        StringBuilder sb = new StringBuilder();
        int index = s.length() -1;
        while(index >= 0 && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            sb.append(s.charAt(index));
            index--;
        }
        count[0] = sb.toString().length() > 0 ? Integer.parseInt(sb.toString())+1 : 1;
        return s.substring(0, index+1);
    }
    
    public static void main(String[] a){
    	Solution f = new Solution();
    	List<String> list = f.generateAbbreviations("word");
    	list.forEach(s -> System.out.println(s));
    }
}