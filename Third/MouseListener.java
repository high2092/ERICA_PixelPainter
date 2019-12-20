public class MouseListener extends MouseAdapter implements MouseMotionListener{
    
    int x, y;

    public int[] mousePressed(MouseEvent e){
        int[] coordinate = new int[2];
        coordinate[0] = x;
        coordinate[1] = y;
        return coordinate;
    }

    public void mouseDragged(MouseEvent e){

    }

    public void mouseMoved(MouseEvent e){
        
    }
}