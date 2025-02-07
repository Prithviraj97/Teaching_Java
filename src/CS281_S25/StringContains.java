package CS281_S25;
public class StringContains {

	public static void main(String[] args) {
		String sentence = "Intro to Java Programming CSCI281";
		String targetWord = "CSCI281";
		
		//using the .contains method.
		if(sentence.contains(targetWord)) {
			System.out.println("The sentence contains the word: " + targetWord);
		} else {
			System.out.println("The sentence does not contains the word: " + targetWord);
		}
		
		//remove whitespace
		String input = "Java   Programming";
		String result = input.replaceAll("\\s", "");
		
		System.out.println("Whitespace removed: " + result);
	}

}
