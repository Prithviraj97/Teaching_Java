package CS281;
import java.io.*;
import javax.swing.*;

public class FileChooser {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                processFile(selectedFile);
            } else {
                System.out.println("File selection cancelled.");
            }
        }); 
    }

    private static void processFile(File file) {
        System.out.println("Processing file: " + file.getAbsolutePath());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

            JOptionPane.showMessageDialog(null,
                    "File read successfully.\nTotal lines: " + lineCount,
                    "File Info",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error reading file: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}