
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TreeFrame extends JFrame{
    private TreePanel tree;
    public TreeFrame(){
        setTitle("LAB 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        tree = new TreePanel();
        this.pack();
        this.setSize(290,350);
        JPanel buttons = new JPanel();
        
        this.add(tree,BorderLayout.CENTER);
        
        JButton springB = new JButton("Spring");
        JButton summerB = new JButton("Summer");
        JButton fallB = new JButton("Fall");
        JButton winterB = new JButton("Winter");
        

        springB.addActionListener(new ClickListenerForSpring());
        summerB.addActionListener(new ClickListenerForSummer());
        fallB.addActionListener(new ClickListenerForFall());
        winterB.addActionListener(new ClickListenerForWinter());

        springB.setPreferredSize(new Dimension(65, 20));
        fallB.setPreferredSize(new Dimension(65, 20));
        summerB.setPreferredSize(new Dimension(65, 20));
        winterB.setPreferredSize(new Dimension(65, 20));



        buttons.add(springB);
        buttons.add(summerB);
        buttons.add(fallB);
        buttons.add(winterB);
        

        this.add(buttons, BorderLayout.SOUTH);

       


    }
     class ClickListenerForSpring implements ActionListener{
            public void actionPerformed(ActionEvent e){
                tree.setSeason(0); 
            }
        }
        class ClickListenerForSummer implements ActionListener{
            public void actionPerformed(ActionEvent e){
                tree.setSeason(1); 
            }
        }class ClickListenerForFall implements ActionListener{
            public void actionPerformed(ActionEvent e){
                tree.setSeason(2); 
            }
        }class ClickListenerForWinter implements ActionListener{
            public void actionPerformed(ActionEvent e){
                tree.setSeason(3); 
            }
        }
    public static void main(String[] args) {
        TreeFrame t1 = new TreeFrame();
        
        t1.setVisible(true);
    }
}
