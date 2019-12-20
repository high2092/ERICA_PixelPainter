import java.awt.*;
import javax.swing.*;
public class FrameTest2 {
    public static void main(String[] args){ 
        JFrame f = new JFrame();
        f.setSize(300, 200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new MyPanel());
    }
}
class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        g.fillRect(105, 70, 90, 60);
        g.drawRect(195,130,10,10);
    }
}