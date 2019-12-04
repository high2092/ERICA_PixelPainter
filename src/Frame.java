import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{

    Canvas canvas = new Canvas();
    JPanel bg = new JPanel();
    Dimension sizeof_frame = new Dimension(400, 400);
    public Frame(){
		this.setSize(sizeof_frame);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bg.setBackground(Color.black);
        
        this.setTitle("PixelPainter");

		this.setLayout(null);


        canvas.setSize(new Dimension(200, 200));
        canvas.setLocation(50, 50);
        canvas.setVisible(true);
        

        bg.setSize(sizeof_frame);
        bg.setVisible(true);

        this.add(canvas); // low priority
        this.add(bg); // high priority

        canvas.setBackground(Color.white);
    }
}