package Stack;

import java.util.Objects;
import java.util.Stack;

public class ReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        // put the first two number into stack
        stack.push(Integer.parseInt(tokens[0]));
        stack.push(Integer.parseInt(tokens[1]));
        // pop once : take rightHandSide,
        int right = 0;
        // pop twice: take leftHandSide
        int left = 0;
        for(int i  = 2; i < tokens.length;i++){

            if(Objects.equals(tokens[i], "+")){

               if(stack.size() >= 2){
                   right = stack.pop();
                   left = stack.pop();
               }
               stack.push(left + right);
            }

            else if(Objects.equals(tokens[i], "-")){

               if(stack.size() >= 2){
                right = stack.pop();
                left =  stack.pop();
               }
               stack.push(left - right);
            }

           else if(Objects.equals(tokens[i], "*")){

                if(stack.size() >= 2) {
                    right = stack.pop();
                    left = stack.pop();
                }
                stack.push(left * right);
           }

            else if(Objects.equals(tokens[i], "/")){

                if(stack.size() >= 2) {
                    right = stack.pop();
                    left = stack.pop();
                }
                stack.push(left / right);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        ReversePolishNotation_150 test = new ReversePolishNotation_150();

        System.out.println(test.evalRPN(tokens));
    }
}
