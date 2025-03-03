package CS281_S25;
import javax.swing.JOptionPane;

public class SimpleCalculaor {
    public static void main(String[] args) {
        // Display a welcome message
        JOptionPane.showMessageDialog(null, "Welcome to Simple Calculator", "Simple Calculator", JOptionPane.INFORMATION_MESSAGE);
        String firstnumber = JOptionPane.showInputDialog(null, "Enter the first number:");
        String secondnumber = JOptionPane.showInputDialog(null, "Enter the second number:");

        double num1 = Double.parseDouble(firstnumber);
        double num2 = Double.parseDouble(secondnumber);

        String[] options = {"+", "-", "*", "/"}; // Array of options for the user to choose from
        int selection = JOptionPane.showOptionDialog(null, "Select an operation to perform", "Simple Calculator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        String choice = options[selection];

        double result = 0;
        switch (choice) {
            case "+":
                result = num1 + num2;
                JOptionPane.showMessageDialog(null, "The sum of " + num1 + " and " + num2 + " is " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
        }
    }

}
