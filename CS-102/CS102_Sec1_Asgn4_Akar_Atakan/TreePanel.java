/**
 * TreePanel
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class TreePanel extends JPanel{
    private  int season = 0;
    private int[] xSnows;
    private int[] ySnows;
    private int[] vYSnows;
    private int[] vXSnows;
    
    int[] xRoot =  {71,73,125,130,119,95,194,169,161,210,220,205,184,170,190,163,176,156,141,147,127,136,129,80};
    int[] yRoot = {92,148,174,223,256,270,270,258,226,170,110,150,192,128,72,127,183,189,165,113,78,113,158,139};
    Random random = new Random();
    int[] xFirstL = {48,17,57,116,118,87};
    int[] yFirstL = {66,124,165,140,97,57};
    int[] xSecondL = {114,98,114,118,236,257,213,146};
    int[] ySecondL = {33,87,141,157,142,94,44,27};
    int[] tempRoot;
    int[] tempFirstL; 
    int[] tempSecondL; 
   
    Timer tSnow;
    Timer tSpringBranches;
    Timer tFallBranches;
    Timer tWinterBranches;
    Timer tSummerBranches;
    
    
    public TreePanel(){
        xSnows = new int[300];
        ySnows = new int[300];
        vYSnows = new int[300];
        vYSnows = new int[100];
        vXSnows = new int[100];
        tempRoot = xRoot.clone();
        tempFirstL = xFirstL.clone();
        tempSecondL = xSecondL.clone();
       
            

        for(int i = 0; i < vYSnows.length; i++){
            xSnows[i] = random.nextInt(280);
            ySnows[i] = random.nextInt(220);
            vYSnows[i] = random.nextInt(6) + 1;
            vXSnows[i] = random.nextInt(2) + 1;
            

        }
        tSnow = new Timer(50,new TimerListener());
        tWinterBranches = new Timer(50, new TimerListenerForWinter());
        tFallBranches = new Timer(50,  new TimerListenerForFall());
        tSpringBranches = new Timer(50, new TimerListenerForSpring());
        tSummerBranches = new Timer(50, new TimerListenerSummer());
        
    }

    public void paintComponent (Graphics g){
        
        super.paintComponent(g);
        if(season == 0){
            tFallBranches.stop();
            tWinterBranches.stop();
            tSummerBranches.stop();
            Graphics2D g2 = (Graphics2D) g;

            tSpringBranches.start();
            
            Color lColor = new Color(132, 222, 130);
            Color rColor = new Color(122, 57, 43);
            Color bColor = new Color(141, 168, 108);
            Color gColor = new Color(150,238,255);
            g2.setColor(gColor);
            g2.fillRect(0, 0,294, 274);



            Polygon p1 = new Polygon(xFirstL, yFirstL, 6);
            Polygon p2 = new Polygon(xSecondL,ySecondL,8);

            g2.setColor(lColor);
            g2.fillPolygon(p1);
            g2.fillPolygon(p2);
            
            g2.setColor(rColor);

            g2.fillPolygon(xRoot, yRoot, 24 );
            g2.setColor(bColor);
            g2.fillRect(0,270,296,17);
            repaint();
        }
        
        if(season == 1 ){
            tWinterBranches.stop();
            tFallBranches.stop();
            tSpringBranches.stop();
            Graphics2D g2 = (Graphics2D) g;
            tSummerBranches.start();
                
            
            Color lColor = new Color(10, 209, 20);
            Color rColor = new Color(122, 57, 43);
            Color bColor = new Color(101, 181, 74);
            Color gColor = new Color(173,231,255);
            g2.setColor(gColor);
            g2.fillRect(0, 0,294, 274);


            Polygon p1 = new Polygon(xFirstL, yFirstL, 6);
            Polygon p2 = new Polygon(xSecondL,ySecondL,8);

            g2.setColor(lColor);
            g2.fillPolygon(p1);
            g2.fillPolygon(p2);


            g2.setColor(rColor);
            g2.fillPolygon(xRoot, yRoot, 24 );
            g2.setColor(bColor);
            g2.fillRect(0,270,296,17);
            g2.setColor(Color.RED);
            g2.fillOval(55, 100, 12, 12);
            g2.fillOval(90, 110, 12, 12);
            g2.fillOval(147, 69, 12, 12);
            g2.fillOval(179, 121, 12, 12);
            g2.fillOval(228, 93, 12, 12);
            repaint();
        }
        if(season == 2){
            tSummerBranches.stop();
            tWinterBranches.stop();
            tSpringBranches.stop();
            tFallBranches.start();
            System.out.println(xRoot[0]);
            Graphics2D g2 = (Graphics2D) g;
            
            
            Color lColor = new Color(212, 118, 11);
            Color rColor = new Color(122, 57, 43);
            Color bColor = new Color(191, 115, 33);
            Color gColor = new Color(119,171,185);
            g2.setColor(gColor);
            g2.fillRect(0, 0,294, 274);
            


            Polygon p1 = new Polygon(xFirstL, yFirstL, 6);
            Polygon p2 = new Polygon(xSecondL,ySecondL,8);

            g2.setColor(lColor);
            g2.fillPolygon(p1);
            g2.fillPolygon(p2);

            g2.setColor(rColor);
            g2.fillPolygon(xRoot, yRoot, 24 );
            g2.setColor(bColor);
            g2.fillRect(0,270,296,17);
            
            repaint();
        }
        if(season == 3){
            tFallBranches.stop();
            tSpringBranches.stop();
            tSummerBranches.stop();
            tWinterBranches.start();

            Graphics2D g2 = (Graphics2D) g;
            Color rColor = new Color(122, 57, 43);
            Color bColor = new Color(129, 145, 144);
            Color gColor = new Color(80,93,109);
            g2.setColor(gColor);
            g2.fillRect(0, 0,294, 274);


            g2.setColor(rColor);
            g2.fillPolygon(xRoot, yRoot, 24 );
            g2.setColor(bColor);
            g2.fillRect(0,270,296,17);
            //Timer timer = new Timer(100, listener);
            tSnow.start();
            for (int i = 0; i < vYSnows.length; i++) {
                g2.setColor(Color.WHITE);
                g2.fillOval(xSnows[i], ySnows[i], 3, 3);
                
            }
            repaint();
            
            
        }
        
        
    }
    public void setSeason(int choose){
        this.season = choose;
        
        this.repaint();
    }
    public class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < vYSnows.length; i++){
                ySnows[i] += vYSnows[i];
                int choice = random.nextInt(2);
                if(choice == 0){
                    xSnows[i] += vXSnows[i];
                }
                if(choice == 1){
                    xSnows[i] -= vXSnows[i];
                }
                if((ySnows[i] > 270) || xSnows[i] > 310 || xSnows[i] < 0){
                    ySnows[i] = 0;
                    xSnows[i] = random.nextInt(250);
                    vYSnows[i] = random.nextInt(6) + 1;
                
                    vXSnows[i] = random.nextInt(2) + 1;
                }

            }
            repaint();
        }
        

    }
    public class TimerListenerForWinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int windPower = random.nextInt(6);
            
            for(int i = 0;i < xRoot.length;i++){
                xRoot[i] = tempRoot[i] + windPower * (( 300 - yRoot[i]) / 50);
            }
            for(int i = 0;i < xFirstL.length;i++){
                xFirstL[i] = tempFirstL[i] + windPower * ((300 -yFirstL[i]) / 50);
            }
            for(int i = 0;i < xSecondL.length;i++){
                xSecondL[i] = tempSecondL[i] + windPower * ((300 - ySecondL[i]) / 50);
            }
            repaint();    
        }
        

    }
    public class TimerListenerForFall implements ActionListener{

        @Override
         public void actionPerformed(ActionEvent e) {
            int windPower = random.nextInt(4);
            
            for(int i = 0;i < xRoot.length;i++){
                xRoot[i] = tempRoot[i] + windPower * (( 300 - yRoot[i]) / 50);
            }
            for(int i = 0;i < xFirstL.length;i++){
                xFirstL[i] = tempFirstL[i] + windPower * (( 300 - yFirstL[i]) / 50);
            }
            for(int i = 0;i < xSecondL.length;i++){
                xSecondL[i] = tempSecondL[i] + windPower * ((300 -ySecondL[i]) / 50);
            }
            repaint();    
        }
        

    }
    public class TimerListenerForSpring implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int windPower = random.nextInt(2) ;
            
            for(int i = 0;i < xRoot.length;i++){
                xRoot[i] = tempRoot[i] + windPower * ( (300 - yRoot[i]) / 50);
            }
            for(int i = 0;i < xFirstL.length;i++){
                xFirstL[i] = tempFirstL[i] + windPower * (( 300 - yFirstL[i]) / 50);
            }
            for(int i = 0;i < xSecondL.length;i++){
                xSecondL[i] = tempSecondL[i] + windPower * (( 300 - ySecondL[i] ) / 50);
            }
            repaint();    
        }
        

    }
    public class TimerListenerSummer implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int windPower = random.nextInt(15);
            
            for(int i = 0;i < xRoot.length;i++){
                xRoot[i] = tempRoot[i];
            }
            for(int i = 0;i < xFirstL.length;i++){
                xFirstL[i] = tempFirstL[i];
            }
            for(int i = 0;i < xSecondL.length;i++){
                xSecondL[i] = tempSecondL[i];
            }
            repaint();    
        }
        

    }
   
}