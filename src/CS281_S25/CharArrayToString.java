package CS281_S25;
public class CharArrayToString {

	public static void main(String[] args) {
		char[] charArray = {'H', 'e', 'l', 'l', 'o'};
		String result = new String(charArray);
		System.out.println("String: " + result);
		
		String input = "Take the Dog for a walk around the police station";
		
		String[] words = input.split(" ");
		String longestWord = "";
		
		for(String word: words) {
			if(word.length() > longestWord.length()) {
				longestWord = word;
			}
		}
		System.out.println("The longest word is: "+ longestWord);
	}

}
