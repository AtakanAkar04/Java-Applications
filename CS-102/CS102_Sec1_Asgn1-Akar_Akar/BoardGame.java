import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
 * BoardGame
 */
public class BoardGame {
    public static boolean control(int[] t1,  int[] t2, Player p){
        
        for(int i = 0; i < 2; i++){
            if((p.getHeightCor() == t1[1] && p.getWidthCor() == t1[0])){
                Board.deactivateTrap(t1);
                p.incrementTotalTraps();
                return false;
            }
            else if(p.getHeightCor() == t2[1] && p.getWidthCor() == t2[0]){
                Board.deactivateTrap(t2);
                p.incrementTotalTraps();
                return false;
            }
        }
        return true;
    }
    public static void breakTieAndOrder(ArrayList<Player> liste){
        int order = 1;
        Random rand = new Random();
        

        for(int i = 6; i >= 1; i--){
            int sameDiceNum = 0;
            for(int j = 0; j < liste.size(); j++){
                if( liste.get(j).getDiceNum() == i){
                    liste.get(j).setQueue(order);
                    sameDiceNum++;
                    
                }
            }
            order += sameDiceNum;
        }
        for(int i = 1; i <= 3; i++){
            ArrayList<Integer> sameOrderPlayerIndex = new ArrayList<Integer>();
            ArrayList<Player> sameOrderPlayer = new ArrayList<Player>();
            
            for(int j = 0; j < liste.size(); j++){
                if(liste.get(j).getQueue() == i  ){
                    sameOrderPlayer.add(liste.get(j));
                    sameOrderPlayerIndex.add(j);
                    
                }
                
            }
            if (sameOrderPlayer.size() > 1){
                System.out.print("Breaking tie for: ");
                for(int f = 0; f < sameOrderPlayer.size(); f++){
                    System.out.print(sameOrderPlayer.get(f).getSymbol() + " ");
                }
                
                for(int j = sameOrderPlayer.size() + i - 1; j >= i ; j--){
                    boolean doesMatch = false;
                    
                        do{
                            doesMatch = false;
                            int index = rand.nextInt(sameOrderPlayer.size());
                            int oldTurn = sameOrderPlayer.get(index).getQueue();
                            sameOrderPlayer.get(index).setQueue(j);
                            if(oldTurn > sameOrderPlayer.get(index).getQueue()){
                                sameOrderPlayer.get(index).setQueue(oldTurn);
                                doesMatch = true;
                            }
                            
                        }while(doesMatch);

                }
                System.out.println();
            }

            
        }
        
        boolean cont = true;
        while(cont){
            boolean swapped = false;
            for ( int i = 0; i < liste.size() - 1 ; i++){
                if(liste.get(i).getQueue() > liste.get(i+1).getQueue()){
                    Player temp = liste.get(i);
                    liste.set(i,liste.get(i+1) );
                    liste.set(i+1,temp );
                    swapped = true;
                }
            }
            if(!swapped){
                cont = false;
            }
        }
    }

