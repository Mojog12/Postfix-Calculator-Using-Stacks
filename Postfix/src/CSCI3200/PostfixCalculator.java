package CSCI3200;

import java.util.Stack;

public class PostfixCalculator {
    //Declare a String reference variable that contains the postfix expression
    //Note: add encapsulation.

    private String postfixExpression;

    //Define a default constructor. Parameter: none.
    public PostfixCalculator(){
        postfixExpression = "";
    }

    // setters
    public void setPostfixExpression(String postfixExpression){
        this.postfixExpression = postfixExpression;
    }

    // getters
    public String getPostfixExpression(){
        return postfixExpression;
    }

    //Define a method named evaluatePostfix that evaluates the postfix expression
    //entered by the user. Parameter:Stack<Integer>. Return type: boolean

    public boolean evaluatePostfix(Stack<Integer> stack){
        stack.clear();

        String[] tokens = postfixExpression.split(" ");

        for (String token : tokens){

            // if the token is an integer
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
            } 
            // if token is an operator
            else if (token.length() == 1 && isOperator(token.charAt(0))) {
                if (stack.size() < 2) {
                    return false;
                }
                
                int num2 = stack.pop();
                int num1 = stack.pop();

                int result = 0;

                switch (token.charAt(0)) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) return false;
                        result = num1 / num2;
                        break;
                    case '%':
                        if (num2 == 0) return false;
                        result = num1 % num2;
                        break;
                }

                stack.push(result);
            }

            //invalid tokens dun dun dunn
            else {
                return false;
            }
        }

        return stack.size() == 1;
    }

    public String toString(String token){
        return postfixExpression;
    }

    public boolean isInteger(String token){
        
        // is it an integer?
        try{
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isOperator (char operator) {

        // is it an operator? 
        return operator == '+' || operator == '-' ||
               operator == '*' || operator == '/' ||
               operator == '%';

    }

    // while there is more of the expression to read{

    // if (the next input is an integer)

    // Read the next integer and push it onto the stack.

    // else-if(the next input is an operator)

    // {

    //Read the next character, which is an operator.

    // Pop two numbers off the stack.

    // Combine the two numbers with the operator using the
    
    // second number popped as the left operand) and push
    // the result onto the stack.)

    //}

    //else

        // This is an invalid expression

    //}
    
    // At this point, the stack contains one number, which is the result of
    // the expression. Otherwise, it is an invalid expression.

    //Define a toString method that displays the postfix expression stored in the data field.
    // Parameter: non. return type: String.
}