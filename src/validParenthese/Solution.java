package validParenthese;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c=='['){
                stack.push(c);
            }else if(c == ')' || c == '}' || c==']'){
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(!match(c, top))return false;
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
    
    public boolean match(char c, char top){
        if(top == '(' && c == ')'){
            return true;
        }
        if(top == '[' && c == ']'){
            return true;
        }
        if(top == '{' && c == '}'){
            return true;
        }
        return false;
    }
}