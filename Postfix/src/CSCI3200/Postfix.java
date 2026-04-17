//--------------------------------------------------------------
//Group Members: Michael Ojog, Denise Tepei
//Date: April 25, 2026
//Course: Data Structures and Algorithm Analysis (CSCI 3200)
//Project Description: Postfix Calculator using Stacks
//--------------------------------------------------------------

package CSCI3200;
import java.util.Stack;
import java.io.*;

public class Postfix {
    public static void main(String[] args) {
        //create a stack using the Stack class available in the Java API of type Integer with object
        Stack<Integer> stack = new Stack<>();
        PostfixCalculator calculator = new PostfixCalculator();

        //Open, read and evaluate the postfix expressions represented on each line
        //in the file. Separate each token in the expression using a space.
        //For example, 12 1 +

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Postfix_Files.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("Postfix_Answers.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                
                calculator.setPostfixExpression(line);
                boolean valid = calculator.evaluatePostfix(stack);

                if (valid) {
                    int result = stack.pop();
                    writer.write(line + " = " + result);
                } else {
                    writer.write(line + " = invalid expression");
                }

                writer.newLine();

            }

            reader.close();
            writer.close();

        } catch (IOException e) {
            System.out.println("Error handeling file: " + e.getMessage());
        }


        //Write the results of the evaluation to a file by popping and writing the single value in the stack.

    }
}
