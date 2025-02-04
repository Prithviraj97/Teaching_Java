
public class PalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Original = "madam";
		String reversed ="";
		String name = "John Doe";
		String word = "Doe";
		
		if(name.contains(word)) {
			System.out.println("The name contains the word "+word);
		}
		
		for(int i = Original.length()-1; i>=0; i--) {
			reversed += Original.charAt(i);
		}
		if(Original.equals(reversed)) {
			System.out.println(Original + " is a palindrome");
		} else {
			System.out.println(Original + " is not a palindrome");
		}
	}

}
