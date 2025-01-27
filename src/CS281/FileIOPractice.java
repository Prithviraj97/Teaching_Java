package CS281;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class FileIOPractice{
	public static void main(String [] args){
		
		//establish name of file in a variable
		String fileName = "yetMoreData.txt";           //to view  "yetMoreData.txt" in a JOptionPane
		
		//establish file connection
		File inFile = new  File(fileName);
		
		/* test file location to ensure the program actually can see it; 
		* otherwise, print an error msg and quit program
		*/
		if (!inFile.exists())
		{
			System.out.printf("File not found: " + fileName + "\n\n");
			return;		                                                  //quits the program	
		}
		
		/* establish string accumulator that will hold the entire formatted report -- Since 
		 * we are using JOptionPane, we must pass it the text as a whole.
		 */
		String reportAccumulator = "                ";                    //spaces were added to move column header over to the right
		int rowTotal = 0;                     //for the rowTotal column
		
		//reading data from file and printing it to JOptionPane
		
		// try...catch statement
		try{
			//NOTE: the argument of Scanner is the IO data stream
			Scanner inScanner = new Scanner(inFile);
			
			//read in the first bit of  data, which is the number of cols (fields) in the file
			int cols = inScanner.nextInt();
			int rows = inScanner.nextInt();
			
			//control variables for loop that will be reading in the data
			int col = 1;            //initialization set to 1, because we want it to read Month 1, not Month 0
			int row = 0;
			
			//loop  for column header
			while (col <=  cols){
				reportAccumulator += "mon." + col + "     ";
				col++;	
			}
			reportAccumulator += " row total\n";
			
			//set value of columns to zero for loop to read in data
			col = 0;              			
			
			//loop to read in data
			while (row < rows)
			{
				//to add the row labels
				reportAccumulator += "City " + row;
				
				while (col  < cols)
				{
					//read each integer one at a time and concatenating them to the report accumulator, separating them with a space
					int data = inScanner.nextInt();
					reportAccumulator += "         " + data;
					rowTotal += data;                       //add row total column
					
					col++;
				}
				
				//set control variable to zero so that it can start the next row
				col  = 0;
				
				//add a new line at the end of each row
				reportAccumulator += "              " + rowTotal + "\n";
				
				//clear the rowTotal for the next row
				rowTotal = 0;
				
				row++;
			}
			inScanner.close();
		}
		catch(IOException ioe)
		{
			String message = "Sorry, your data is invalid";
			System.out.print("\n" + message);
			return;
		}
		
		// parameters: null, content, title, java cup
		JOptionPane.showMessageDialog(null, reportAccumulator, "data from\"" + fileName + "\"", 1);
		
	}
	
	
	
}