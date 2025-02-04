package CS281_S25;
public class MultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		
		//generate multiplication matrix
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <=num; j++) {
				System.out.printf("%4d", i*j);
			}
			System.out.println();
		}
	}

}
