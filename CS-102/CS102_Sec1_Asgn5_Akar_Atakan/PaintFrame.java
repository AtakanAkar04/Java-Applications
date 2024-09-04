import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.MouseEvent;


public class PaintFrame extends JFrame implements MouseInputListener{
    private Controller controller;
    

    public PaintFrame(Controller controller) {
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setTitle("Paint Frame");
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setLocation(130, 0);

    }
    public void setBufferedImage(){
        
        //repaint();
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(controller.getBufferedImage(), 0, 0, null);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int sX = e.getX();
        int sY = e.getY();
        if (controller.getATool().equals("Pen")) {
            paintPixels(sX, sY);
        }
        if (controller.getATool().equals("Laser")) {
            totalLaseering(sX, sY);
        }

    }  
    @Override
    public void mouseReleased(MouseEvent e) {
       
    }
    @Override
    public void mouseEntered(MouseEvent e) {
     
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        int cX = e.getX();
        int cY = e.getY();

        if (controller.getATool().equals("Pen")) {
            paintPixels(cX, cY);
            
            
        }
        if (controller.getATool().equals("Laser")) {
            totalLaseering(cX, cY);
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    private void paintPixels(int x, int y) {
        int penSize = controller.getPenSize();

        for (int i = -penSize; i <= penSize; i++) {
            for (int j = -penSize; j <= penSize; j++) {
                int newX = x + i;
                int newY = y + j;
                controller.getBufferedImage().setRGB(newX, newY, controller.getColor().getRGB());  
            }
        }
        repaint();
    }
    private boolean arePixelsSuitableForLasered(Color firstColor, Color secondColor) {
        boolean isSuit = true;
        int currentTol = controller.getToleranceValue();
        int colorDif = Math.abs(firstColor.getRed() - secondColor.getRed()) + Math.abs(firstColor.getGreen() - secondColor.getGreen()) + Math.abs(firstColor.getBlue() - secondColor.getBlue());
        if(colorDif / 3 < currentTol){
            isSuit = true;
        }
        else{
            isSuit = false;
        }
        return isSuit;
    }
    private void laseringUpward(int xCor, int yCor, Color currentColor){
        if ((yCor < 0) || !arePixelsSuitableForLasered(new Color(controller.getBufferedImage().getRGB(xCor, yCor)),currentColor)) {
            
            return;
        }
        if(arePixelsSuitableForLasered(new Color(controller.getBufferedImage().getRGB(xCor, yCor)),currentColor)){
            repaint();
            controller.getBufferedImage().setRGB(xCor, yCor,controller.getColor().getRGB());
        }

        laseringUpward(xCor, yCor - 1,currentColor);
    }
    private void totalLaseering(int xCor, int yCor) {
        Color currentColor = new Color(controller.getBufferedImage().getRGB(xCor, yCor));
        if ((xCor < 0 || xCor >= controller.getBufferedImage().getWidth())) {
            return;
        }

        
        laseringUpward(xCor, yCor, currentColor);

        
        laseringDownward(xCor, yCor +1,currentColor);
        repaint();
    }
    private void laseringDownward(int xCor, int yCor,Color currentColor) {
        if ((yCor > controller.getBufferedImage().getHeight()) || !arePixelsSuitableForLasered(new Color(controller.getBufferedImage().getRGB(xCor, yCor)),currentColor)) {
            return;
        }
        if(arePixelsSuitableForLasered(new Color(controller.getBufferedImage().getRGB(xCor, yCor)),currentColor)){
            repaint();
            controller.getBufferedImage().setRGB(xCor, yCor,controller.getColor().getRGB());
        }

        laseringDownward(xCor, yCor +1,currentColor);
    }
     
}
