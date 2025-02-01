package CS281_S25;
public class FloydTriangle {

	public static void main(String[] args) {
		int rows = 5; //rows in triangle
		int num = 1;
		
		int i = 1;
		//outer while loop for rows
		while(i <=rows) {
			int j = 1;
			//inner while loop for columns (printing numbers of each row)
			while(j <= i) {
				System.out.print(num + " ");
				num ++; //increment the number to print the next number.
				j++;
			}
			System.out.println(); //Move to next row after each line.
			i++;
		}
	}

}
