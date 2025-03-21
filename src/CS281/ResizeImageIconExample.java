package CS281;
import java.awt.*;
import javax.swing.*;

public class ResizeImageIconExample {

    public static void main(String[] args) {
        // Load the original image
        ImageIcon originalIcon = new ImageIcon("path/to/your/image.jpg");

        // Resize the image
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Width=100, Height=100
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Show the JOptionPane with the resized icon
        JOptionPane.showMessageDialog(null, "This is a resized icon", "Image Icon Example", JOptionPane.INFORMATION_MESSAGE, resizedIcon);
    }
}