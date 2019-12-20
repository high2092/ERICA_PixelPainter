import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import javax.swing.JLabel;


import java.awt.Point;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


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
    class Canvas extends JPanel{
        int size = 65; //?
        Dimension dim_c = new Dimension(710, 650);
        
        public Canvas(){
            setSize(dim_c);
            // setLocation(0, 200);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    System.out.println("1");
                    gbc.gridx = col;
                    gbc.gridy = row;
    
                    Pixel pixel = new Pixel();
                    Border border = null;
                    if (row < size-1) {
                        if (col < size-1) {
                            border = new MatteBorder(1, 1, 0, 0, Color.black);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.black);
                        }
                    } else {
                        if (col < size-1) {
                            border = new MatteBorder(1, 1, 1, 0, Color.black);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.black);
                        }
                    }
                    pixel.setBorder(border);
                    add(pixel, gbc);
                }
            }
        }
    }
    
    class Pixel extends JPanel {
    
        private Color defaultBackground;
    
        public Pixel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    defaultBackground = getBackground();
                    setBackground(Color.black);
                }
    
                @Override
                public void mouseClicked(MouseEvent e) {
                    setBackground(Color.black);
                    defaultBackground = getBackground();
                }
    
                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                }
            });
        }
    }
}