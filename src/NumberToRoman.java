import javax.swing.JOptionPane;

public class NumberToRoman {
    public static void main(String[] args) {
        // Prompt the user to enter a number between 1 and 3999
        String input = JOptionPane.showInputDialog("Enter a number between 1 and 3999:");
        int number = Integer.parseInt(input);

        // Check if the number is within the valid range
        if (number < 1 || number > 3999) {
            JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 3999.");
        } else {
            String roman = convertToRoman(number);
            JOptionPane.showMessageDialog(null, "The Roman numeral for " + number + " is: " + roman);
        }
    }

    // Method to convert the number to Roman numeral
    public static String convertToRoman(int number) {
        StringBuilder roman = new StringBuilder();

        while (number >= 1000) {
            roman.append("M");
            number -= 1000;
        }
        
        // Hundreds place
        if (number >= 900) {
            roman.append("CM");
            number -= 900;
        } else if (number >= 500) {
            roman.append("D");
            number -= 500;
        } else if (number >= 400) {
            roman.append("CD");
            number -= 400;
        } else if (number >= 100) {
            while (number >= 100) {
                roman.append("C");
                number -= 100;
            }
        }

        // Tens place
        if (number >= 90) {
            roman.append("XC");
            number -= 90;
        } else if (number >= 50) {
            roman.append("L");
            number -= 50;
        } else if (number >= 40) {
            roman.append("XL");
            number -= 40;
        } else if (number >= 10) {
            while (number >= 10) {
                roman.append("X");
                number -= 10;
            }
        }

        // Units place
        if (number == 9) {
            roman.append("IX");
        } else if (number >= 5) {
            roman.append("V");
            number -= 5;
        } else if (number == 4) {
            roman.append("IV");
        } else {
            while (number >= 1) {
                roman.append("I");
                number -= 1;
            }
        }

        return roman.toString();
    }
}
