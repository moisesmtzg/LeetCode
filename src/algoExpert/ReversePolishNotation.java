package algoExpert;

import java.util.Stack;

public class ReversePolishNotation {

    public static int reversePolishNotation(String[] tokens) {
        // Write your code here.
        int size = tokens.length-1;
        if(size == 0) return Integer.parseInt(tokens[0]);

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< tokens.length;i++){
            String token = tokens[i];

            if (token.equals("+")){
                int num1 = stack.pop();
                stack.push(num1+stack.pop());
            } else if(token.equals("-")){
                int num1 = stack.pop();
                stack.push(num1-stack.pop());
            }else if(token.equals("*")){
                int num1 = stack.pop();
                stack.push(num1*stack.pop());
            }else if(token.equals("/")){
                int num1 = stack.pop();
                stack.push(stack.pop()/num1);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        System.out.println(reversePolishNotation(new String[] {"10", "5", "/"}));
    }
}
