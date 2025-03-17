package CS281_S25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader{
    public static void main(String[] args) {
        String filepath = "C:\\Users\\Admin\\OneDrive\\Desktop\\Repository\\Java_Learning\\MLData2.csv";
        String line = "";
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                System.out.println("DA Concentration: " + data[0] + ", AA Concentration: " + data[1] + ", Peak Current: " + data[2]
                +", Peak Potential: " + data[3] + ", Peak Area: " + data[4] );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
