package CS281;
//write a program that creates a file, writes data to it and closes it.
import java.io.*;

public class Playing_with_file {
    public static void main(String[] args) {
        String fileName = "output.txt";

        // Sample data
        String[] headers = {"Name", "Age", "City"};
        String[][] data = {
            {"Alice", "30", "New York"},
            {"Bob", "25", "Los Angeles"},
            {"Charlie", "35", "Chicago"}
        };

        try (FileWriter writer = new FileWriter(fileName)) {
            // Write headers
            writer.write(String.join(",", headers) + "\n");

            // Write data rows
            for (String[] row : data) {
                writer.write(String.join(",", row) + "\n");
            }

            System.out.println("File created successfully: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

}

//Read the file and display its contents
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;

// public class CSVFileReader {
//     public static void main(String[] args) {
//         String fileName = "output.txt";

//         try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//             String line;

//             System.out.println("Contents of " + fileName + ":");
//             while ((line = reader.readLine()) != null) {
//                 System.out.println(line);
//             }

//         } catch (IOException e) {
//             System.err.println("Error reading file: " + e.getMessage());
//         }
//     }
// }

//reading the file with scanner
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Scanner;

// public class CSVFileScannerReader {
//     public static void main(String[] args) {
//         String fileName = "output.txt";

//         try (Scanner scanner = new Scanner(new File(fileName))) {
//             System.out.println("Contents of " + fileName + ":");
//             while (scanner.hasNextLine()) {
//                 String line = scanner.nextLine();
//                 System.out.println(line);
//             }
//         } catch (FileNotFoundException e) {
//             System.err.println("File not found: " + fileName);
//         }
//     }
// }


//Display the file in a JOptionPane
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Scanner;
// import javax.swing.JOptionPane;

// public class CSVFileScannerWithDialog {
//     public static void main(String[] args) {
//         String fileName = "output.txt";
//         StringBuilder content = new StringBuilder();

//         try (Scanner scanner = new Scanner(new File(fileName))) {
//             while (scanner.hasNextLine()) {
//                 content.append(scanner.nextLine()).append("\n");
//             }

//             // Display the content in a dialog box
//             JOptionPane.showMessageDialog(null, content.toString(), 
//                                           "File Contents", 
//                                           JOptionPane.INFORMATION_MESSAGE);

//         } catch (FileNotFoundException e) {
//             JOptionPane.showMessageDialog(null, "File not found: " + fileName,
//                                           "Error", 
//                                           JOptionPane.ERROR_MESSAGE);
//         }
//     }
// }