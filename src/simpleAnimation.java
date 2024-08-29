import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class simpleAnimation extends JPanel implements ActionListener{
    private int x=0;
    protected  Timer timer;

    public simpleAnimation(){
        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(x, 50, 50, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        x += 5;
        if (x> getWidth()) {
            x=0;
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Animation");
        simpleAnimation panel = new simpleAnimation();
        frame.add(panel);
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
