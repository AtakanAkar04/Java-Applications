import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class SettingsFrame extends JFrame{
    private Controller controller;
    private JTextField widthInputTextField;
    private JTextField heightInputTextField;
    private JLabel label1;
    private JLabel label2;
    private JButton continueButton;
    private JPanel heightPanel;
    private JPanel widhtPanel;
    


    public SettingsFrame(Controller controller){
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setTitle("Settings Frame");
        
        
        label1 = new JLabel("Width:");
        label2 = new JLabel("Height");
        heightPanel = new JPanel();
        widhtPanel = new JPanel();

        widthInputTextField = new JTextField(5);
        heightInputTextField = new JTextField(5);
        
        heightPanel.add(label2);
        heightPanel.add(heightInputTextField);

        widhtPanel.add(label1);
        widhtPanel.add(widthInputTextField);

        
        continueButton = new JButton("Continue");
        continueButton.addActionListener(new ButtonListener());
        this.add(widhtPanel, BorderLayout.NORTH);
        this.add(heightPanel, BorderLayout.CENTER);
        this.add(continueButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }

       
    public class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(!(isNumeric(widthInputTextField.getText())  && isNumeric(heightInputTextField.getText()))){
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
            else{
                int width = Integer.parseInt(widthInputTextField.getText());
                int height = Integer.parseInt(heightInputTextField.getText());
                if((width < 0) || (width > 1000) || (height < 0) || (height > 1000)){
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }
                else{
                    controller.arrangeSettingsFrameInput(true,width,height);
                }
            }
                

            
        }
        
    }
    private boolean isNumeric(String s){
        boolean is = true;
        for(int i = 0; i < s.length(); i++){
            if(!(Character.isDigit(s.charAt(i)))){
                return false;
            }
        }
        return is;
    }
}
