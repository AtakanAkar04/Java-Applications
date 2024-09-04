import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class LabPanel extends JPanel implements KeyListener {
    private BufferedImage[] paintings;
    int[][] pixelsForPainting0;
    int[][] pixelsForPainting1;
    int[][] pixelsForPainting2;
    public static int startIndex0=0;
    public static int startIndex1=0;
    public static int startIndex2=0;
    public static int xCordinate0= 0;
    public static int xCordinate1 = 0;
    public static int xCordinate2 = 0;
    private int[] iteratorCount = {0,0,0};
    
    private int currentPainting;
    public LabPanel(){
        paintings = new BufferedImage[3];
        currentPainting = 0;
        addKeyListener(this);
        setFocusable(true);
        setPreferredSize(new Dimension(500,500));
        
        


        for (int i = 0; i < 3; i++) {
            try {
                paintings[i] = ImageIO.read(new File("manzara" + i + ".jpeg"));
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        pixelsForPainting0 = giveValuesForBrightArray(paintings[0]);
        pixelsForPainting1 = giveValuesForBrightArray(paintings[1]);
        pixelsForPainting2 = giveValuesForBrightArray(paintings[2]);
        
        
        
        

    }
    public void paintComponent(Graphics g) {
        int widthOfCurrentImage = paintings[currentPainting].getWidth();
        int heightOfCurrentImage = paintings[currentPainting].getHeight();
        super.paintComponent(g);

        double resizing = 0;
        if(((double) getWidth() / widthOfCurrentImage) < ((double) getHeight() / heightOfCurrentImage)){
            resizing = (double) getWidth() / widthOfCurrentImage;
        }
        else{
            resizing =  (double) getHeight() / heightOfCurrentImage;
        }
        int newWidth = (int) (resizing * widthOfCurrentImage);
        int newHeight = (int) (resizing * heightOfCurrentImage);
        g.drawImage(paintings[currentPainting], 0, 0, newWidth, newHeight, this);
        if(currentPainting == 0){
            sort3(pixelsForPainting0, paintings[0], 0,startIndex0);
            //sort2(pixelsForPainting0, paintings[0], 0);
        }
        if(currentPainting == 1){
            sort3(pixelsForPainting1, paintings[1], 1,startIndex1);
            //sort2(pixelsForPainting1, paintings[1], 1);
        }
        if(currentPainting == 2){
            sort3(pixelsForPainting2, paintings[2], 2,startIndex2);
            //sort2(pixelsForPainting2, paintings[2], 2);
        }
        
       
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            changeImage(-1);

        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            changeImage(1);
            
            repaint();
            
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            if (currentPainting == 0) {
                startIndex0 = 0;
                xCordinate0= 0;
                
        
                try{
                paintings[currentPainting] = ImageIO.read(new File("manzara" + currentPainting + ".jpeg"));
                }
                catch (IOException e1) {
                e1.printStackTrace();
                }
                pixelsForPainting0 = giveValuesForBrightArray(paintings[0]);
            } 
            else if (currentPainting == 1) {
                startIndex1 = 0;
                xCordinate1= 0;
                
        
                try{
                    paintings[currentPainting] = ImageIO.read(new File("manzara" + currentPainting + ".jpeg"));
                }
                catch (IOException e2) {
                e2.printStackTrace();
                }
                pixelsForPainting1 = giveValuesForBrightArray(paintings[1]);
            } 
            else if (currentPainting == 2) {
                startIndex2 = 0;
                xCordinate2= 0;
                
                try{
                    paintings[currentPainting] = ImageIO.read(new File("manzara" + currentPainting + ".jpeg"));
                }
                catch (IOException e3) {
                e3.printStackTrace();
                }
                pixelsForPainting2 = giveValuesForBrightArray(paintings[2]);
            }
            iteratorCount[currentPainting] = 0;
            repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }
    public void sort(int[][] arr,BufferedImage img,int imgType,int startIndex){
        int width = arr.length;
        if(iteratorCount[imgType] < img.getHeight()){
            for(int i = startIndex; i < width; i ++){
                selectionSort(arr, i, iteratorCount[imgType], img);
        
            }
            if(iteratorCount[imgType] < img.getHeight() - 1){
                iteratorCount[imgType] = iteratorCount[imgType] + 1;
            }
        }
        if(imgType == 0){
            startIndex0++;
        }
        if(imgType == 1){
            startIndex1++;
        }
        if(imgType == 2){
            startIndex2++;
            
        }
        repaint();
    }
    public void sort3(int[][] arr,BufferedImage img,int imgType,int startIndex){
        int width = arr.length;
        if(iteratorCount[imgType] < Math.min(img.getHeight(), img.getWidth())){
            for(int i = startIndex; i < width; i ++){
                selectionSort(arr, i, iteratorCount[imgType], img);
            }
            for (int i = startIndex; i < arr[0].length; i++) {
                selectionSort3(arr, i, iteratorCount[imgType], img);
            }
            if(iteratorCount[imgType] < Math.min(img.getHeight(), img.getWidth())){
                iteratorCount[imgType] = iteratorCount[imgType] + 1;
            }
        }
        if(imgType == 0){
            startIndex0++;
        }
        if(imgType == 1){
            startIndex1++;
        }
        if(imgType == 2){
            startIndex2++;
            
        }
        repaint();
    }
    public void sort2(int[][] arr,BufferedImage img,int imgType){
        int limiter = 0;
        if(imgType == 0){
            limiter = xCordinate0;
        }
        if(imgType == 1){
            limiter = xCordinate1;
        }
        if(imgType == 2){
            limiter = xCordinate2;
        }
        int height = img.getHeight();
        
        if(iteratorCount[imgType] < img.getHeight()){
            for(int i = iteratorCount[imgType] + 1; i < height; i ++){
                selectionSort2(arr,iteratorCount[imgType], img,limiter);
                
            }
        if(imgType == 0){
            xCordinate0++;
        }
        if(imgType == 1){
        xCordinate1++;
        }
        if(imgType == 2){
            xCordinate2++;
        }
            //iteratorCount[imgType] = iteratorCount[imgType] + 1;
        }
        repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    private void changeImage(int direction) {
        if(direction == 1){
            if(currentPainting == 2){
                currentPainting = 0;
            }
            else{
                currentPainting += direction;
            }
        }
        else{
            if(currentPainting == 0){
                currentPainting = 2;
            }
            else{
                currentPainting += direction;
            }
        }
        
        repaint();
        
    }
    private int calculateBrightness(int rgb) {
        Color color = new Color(rgb);
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        return (int) (0.2126 * red + 0.7152 * green + 0.0722 * blue);
    }
    private int[][] giveValuesForBrightArray(BufferedImage image){
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] pixelsArray = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                int brightness = calculateBrightness(rgb);
                pixelsArray[x][y] = brightness;
            }
        }
        return pixelsArray;
    }
    private void selectionSort(int[][] arr,int n,int iteration,BufferedImage img){
        //System.out.println("n: " + n + ", iteration: " + iteration + ", arr.length: " + arr.length + ", arr[0].length: " + arr[0].length);
        int maxBright = arr[n][iteration];
        int maxX = n;
        int maxY = iteration;
        int minLength = Math.min(arr.length, arr[0].length);
        

        for(int i = 0; i < minLength ; i ++){
            if(((n+i) < arr.length) && ((iteration+ i) < arr[0].length)){
                if(arr[n+i][iteration+i] > maxBright){
                    maxBright = arr[n+i][iteration+i];
                    maxX = n + i;
                    maxY = iteration + i;
                }
            }
            
        }
        int tempBright = arr[n][iteration];
        arr[n][iteration] = arr[maxX][maxY];
        arr[maxX][maxY] = tempBright;
        int tempRGB = img.getRGB(n, iteration);
        img.setRGB(n, iteration, img.getRGB(maxX, maxY));
        img.setRGB(maxX, maxY, tempRGB);
        
    }
    private void selectionSort3(int[][] arr,int n,int iteration,BufferedImage img){
        //System.out.println("n: " + n + ", iteration: " + iteration + ", arr.length: " + arr.length + ", arr[0].length: " + arr[0].length);
        int maxBright = arr[iteration][n];
        int maxX = iteration;
        int maxY = n;
        int minLength = Math.min(arr.length, arr[0].length);
        

        for(int i = 0; i < minLength ; i ++){
            if(((n+i) < arr[0].length) && ((iteration+ i) < arr.length)){
                if(arr[iteration+i][n+i] > maxBright){
                    maxBright = arr[iteration+i][n + i];
                    maxY = n + i;
                    maxX = iteration + i;
                }
            }
            
        }
        int tempBright = arr[iteration][n];
        arr[iteration][n] = arr[maxX][maxY];
        arr[maxX][maxY] = tempBright;
        int tempRGB = img.getRGB(iteration, n);
        img.setRGB(iteration, n, img.getRGB(maxX, maxY));
        img.setRGB(maxX, maxY, tempRGB);
        
    }
    private void selectionSort2(int[][] arr,int iteration,BufferedImage img,int xCordinate){
        //System.out.println("n: " + n + ", iteration: " + iteration + ", arr.length: " + arr.length + ", arr[0].length: " + arr[0].length);
        int maxBright = arr[xCordinate][iteration];
        int maxX = xCordinate;
        int maxY = iteration;
        
        int xIterator = xCordinate;
        int yIterator = iteration;
        while((xIterator < img.getWidth()) && (yIterator < img.getHeight())){
        
                if(arr[xIterator][yIterator] > maxBright){
                    maxBright = arr[xIterator][yIterator];
                    maxX = xIterator;
                    maxY = yIterator;
                
            }
            xIterator++;
            yIterator++;

        }

        
        int tempBright = arr[xCordinate][iteration];
        arr[xCordinate][iteration] = arr[maxX][maxY];
        arr[maxX][maxY] = tempBright;
        int tempRGB = img.getRGB(xCordinate,iteration);
        img.setRGB(xCordinate, iteration, img.getRGB(maxX, maxY));
        img.setRGB(maxX, maxY, tempRGB);
        
    }


    
}
