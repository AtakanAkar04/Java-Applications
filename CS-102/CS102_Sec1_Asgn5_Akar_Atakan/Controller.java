import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.*;

public class Controller {
    private SettingsFrame settingsFrame;
    private ToolsFrame toolsFrame;
    private PaintFrame paintFrame;
    private BufferedImage bufferedImage;
    private String aTool = "Pen";
    private int penSize = 5;
    private Color color = Color.BLACK;
    private int toleranceValue;
    
    public Controller() {
        settingsFrame = new SettingsFrame(this);
        toolsFrame = new ToolsFrame(this);
        paintFrame = new PaintFrame(this);
        toleranceValue = 1;
    }
    
    
    public void arrangeSettingsFrameInput(boolean is,int width,int height){
        if(is){
            settingsFrame.setVisible(false);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            paintFrame.setVisible(true);
            toolsFrame.setVisible(true);
            
            paintFrame.setPreferredSize(new Dimension(width,height));
            paintFrame.setSize(width,height);
            paintFrame.setResizable(false);
            deleteBufferedImage();
        }

    }
    public int getToleranceValue(){
        return toleranceValue;
    }
    public void setToleranceValue(int n){
        toleranceValue = n;
    }
    public void setATool(String s){
        aTool = s;
    }
    public String getATool(){
        return aTool;
    }
    public void setPenSize(int s){
        penSize = s;
    }

    public void deleteBufferedImage(){
        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        paintFrame.repaint();
    }
    public int getPenSize(){
        return penSize;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color c){
        color = c;
    }

    public BufferedImage getBufferedImage(){
        return bufferedImage;
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        
        
    }
}