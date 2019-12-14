import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;


public class Frame extends JFrame{
    Dimension dim_f = new Dimension(400, 400);
    public Frame(){
        setLocation(400, 400);
        setTitle("PixelPainter");
        setSize(dim_f);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
    }
}