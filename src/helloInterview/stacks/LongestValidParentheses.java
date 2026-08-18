package helloInterview.stacks;

import java.util.Stack;

public class LongestValidParentheses {
    public static int longest_valid_parentehses(String s){
        if (s.isEmpty())return 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int max = 0;
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == ')'){
                stack.pop();
                if(stack.isEmpty()){
                    stack.add(i);
                }
                max = Math.max(max, i-stack.peek());
            }else{
                stack.add(i);
            }
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(longest_valid_parentehses("())))"));
    }
}
