
public class CountVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Java Programming Class I";
		int vowelCount = 0;
		int consonantCount = 0;
		
		//convert to all lowercase.
		input = input.replaceAll("\\s", "");
		input = input.toLowerCase();
		
		//Loop via the string and count the vowels
		for(int i=0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if(ch =='a' || ch =='e' || ch=='i' || ch=='o' || ch=='u') {
				vowelCount ++;
			} else {
				consonantCount ++; //This logic does count whitespace as consonants as well. FIX IT!
			}
		}
		System.out.println("Number of Vowels: " + vowelCount);
		System.out.println(consonantCount);
	}

}
