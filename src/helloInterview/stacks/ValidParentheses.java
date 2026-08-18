package helloInterview.stacks;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
               stack.add(c);
            }else{
                if(     stack.empty() ||
                        (c == ')' && stack.pop() != '(') ||
                        (c == ']' && stack.pop() != '[') ||
                        (c == '}' && stack.pop() != '{')
                    ){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        System.out.println(isValid("}()"));
    }
}
