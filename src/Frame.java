import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{

    Canvas canvas = new Canvas();
    public Frame(){
		this.setSize(new Dimension(400, 400));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setTitle("PixelPainter");
        this.add(canvas);


		canvas.setSize(new Dimension(20, 20));
        canvas.setVisible(true);
        
        this.setBackground(Color.gray);
        canvas.setBackground(Color.black);
    }
}