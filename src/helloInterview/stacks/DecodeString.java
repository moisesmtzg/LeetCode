package helloInterview.stacks;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s){
        Stack<String> stack = new Stack<>();
        String aux = "";
        String num = "";
        for(char c : s.toCharArray()){
            if(c != ']'){
                stack.add(String.valueOf(c));
            }else{
                aux = "";
                while(!stack.isEmpty() && !stack.peek().equals("[")){
                    aux = stack.pop()+aux;
                }
                stack.pop();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    num = stack.pop()+num;
                }
                aux = aux.repeat(Integer.parseInt(num));
                num = "";
                stack.add(aux);
            }
        }
        aux = "";
        while(!stack.empty()){
            aux = stack.pop() + aux;
        }
        return aux;
    }
    public static void main(String[] args){
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
