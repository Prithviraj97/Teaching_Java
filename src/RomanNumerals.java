//Importing Scanner and Random
import java.util.*;


public class RomanNumerals 
{
	public static void main (String[] ars) 
	{
		
		//instantiate object from Scanner class
		Scanner keyboard = new Scanner(System.in);
		
		//user prompt
		String prompt = "\nPlease enter any integer in the range of 1 to 999\n";
				prompt += "If you want to enter 300, type 300 and hit enter.\n";
				prompt += "\n --->";
				
		//assign value entered to a variable
		System.out.print(prompt);
		int number = keyboard.nextInt();
		
		//Provide code here for validation of number
		if (number > 0 && number < 1000) 
		{
			
			//isolating the units place
			int units_Ones_Digit = number % 10;
			
			//Isolating the 10's digit
			int units_Tens_Digit = number / 10;
			units_Tens_Digit = units_Tens_Digit % 10;
			
			//Isolating the 100's digit
			int units_Hundreds_Digit = number / 100;
			units_Hundreds_Digit = units_Hundreds_Digit % 10;
			
			//print the isolated digit for units
			System.out.print("The isolated digits are: " + units_Hundreds_Digit + "\t" + units_Tens_Digit + "\t" + units_Ones_Digit + "\n\n");
			

			
			//instantiate a String object that will hold the translated digits to
			//form the whole Roman numeral
			String romanNumeral = "";
			
			
			//PROVIDE switch statements for the tens_digit and for the hundreds_digit
			
			//Switch statements for all nine hundreds digits
			switch(units_Hundreds_Digit) 
			{
				case 9:
					romanNumeral += "CM";
					break;
				case 8:
					romanNumeral += "DCCC";
					break;
				case 7:
					romanNumeral += "DCC";
					break;
				case 6:
					romanNumeral += "DC";
					break;
				case 5:
					romanNumeral += "D";
					break;
				case 4:
					romanNumeral += "CD";
					break;
				case 3:
					romanNumeral += "CCC";
					break;
				case 2:
					romanNumeral += "CC";
					break;
				case 1:
					romanNumeral += "C";
					break;
			}	
			
			//Switch statements for all nine tens digits
			switch(units_Tens_Digit) 
			{
				case 9:
					romanNumeral += "XC";
					break;
				case 8:
					romanNumeral += "LXXX";
					break;
				case 7:
					romanNumeral += "LXX";
					break;
				case 6:
					romanNumeral += "LX";
					break;
				case 5:
					romanNumeral += "L";
					break;
				case 4:
					romanNumeral += "XL";
					break;
				case 3:
					romanNumeral += "XXX";
					break;
				case 2:
					romanNumeral += "XX";
					break;
				case 1:
					romanNumeral += "X";
					break;
			}	
			
			//switch statement for all nine non-zero digits
			switch(units_Ones_Digit) 
			{
				case 9:
					romanNumeral += "IX";
					break;
				case 8:
					romanNumeral += "VIII";
					break;
				case 7:
					romanNumeral += "VII";
					break;
				case 6:
					romanNumeral += "VI";
					break;
				case 5:
					romanNumeral += "V";
					break;
				case 4:
					romanNumeral += "IV";
					break;
				case 3:
					romanNumeral += "III";
					break;
				case 2:
					romanNumeral += "II";
					break;
				case 1:
					romanNumeral += "I";
					break;
			}
				

			//print results
			System.out.print("The value of "  + number + " in roman numerals is " + romanNumeral + ".\n\n");
		
		}
		
		else 
		{
		System.out.print("\nThe number you entered was not within the range! Try again.");
		}
		
		keyboard.close();
		
	}

}
