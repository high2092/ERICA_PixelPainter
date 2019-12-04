import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{

    Canvas canvas = new Canvas();
    public Frame(){
		this.setSize(new Dimension(400, 400));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.gray);
        
        this.setTitle("PixelPainter");
        this.add(canvas);

		this.setLayout(null);


		canvas.setSize(new Dimension(20, 20));
        canvas.setVisible(true);
        
        canvas.setBackground(Color.black);
    }
}