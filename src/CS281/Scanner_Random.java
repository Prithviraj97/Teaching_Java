package CS281;
import java.util.Random;
import java.util.Scanner;

public class Scanner_Random {

	public static void main(String[] args) { 
		
	Scanner keyBoardScanner = new Scanner(System.in);
	
	//Here we are initializing our variables and asking for user input through a prompt
	
	System.out.print("Using a minimum value, enter your desired range using the lowest possible value for the range.\n"
			+ "Enter an integer: " );
	int numberLow = keyBoardScanner.nextInt();
	System.out.print("Using a maximum value, enter your desired range using the highest possible value for the range.\n"
			+ "Enter an integer: ");
	int numberHigh = keyBoardScanner.nextInt();
	System.out.print("\nYou entered " + numberLow + " as a low: "  + "\n" + "You entered "  + numberHigh + " as a high: " + "\n" );
	
	/*In these lines we are creating the class that is responsible for the randomization of integers as well as 
	 * the computation necessary for making the correct set of values for the range.
	 */
	Random randGen = new Random();
	int numberOfValues = (numberHigh) - (numberLow) + 1; 
	//Finally we are printing out the randomized integers using the variable we just created and the users minimum value

	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	System.out.print("\nRandom number: " + (randGen.nextInt(numberOfValues) + numberLow));
	keyBoardScanner.close();
		

	}
	

}
