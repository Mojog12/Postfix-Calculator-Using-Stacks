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

    

    //Define a method named evaluatePostfix that evaluates the postfix expression
    //entered by the user. Parameter:Stack<Integer>. Return type: boolean

    public boolean evaluatePostfix(Stack<Integer> stack){
        stack.clear();

        String[] tokens = postfixExpression.split(" ");

        //While there is more of the expression to read{
        for (String token : tokens){
            
            // if (the next input is an integer)
            if (isInteger(token)) {
                //Read the next integer and push it onto the stack.
                stack.push(Integer.parseInt(token));
            } 
            // else-if (the next input is an operator)
            else if (token.length() == 1 && isOperator(token.charAt(0))) {
                //Pop two numbers off the stack
                if (stack.size() < 2) {
                    return false;
                }
                
                int num2 = stack.pop();
                int num1 = stack.pop();

                int result = 0;
                //Combine the two numbers with the operator using the
                //second number popped as the left operand and push
                //the result onto the stack.
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

            //else
            else {
                //This is an invalid expression
                return false;
            }
        }
        //At this point, the stack contains one number, which is the result of the expression
        //Otherwise, it is an invalid expression.
        return stack.size() == 1;
    }

    //Define a toString method that displays the postfix expression stored in the
    //data field. Parameter: none. Return type: String
    public String toString(String token){
        return postfixExpression;
    }

    //Define a method named isInteger that determines if the next token is an
    //integer. Parameter: String, return type: boolean.
    public boolean isInteger(String token){
        
        // is it an integer?
        try{
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Define a method named isOperator that determines if the next token is an operator. 
    //The operator list: +, -, *, %, and /. Parameter: character, return type: boolean.
    public boolean isOperator (char operator) {

        // is it an operator? 
        return operator == '+' || operator == '-' ||
               operator == '*' || operator == '/' ||
               operator == '%';

    }
    
    //Define the accessor (getter) and mutator (setter) methods for the data field variable.
    // setters
    public void setPostfixExpression(String postfixExpression){
        this.postfixExpression = postfixExpression;
    }

    // getters
    public String getPostfixExpression(){
        return postfixExpression;
    }

}