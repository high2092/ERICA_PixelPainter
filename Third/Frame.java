// import javax.swing.JFrame;
// import java.awt.Dimension;
// import java.awt.Color;
// import javax.swing.JMenu;
// import javax.swing.JMenuBar;
// import javax.swing.JMenuItem;

// import javax.swing.JPanel;
// import javax.swing.JLabel;


import java.awt.Point;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class Frame extends JFrame{
    Dimension dim_f = new Dimension(900, 800);
    Dimension dim2 = new Dimension(190, 704);
    Canvas canvas = new Canvas();

    JMenuBar menubar = new JMenuBar();

    JPanel statusPanel = new JPanel();
    JLabel coordinate;
    JLabel mode;

    Pencil pencil = new Pencil();


    Point mouse = new Point(0,0);


    JPanel optionPanel = new JPanel();
    // MouseListener ml = new MouseListener();

    // Color defaultBackground = Color.WHITE;

    JButton setcolor = new JButton("");

    public Frame(){
        getContentPane().setBackground(Color.BLACK);
        setLocation(400, 400);
        setTitle("PixelPainter");
        setSize(dim_f);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Option-
        optionPanel.setLocation(710, 6);
        optionPanel.setSize(dim2);
        optionPanel.setBackground(new Color(230, 230, 230));
        optionPanel.setLayout(null);
        add(optionPanel);
        // -Panel


        // Option-
        setcolor.setBackground(pencil.getColor());
        setcolor.setSize(new Dimension(64, 64));
        setcolor.setLocation(70, 6);
        setcolor.addActionListener(new ButtonAction());
        optionPanel.add(setcolor);
        // -Button


        // Pale-
        Paint[] palette = new Paint[10];
        palette[0] = new Paint(new Color(0, 0, 0)); // black
        palette[1] = new Paint(new Color(127, 127, 127)); // gray
        palette[2] = new Paint(new Color(255, 127, 39)); // orange
        palette[3] = new Paint(new Color(255, 242, 0)); // yellow
        palette[4] = new Paint(new Color(34, 177, 76)); // green
        // -tte
        for(int i = 0; i < 5; i++){
            palette[i].setLocation(6, 6 + i*46);
            optionPanel.add(palette[i]);
        }
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
        canvas.setLocation(0, 6);
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
        int size = 64; //?
        Dimension dim_c = new Dimension(704, 704);
        // MouseListener ml = new MouseListener();
        
        public Canvas(){
            // addMouseListener(ml);
            // addMouseMotionListener(ml);
            setSize(dim_c);
            // setLocation(0, 200);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    // System.out.println("1");
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
                    // JPanel p = (JPanel)e.getSource();
                    // defaultBackground = getBackground();
                    // p.setBackground(Color.RED);
                    mouse = e.getPoint();
                    coordinate.setText("(" + mouse.getX() + ", " + mouse.getY() + ")");
                    setBackground(pencil.getColor());
                }
    
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(defaultBackground == pencil.getColor()){
                        setBackground(new Color(245, 245, 245));
                    }
                    else{
                        setBackground(pencil.getColor());
                    }
                    defaultBackground = getBackground();
                }
    
                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                }
                @Override // not work
                public void mouseMoved(MouseEvent e){
                    // System.out.println(mouse.getX());
                }
            });

            // addMouseListener(ml);
        }
    }

    // class MouseListener extends MouseAdapter implements MouseMotionListener{
    //     @Override
    //     public void mouseEntered(MouseEvent e) {
    //         JPanel p = (JPanel)e.getSource();
    //         defaultBackground = getBackground();
    //         p.setBackground(Color.RED);
    //         // setBackground(Color.black);
    //     }

    //     @Override
    //     public void mouseClicked(MouseEvent e) {
    //         setBackground(Color.black);
    //         defaultBackground = getBackground();
    //     }

    //     @Override
    //     public void mouseExited(MouseEvent e) {
    //         setBackground(defaultBackground);
    //     }
    // }

    class Pencil{
        private Color color;
        private int thickness;
        public Pencil(){
            color = Color.black;
            thickness = 1;
        }
        public void setColor(Color c){
            color = c;
        }
        public Color getColor(){
            return color;
        }
        public void setThick(){
            
        }
        public int getThick(){
            return thickness;
        }
    }

    class ButtonAction implements ActionListener{
        public void actionPerformed (ActionEvent e){
            pencil.setColor(JColorChooser.showDialog(null, "Color", Color.white)); // Cancel = error;
            setcolor.setBackground(pencil.getColor());
        }
    }


    class Paint extends JPanel{
        private Color paintcolor;
        Paint(Color c){
            setSize(new Dimension(40, 40));
            paintcolor = c;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    pencil.setColor(paintcolor);
                }
            });
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(paintcolor);
            g.fillRect(0, 0, 40, 40);
        }
    }
}