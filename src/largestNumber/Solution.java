package largestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String largestNumber(int[] nums) {
    	List<Integer> list = new ArrayList<>();
    	for(int i : nums)
    		list.add(i);
    	
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                String s12 = s1+s2;
                String s21 = s2+s1;
                for(int i = 0; i < s12.length();i++){
                    if(s12.charAt(i) > s21.charAt(i)) return -1;
                    if(s12.charAt(i) < s21.charAt(i)) return 1;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size() ;i++){
            sb.append(String.valueOf(list.get(i)));
        }
        return sb.toString();
    }
}