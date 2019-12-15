import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Canvas extends JPanel{
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