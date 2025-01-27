package CS281_S25;

public class minOfTwo {
    public static void main(String[] args) {
        /*
         * The conditional operator is also known as the ternary operator.
         * It is used to evaluate boolean expressions and assign the value based on the result.
         * Syntax: (condition) ? valueIfTrue : valueIfFalse
         */
        int a = 10;
        int b = 20;
        int min = (a < b) ? a : b;
        System.out.println("The minimum of the two numbers is: "+min);
    }
    
}
