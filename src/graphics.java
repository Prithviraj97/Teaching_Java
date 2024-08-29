import javax.swing.JOptionPane;

public class graphics {
    public static void main(String[] args) {
        // JOptionPane.showMessageDialog(null, "This is CS282", "Information", JOptionPane.INFORMATION_MESSAGE);

        // ImageIcon image = new ImageIcon("src\\mcneese.png");
        // JOptionPane.showMessageDialog(null, "This is CS282 at McNeese", "Information", JOptionPane.INFORMATION_MESSAGE, image);

        //User Input
        // String name = JOptionPane.showInputDialog("Enter your name: ");
        // System.out.println("User's name is: "+name);

        //INPUT WITH DROP-DOWN SELECTION
        // String[] options = {"CS180C", "CS281-A-B", "CS282A"};
        // String select = (String)JOptionPane.showInputDialog(null, "Choose an Option: ", "Options", 
        // JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // System.out.println("User's Input is: "+ select);

        //Confirm-Dialog

        // int response = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirm", 
        // JOptionPane.YES_NO_CANCEL_OPTION);
        // if(response == JOptionPane.YES_OPTION){
        //     System.out.println("User's choice is to proceed");
        // }
        // else if(response == JOptionPane.NO_OPTION){
        //     System.out.println("User's choice is to not proceed");
    
        // }
        // else{
        //     System.out.println("Out!");
        // }

        //Input with HTML formatting
        JOptionPane.showMessageDialog(null, "<html><h1>THIS IS CS282 - WE ROCK! </h1><p>blah blah blah</p></html>");




    }
}
