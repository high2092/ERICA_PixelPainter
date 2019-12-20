import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import javax.swing.JLabel;


import java.awt.Point;

public class Frame extends JFrame{
    Dimension dim_f = new Dimension(900, 800);

    Canvas canvas = new Canvas();

    JMenuBar menubar = new JMenuBar();

    JPanel statusPanel = new JPanel();
    JLabel coordinate;
    JLabel mode;


    Point mouse = new Point(0,0);

    public Frame(){
        getContentPane().setBackground(Color.BLACK);
        setLocation(400, 400);
        setTitle("PixelPainter");
        setSize(dim_f);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // Status-
        coordinate = new JLabel("(" + mouse.getX() + ", " + mouse.getY() + ")");
        statusPanel.add(coordinate);
        // statusPanel.setLayout(null);
        // coordinate.setLocation(700, 0);
        // --
        statusPanel.setSize(new Dimension(900, 40));
        statusPanel.setBackground(Color.gray);
        statusPanel.setLocation(0, 710);
        add(statusPanel);
        // -Panel


        // Can-
        canvas.setLocation(0, 60);
        add(canvas);
        // -vas



        // Menu-
        JMenu file = new JMenu("File");
        menubar.add(file);
        setJMenuBar(menubar);
        // -bar
        JMenuItem save = new JMenuItem("Save");
        file.add(save);
        // -Menuitem

        
        


    }
}