    public static void main(String[] args) {
        boolean playAgain = true;
        int numPlayer = 0;
        int height = 0;
        int width = 0;

        ArrayList<Player> players = new ArrayList<Player>();
        
        Random rand = new Random();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the board game.");
        while(playAgain){
            Player player1 = new Player("a");
            Player player2 = new Player("a");
            Player player3 = new Player("a");
            Player player4 = new Player("a");

            System.out.print("Please enter board width:");
            width = scanner.nextInt();
            System.out.print("\nPlease enter board height:");
            height = scanner.nextInt();

            do{
                System.out.print("\nHow many players? (2-4)");
                numPlayer = scanner.nextInt();
                if(numPlayer < 2 || numPlayer > 4){
                    System.out.println("\nInvalid number");
                }

            }while(numPlayer < 2 || numPlayer > 4 );
            if(numPlayer == 2){
                players.add(player1);
                players.add(player2);
            }
            if(numPlayer == 3){
                players.add(player1);
                players.add(player2);
                players.add(player3);
            }
            if(numPlayer == 4){
                players.add(player1);
                players.add(player2);
                players.add(player3);
                players.add(player4);
            }


            System.out.print("Please enter a character (symbol) for each player.");

            for(int i = 1; i <= numPlayer; i++){
                System.out.print("\nFor player " + i + ":" );
                String name = scanner.next();
                players.get(i-1).setSymbol(name);
            }
            for(int i = 0; i < numPlayer ; i++){
                players.get(i).setDiceNum(rand.nextInt(6)+1);
            }
            

            System.out.println("Players are rolling dice...");
            for(int i = 0; i < numPlayer; i++){
                System.out.print(players.get(i).getSymbol() + ":" + " " + players.get(i).getDiceNum() + " ");
                
            }
            System.out.println();

            breakTieAndOrder(players);
            for(int i = 0; i < players.size(); i++){
                players.get(i).updateCorInBox(players.get(i).getQueue());
            }

            Board board = new Board(width, height, players);
            int roll = 0;
            int choice = 0;
            boolean is = false;
            board.displayBoard();
            while (!is){
                for(int i = 0; i < players.size() && !is; i++ ){                        
                    roll = rand.nextInt(6) + 1;
                    System.out.printf("Player %s rolls, %d how many cells you move? (0-%d):", players.get(i).getSymbol(),roll,roll);
                    choice = scanner.nextInt();
                    for(int k = choice; k > 0 ;k--){

                        if(players.get(i).getWidthCor() < width && players.get(i).getHeightCor() == 1){
                            int updated = players.get(i).getWidthCor();
                            updated ++;
                            players.get(i).setWidthCor(updated);
                        }
                        else if(players.get(i).getWidthCor() == 1 && players.get(i).getHeightCor() == 1){
                            int updated = players.get(i).getWidthCor();
                            updated ++;
                            players.get(i).setWidthCor(updated);
                        }
                        else if(players.get(i).getWidthCor() == width && players.get(i).getHeightCor() == 1){
                            int updated = players.get(i).getHeightCor();
                            updated ++;
                            players.get(i).setHeightCor(updated);
                        }
                        else if(players.get(i).getWidthCor() == width && players.get(i).getHeightCor() < height){
                            int updated = players.get(i).getHeightCor();
                            updated ++;
                            players.get(i).setHeightCor(updated);
                        }
                        else if(players.get(i).getWidthCor() == width && players.get(i).getHeightCor() == height){
                            int updated = players.get(i).getWidthCor();
                            updated --;
                            players.get(i).setWidthCor(updated);
                        }
                        else if(players.get(i).getWidthCor() > 1 && players.get(i).getHeightCor() == height){
                            int updated = players.get(i).getWidthCor();
                            updated --;
                            players.get(i).setWidthCor(updated);
                        }
                        else if(players.get(i).getWidthCor() == 1 && players.get(i).getHeightCor() == height){
                            int updated = players.get(i).getHeightCor();
                            updated --;
                            players.get(i).setHeightCor(updated);
                        }
                        else if(players.get(i).getWidthCor() == 1 && players.get(i).getHeightCor() < height){
                            int updated = players.get(i).getHeightCor();
                            updated --;
                            players.get(i).setHeightCor(updated);
                        }
                        if(players.get(i).getWidthCor() == 1 && players.get(i).getHeightCor() == 2){
                            is = true;
                            System.out.printf("Winner is %s, congratulations!\n",players.get(i).getSymbol());
                        }
                        players.get(i).incrementTotalMoves();
                        board.setPlayersCordinates(board.getCordinatesPlayers(),players);
                    }
                    if(!is){
                        if(!(control(board.getTrap1Cor(),board.getTrap2Cor(),players.get(i)))){
                            if(players.get(i).getHeightCor() == 1 ){
                                players.get(i).setWidthCor(1);
                            }
                            else if(players.get(i).getWidthCor() == width ){
                                players.get(i).setHeightCor(1);
                            }
                            else if(players.get(i).getHeightCor() == height ){
                                players.get(i).setWidthCor(width);
                            }
                            else if(players.get(i).getWidthCor() == 1 ){
                                players.get(i).setHeightCor(height);                            
                            }
                            board.setPlayersCordinates(board.getCordinatesPlayers(),players);
                            
                            System.out.println("You moved into a trap!");
                            System.out.println("You moved back to the closest corner!");
                        }
                    }
                    if(!is){
                        board.displayBoard();
                    }
                }
            }

            System.out.printf("%-7s %-7s %-7s\n","Player", "Move", "Trap");

            for(int j = 0; j < players.size(); j++){
                System.out.printf("%-7s %-7d %-7d\n",players.get(j).getSymbol(),players.get(j).getTotalMoves(),players.get(j).getTotalTraps());
            }
            players.clear();
            System.out.print("Play Again? (Y/N)");
            String decision = scanner.next();
            if(decision.equals("N")){
                playAgain = false;
            }
            

        }
        System.out.println("Bye...");


    }
    
}