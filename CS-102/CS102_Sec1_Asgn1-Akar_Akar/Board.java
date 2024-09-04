import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;



public class Board {
    private int totalBox;
    private int height;
    private int width;
    private int[][] cordinatesPlayers;
    private ArrayList<Player> listPlayers;
    private int[] trap1Cor;
    private int[] trap2Cor;
    

       

    public Board(int width, int height, ArrayList<Player> listPlyers){
        this.height = height;
        this.width = width;
        this.listPlayers = listPlyers;
        cordinatesPlayers = new int[listPlyers.size()][3];
        trap1Cor = new int[2];
        trap2Cor = new int[2];
        setRandomTraps(trap1Cor, trap2Cor);
        
        setPlayersCordinates(cordinatesPlayers, listPlyers);
    }

    public int getTotalBox() {
        return totalBox;
    }

    public void setTotalBox(int totalBox) {
        this.totalBox = totalBox;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
   
    public void displayBoard(){
        String mid ="";
        String horBorders = "";
        String line = "#";
        
        for(int i = 1; i < width; i++){
            horBorders += "###";
        }
        horBorders += "####";
        for(int k = 0; k < horBorders.length()-8;k++){
            mid += " ";
        }
        
        for(int i = 1; i <= width;i++){
            
            for(int k = 1; k <= 2; k++ ){
                if(isTherePlayer(i, 1, k, listPlayers) != null){
                    line += isTherePlayer(i, 1, k, listPlayers);
                }
                else{
                    line += " ";
                }
                
            }
            line += "#";
        }
        System.out.println(horBorders);
        System.out.println(line);
        line = "#";
        for(int i = 1; i <= width;i++){
            
            for(int k = 3; k <= 4; k++ ){
                if(isTherePlayer(i, 1, k, listPlayers) != null){
                    line += isTherePlayer(i, 1, k, listPlayers);
                }
                else{
                    line += " ";
                }
                
            }
            line += "#";
        }
        System.out.println(line);
        System.out.println(horBorders);
        for(int i = 1; i <= height - 2;i++){
            line = "#";
            for(int k = 1; k <= 2; k++){
                if(isTherePlayer(1, 1 + i, k, listPlayers) != null){
                    line += isTherePlayer(1, 1 + i , k, listPlayers);
                }
                else{
                    line += " ";
                }

            }
            line += "#";
            line += mid;
            line += "#";
            for(int k = 1; k <= 2; k++){
                if(isTherePlayer(width, 1 + i, k, listPlayers) != null){
                    line += isTherePlayer(width,  1 + i , k, listPlayers);
                }
                else{
                    line += " ";
                }

            }
            line += "#";
            System.out.println(line);
            line = "#";
            for(int k = 3; k <= 4; k++){
                if(isTherePlayer(1, i + 1, k, listPlayers) != null){
                    line += isTherePlayer(1, 1 + i, k, listPlayers);
                }
                else{
                    line += " ";
                }
            }
            line += "#";
            line += mid;
            line += "#";
            
            for(int k = 3; k <= 4; k++){
                if(isTherePlayer(width, i + 1, k, listPlayers) != null){
                    line += isTherePlayer(width, 1 + i, k, listPlayers);
                }
                else{
                    line += " ";
                }
            }
            line += "#";
            System.out.println(line);
        }
        System.out.println(horBorders);
        line = "#";
        for(int i = 1; i <= width;i++){
            
            for(int k = 1; k <= 2; k++ ){
                if(isTherePlayer(i, height, k, listPlayers) != null){
                    line += isTherePlayer(i, height, k, listPlayers);
                }
                else{
                    line += " ";
                }
                
            }
            line += "#";
        }
        System.out.println(line);
        line = "#";
        for(int i = 1; i <= width;i++){
            
            for(int k = 3; k <= 4; k++ ){
                if(isTherePlayer(i, height, k, listPlayers) != null){
                    line += isTherePlayer(i, height, k, listPlayers);
                }
                else{
                    line += " ";
                }
                
            }
            line += "#";
        }
         System.out.println(line);
        System.out.println(horBorders);

    }
    private void setRandomTraps(int[] trap1, int[] trap2){
        Random rand = new Random();
        boolean doesMatch = false;
        int widthTrap1;
        int widthTrap2;
        int heightTrap1;
        int heightTrap2;
        
        do{
            doesMatch = false;
            heightTrap1 = rand.nextInt(height) + 1;
            heightTrap2 = rand.nextInt(height) + 1;
            
            if(heightTrap1 == 1 || heightTrap1 == height){
                 widthTrap1 = rand.nextInt(width) + 1;
            }
            else{
                int m = rand.nextInt(2);
                if(m == 0){
                    widthTrap1 = 1;                   
                }
                else{
                    widthTrap1 = width;
                }
            }
            if(heightTrap2 == 1 || heightTrap2 == height){
                    widthTrap2 = rand.nextInt(width) + 1;
            }
            else{
                int m = rand.nextInt(2);
                if(m == 0){
                    widthTrap2 = 1;
                }
                else{
                    widthTrap2 = width;
                }
            }
            if((heightTrap1 == heightTrap2 && widthTrap1 == widthTrap2) || (heightTrap1 == 1 && widthTrap1 == 1) ||
             (heightTrap2 == 1 && widthTrap2 == 1) || (heightTrap1 == 1 && widthTrap1 == 1) || (heightTrap1 == 2
               && widthTrap1 == 1) || (heightTrap2 == 2 && widthTrap2 == 1) || (heightTrap2 == 1 && widthTrap2 == width) || (heightTrap1 == 1
               && widthTrap1 == width) || (heightTrap2 == height && widthTrap2 == width) || (heightTrap1 == height
               && widthTrap1 == width) || (heightTrap2 == height && widthTrap2 == 1) || (heightTrap1 == height && widthTrap1 == 1)){
                doesMatch = true;
            }
        }while(doesMatch);

        trap1[0] = widthTrap1;
        trap1[1] = heightTrap1;
        trap2[0] = widthTrap2;
        trap2[1] = heightTrap2;
    }
    public void setPlayersCordinates(int[][] listPlayers,ArrayList<Player> liste){
        for(int i = 0; i < liste.size(); i ++){
            listPlayers[i][0] = liste.get(i).getWidthCor();
            listPlayers[i][1] = liste.get(i).getHeightCor();
            listPlayers[i][2] = liste.get(i).getCorInBox();
        }
    }
    private String isTherePlayer(int w, int h, int b, ArrayList<Player> liste ){
        String temp;
        for(int i = 0; i < cordinatesPlayers.length;i++){
            if(w == cordinatesPlayers[i][0]){
                if(h == cordinatesPlayers[i][1]){
                    if(b == cordinatesPlayers[i][2]){
                        temp = liste.get(i).getSymbol();
                        return temp;
                    }
                }
            }
        }
        return null;
    }
    public int[] getTrap1Cor() {
        return trap1Cor;
    }

    public int[] getTrap2Cor() {
        return trap2Cor;
    }

    public static void deactivateTrap(int[] t){
        t[0] = 0;
        t[1] = 0;
    }
    public int[][] getCordinatesPlayers() {
        return cordinatesPlayers;
    }
    public void setCordinatesPlayers(int[][] cordinatesPlayers) {
        this.cordinatesPlayers = cordinatesPlayers;
    }
    
}
