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
    JLabel mouselabel;
    int mousestatus;
    int pencilstatus;
    JLabel mode;

    Pencil pencil = new Pencil();


    Point mouse = new Point(0,0);

    JPanel optionPanel = new JPanel();
    // MouseListener ml = new MouseListener();

    // Color defaultBackground = Color.WHITE;

    JButton setcolor = new JButton("");
    JButton clear = new JButton("C");
    JButton eraser = new JButton("");

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
        Dimension dim_button = new Dimension(64, 64);
        setcolor.setBackground(pencil.getColor());
        setcolor.setSize(dim_button);
        setcolor.setLocation(123, 3);
        setcolor.addActionListener(new ButtonAction());
        optionPanel.add(setcolor);

        clear.setSize(dim_button);
        clear.setLocation(123, 137);
        clear.addActionListener(new ButtonAction());
        optionPanel.add(clear);
        eraser.setSize(dim_button);
        eraser.setBackground(new Color(240, 240, 240));
        eraser.setLocation(123, 70);
        eraser.addActionListener(new ButtonAction());
        optionPanel.add(eraser);
        // -Button


        // Pale-
        Paint[] palette = new Paint[20];
        palette[0] = new Paint(new Color(0, 0, 0)); // black
        palette[1] = new Paint(new Color(127, 127, 127)); // gray
        palette[2] = new Paint(new Color(136, 0, 21)); // burgundy
        palette[3] = new Paint(new Color(237, 28, 36)); // red
        palette[4] = new Paint(new Color(255, 127, 39)); // orange
        palette[5] = new Paint(new Color(255, 242, 0)); // yellow
        palette[6] = new Paint(new Color(34, 177, 76)); // green
        palette[7] = new Paint(new Color(0, 162, 232)); // blue
        palette[8] = new Paint(new Color(63, 72, 204)); // deepblue
        palette[9] = new Paint(new Color(163, 73, 164)); // purple
        // -tte
        for(int i = 0; i < 10; i++){
            palette[i].setLocation(6, 6 + i*46);
            optionPanel.add(palette[i]);
        }
        for(int i = 0; i < 10; i++){
            palette[i].setLocation(46, 6 + i*46);
            optionPanel.add(palette[i]);
        }
        
        // Status-
        pencilstatus = 1;
        mode = new JLabel("Mode: PENCIL // ");
        statusPanel.add(mode);
        coordinate = new JLabel("Coordinate = (" + mouse.getX() + ", " + mouse.getY() + ") // ");
        mousestatus = 0;
        statusPanel.add(coordinate);
        mouselabel = new JLabel("Mouse Pressed: " + mousestatus);
        statusPanel.add(mouselabel);
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
        Pixel[][] pixels = new Pixel[64][64];
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
                    pixels[row][col] = pixel;
                }
            }
            // pack()
        }
    }
    
    class Pixel extends JPanel {
        private Color defaultBackground;
        public Pixel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    mouse = e.getPoint();
                    mouse.setLocation(getLocation());
                    coordinate.setText("Coordinate = (" + mouse.getX() + ", " + mouse.getY() + ") // ");
                    // setBackground(pencil.getColor());
                    if(pencilstatus == 1){
                        setBackground(pencil.getColor());
                    }
                    else{
                        setBackground(new Color(240, 240, 240));
                    }
                    if(mousestatus == 1){
                        defaultBackground = getBackground();
                    }
                }
    
                // @Override
                // public void mouseClicked(MouseEvent e) { // Click == Press + Release
                //     if(defaultBackground == pencil.getColor()){
                //         setBackground(new Color(245, 245, 245));
                //     }
                //     else{
                //         setBackground(pencil.getColor());
                //     }
                //     defaultBackground = getBackground();
                // }
                @Override
                public void mousePressed(MouseEvent e) {
                    if(pencilstatus == 0){
                        setBackground(new Color(240, 240, 240));
                    }
                    else{
                        setBackground(pencil.getColor());
                    }
                    defaultBackground = getBackground();
                    mousestatus = 1;
                    mouselabel.setText("Mouse Pressed: " + mousestatus);
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    // if(defaultBackground == pencil.getColor()){
                    //     setBackground(new Color(245, 245, 245));
                    // }
                    // else{
                    //     setBackground(pencil.getColor());
                    // }
                    defaultBackground = getBackground();
                    mousestatus = 0;
                    mouselabel.setText("Mouse Pressed: " + mousestatus);
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                    // mouse = e.getPoint();
                    // JPanel n = new JPanel();
                    // n.
                    // mouse = ((JPanel)e.getSource()).getSource().getPoint();
                    // coordinate.setText("(" + mouse.getX() + ", " + mouse.getY() + ")");
                    setBackground(defaultBackground);
                }
                @Override // not work
                public void mouseMoved(MouseEvent e){
                    // System.out.println(mouse.getX());
                }
            });

            // addMouseListener(ml);
        }
        public void Clear(){
            setBackground(new Color(240, 240, 240));
            defaultBackground = new Color(240, 240, 240);
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
            setcolor.setBackground(c);
            pencilstatus = 1;
            mode.setText("Mode: PENCIL // ");
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
            JButton button = (JButton)e.getSource();
            // String temp = button.getText();
            if(button == setcolor) pencil.setColor(JColorChooser.showDialog(null, "Color", Color.white)); // Cancel = error;
            else if(button == eraser){
                if(pencilstatus == 1){
                    pencilstatus = 0;
                    mode.setText("Mode: ERASE // ");
                }
                else{
                    pencilstatus = 1;
                    mode.setText("Mode: PENCIL // ");
                }
                // pencilstatus = (pencilstatus+1)%2;
            }
            else if(button == clear){
                for(int i = 0; i < 64; i++){
                    for(int j = 0; j < 64; j++){
                        canvas.pixels[i][j].Clear();
                    }
                }
            }
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