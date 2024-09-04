import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ToolsFrame extends JFrame{
    private Controller controller;
    JButton buttonClear;
    JButton buttonPen;
    JButton buttonPenSize;
    JButton buttonLaser;
    JButton buttonColor; 
    JButton buttonTolerance; 

    public ToolsFrame(Controller controller){
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setTitle("Tools Frame");
        this.setLayout(new GridLayout(6, 1));


        buttonClear = new JButton("Clear");
        buttonPen = new JButton("Pen");
        buttonPenSize = new JButton("Pen Size");
        buttonLaser = new JButton("Laser");
        buttonColor = new JButton("Color");
        buttonTolerance = new JButton("Tolerance");
        buttonClear.addActionListener(new ButtonListener1());
        buttonPen.addActionListener(new ButtonListener2());
        buttonPenSize.addActionListener(new ButtonListener3());
        buttonLaser.addActionListener(new ButtonListener4());
        buttonColor.addActionListener(new ButtonListener5());
        buttonTolerance.addActionListener(new ButtonListener6());

        this.add(buttonClear);
        this.add(buttonPen);
        this.add(buttonPenSize);
        this.add(buttonLaser);
        this.add(buttonColor);
        this.add(buttonTolerance);
        this.pack();
    }
    private class ButtonListener1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.setATool("Clear");
            controller.deleteBufferedImage();
            
        }
        
    }
    private class ButtonListener2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.setATool("Pen");
            
        }
        
    }
    private class ButtonListener3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.setATool("penSize");
            String input = JOptionPane.showInputDialog("Enter pen size:", "");
            if(isNumericForPenSize(input)){
                int penSize = Integer.parseInt(input);
                controller.setPenSize(penSize);
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }

            
        }
        
    }
    private class ButtonListener4 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.setATool("Laser");
            
        }
        
    }
    private class ButtonListener5 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.setATool("Color");
            Color sColor = JColorChooser.showDialog(null, "Choose color?", Color.WHITE);
            controller.setColor(sColor);
            
        }
        
    }
    private class ButtonListener6 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.setATool("buttonTolerance");
            int newTolerance = Integer.parseInt(JOptionPane.showInputDialog("Enter tolerance:",""));
            controller.setToleranceValue(newTolerance);
        }
        
    }
    private boolean isNumericForPenSize(String s){
        boolean is = true;
        for(int i = 0; i < s.length(); i++){
            if(!(Character.isDigit(s.charAt(i)))){
                return false;
            }
        }
        return is;
    }

}
