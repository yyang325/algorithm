package integerToRoman;

public class Solution {
    public String intToRoman(int num) {
        int[] lib = {  1000, 900,  500, 400,  100,  90,  50,   40,  10,   9,    5,   4,   1};
        String[] src = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
        int i = 0;
        StringBuilder sb = new StringBuilder();
        
        while(num > 0 && i < lib.length){
            if(num >= lib[i]){
                sb.append(src[i]);
                num -= lib[i];
            }else{
                i++;
            }
        }
        
        return sb.toString();
    }
}