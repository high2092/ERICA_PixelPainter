import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Test{
    public static void main(String[] args){
        new Frame();
    }  
    
}
class Frame{
    Frame(){
        JFrame f = new JFrame();
        MyPanel p = new MyPanel();
        f.setSize(new Dimension(400, 400));
        f.setLayout(null);
        p.setSize(new Dimension(200, 200));
        f.setVisible(true);
        p.setLocation(100, 100);
        f.add(p);
        p.setBackground(Color.black);
        f.getContentPane().setBackground(Color.white);
    }
    class MyPanel extends JPanel{
        MyPanel(){
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(getBackground() == Color.white){
                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(MyPanel.this);
                        currentFrame.getContentPane().setBackground(Color.white);
                        setBackground(Color.black);
                    }
                    else{
                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(MyPanel.this);
                        currentFrame.getContentPane().setBackground(Color.black);
                        setBackground(Color.white);
                    }
                    System.out.println("Clicked");
                }
            });
        }
    }
}
