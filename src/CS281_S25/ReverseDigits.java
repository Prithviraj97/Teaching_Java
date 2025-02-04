
public class ReverseDigits {

	public static void main(String[] args) {
		// A Program that will reverse a number and perform operations.
		int number = 12345;
		int origNum = number;
		int reverseDigits = 0;
		int sumDigits = 0;
		
		do {
			int digit = number % 10; //extract the last digit of the number
			reverseDigits = reverseDigits*10 + digit; //append the digit to the reversed digit.
			sumDigits += digit; //add the digit to the sum
			number /= 10; //remove the last digit from the number
		} while(number >0);
		
		System.out.println("Original Num: " + origNum);
		System.out.println("Reversed Num: " + reverseDigits);
		System.out.println("Sum: " + sumDigits);

	}

}
