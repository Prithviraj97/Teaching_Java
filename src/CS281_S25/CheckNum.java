package CS281_S25;

public class CheckNum {
    public static void main(String[] args) {
        int num = -5;
        //using nested ternary operator to check if the number is positive, negative or zero
        String result = (num > 0) ? "Positive" : (num < 0) ? "Negative" : "Zero";
        System.out.println("The number is: "+result);
    }
    
}
