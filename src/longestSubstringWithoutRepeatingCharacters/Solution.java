package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        
        if(s == null || s.length() < 1) return 0;
        
        while(right < s.length()){
            if(set.contains(s.charAt(right))){
                char repeat = s.charAt(right);
                while(left < right){
                    if(s.charAt(left) != repeat){
                        set.remove(s.charAt(left));
                        left++;
                    }else{
                        left++;
                        break;
                    }
                }
            }else{
                set.add(s.charAt(right));
            }
            
            max = Math.max(max, right-left+1);
            right++;
        }
        
        return max;
    }
}