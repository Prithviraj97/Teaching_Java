
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("hello.txt");
            writer.write("Hello CSC282!");
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader("hello.txt"));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
