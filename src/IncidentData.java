
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;

// public class FileExample {
//     public static void main(String[] args) {
//         try {
//             FileWriter writer = new FileWriter("hello.txt");
//             writer.write("Hello CSC282!");
//             writer.close();

//             BufferedReader reader = new BufferedReader(new FileReader("hello.txt"));
//             String line;
//             while((line = reader.readLine()) != null){
//                 System.out.println(line);
//             }
//             reader.close();
             
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IncidentData {
    public static void main(String[] args) {
        try {
            // Specify the file path here
            File file = new File("C:\\Users\\Admin\\Downloads\\yetMoreData3.txt");
            Scanner sc = new Scanner(file);

            // Read the first line to get number of months and cities
            int months = sc.nextInt();
            int cities = sc.nextInt();
            
            System.out.println("Months: " + months + ", Cities: " + cities);
            
            // Process data for each city
            for (int i = 0; i < cities; i++) {
                int sum = 0;
                System.out.print("City " + (i + 1) + " data: ");
                
                // Read the monthly data for the current city
                for (int j = 0; j < months; j++) {
                    int incidents = sc.nextInt();
                    sum += incidents;
                    System.out.print(incidents + " "); 
                }
                
                // Print sum for the current city
                System.out.println(" | Sum: " + sum);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
