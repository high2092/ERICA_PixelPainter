
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color; // Color.white
import java.awt.Dimension; // Dimension(int, int)

public class Frame extends JFrame{

    Canvas canvas = new Canvas();
    JPanel bg = new JPanel();
    JMenuBar menubar = new JMenuBar();

    Dimension sizeof_frame = new Dimension(400, 360);
    Dimension sizeof_canvas = new Dimension(310, 310);

    public Frame(){
		this.setSize(sizeof_frame);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        this.setTitle("PixelPainter");

		this.setLayout(null);


        canvas.setSize(sizeof_canvas);
        canvas.setLocation(0, 50);
        canvas.setVisible(true);
        

        bg.setSize(sizeof_frame);
        bg.setVisible(true);

        this.add(canvas);

        canvas.setBackground(Color.white);

        setJMenuBar(menubar);
        JMenu file = new JMenu("File");
        menubar.add(file);
    }
}