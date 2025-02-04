package CS281_S25;

public class SumofDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 384;
		int OriginalNum = num;
		int sum = 0;
		
		//use a while loop to calculate the sum of digits
		while(num >0) {
			int digit = num % 10; //get the last digit (remainder of division by 10)
			sum += digit;
			num /= 10;
		}
		System.out.println("The sum of digits of " + OriginalNum + " is: " + sum);
	}
}
