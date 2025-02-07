package CS281_S25;
import java.util.Arrays;

public class RemoveDuplicate {

	public static void main(String[] args) {
		int[] numArray = {1,1,2,3,4,4,5,6,7,7};
		
		//sort the array
		Arrays.sort(numArray);
		
		//use a new array to store unique elements
		int[] tempArray = new int[numArray.length];
		int uniqueCount = 0;
		
		//iterate through the array and compare each element with the next element
		for(int i=0; i < numArray.length - 1; i++) {
			if(numArray[i] != numArray[i+1]) {
				tempArray[uniqueCount++] = numArray[i];
			}
		}
		//this will ensure the last element is added to the array
		tempArray[uniqueCount++] = numArray[numArray.length -1];
		
		//create a result array with exact number of unique elements.
		int[] resultArray = Arrays.copyOf(tempArray, uniqueCount);
		
		//print the array with all duplicates removed
		System.out.println("Array without duplicate is: " + Arrays.toString(resultArray));
	}

}
