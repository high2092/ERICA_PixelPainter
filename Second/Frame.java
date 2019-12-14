import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;


public class Frame extends JFrame{
    Dimension dim_f = new Dimension(800, 800);

    Canvas canvas = new Canvas();

    public Frame(){
        getContentPane().setBackground(Color.BLACK);
        setLocation(400, 400);
        setTitle("PixelPainter");
        setSize(dim_f);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(canvas);
        canvas.setLocation(0, 100);
    }
}