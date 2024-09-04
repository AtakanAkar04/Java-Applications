import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena {
    protected ArrayList<Unit> playerUnits;
    protected ArrayList<Unit> computerUnits;

    public Arena(){
        playerUnits = new ArrayList<Unit>();
        computerUnits = new ArrayList<Unit>();

        fillWithRandomUnits(playerUnits);
        fillWithRandomUnits(computerUnits);
    }

    private void fillWithRandomUnits(ArrayList<Unit> liste){
        Random rand = new Random();
        liste.add(new Warrior());
        int count = 1;
        while(count < 7){
            int num = rand.nextInt(7);
            if(num == 0){
                liste.add(new Warrior());
            }
            else if(num==1){
                liste.add(new Archer());
            }
             else if(num==2){
                liste.add(new Healer());
            }
             else if(num==3){
                liste.add(new Rogue());
            }
             else if(num==4){
                liste.add(new Wizard());
            }
             else if(num==5){
                liste.add(new Bard());
            }
             else if(num==6){
                liste.add(new Necromancer());
            }
            count++;
        }
    }
    public void battle(int playerIndex, int computerIndex){
        int totalDeath1;
        int totalDeath2;

        Unit tempPlayer = playerUnits.get(playerIndex);
        Unit tempComputer = computerUnits.get(computerIndex);
        boolean is = true;
        playerUnits.remove(playerIndex);
        computerUnits.remove(computerIndex);
        totalDeath1 = difference(playerUnits);
        totalDeath2 = difference(computerUnits);
        System.out.print("\nPlayer:");
        tempPlayer.firstPhase(tempComputer, playerUnits, computerUnits);
        System.out.print("Computer:");
        tempComputer.firstPhase(tempPlayer, computerUnits, playerUnits);
        if((difference(playerUnits) > totalDeath1) && !tempComputer.isDead){
            for(int i = 0; i < difference(playerUnits)-totalDeath1;i++){
                tempComputer.increaseLevel();
            }
        }
        if((difference(computerUnits) > totalDeath2) && !tempPlayer.isDead){
            for(int i = 0; i < difference(computerUnits)-totalDeath2;i++){
                tempPlayer.increaseLevel();
            }
        }
        if(!(tempComputer.isDead) && !(tempPlayer.isDead)){
            totalDeath1 = difference(playerUnits);
            totalDeath2 = difference(computerUnits);
            System.out.print("\nPlayer:");
            tempPlayer.secondPhase(tempComputer, playerUnits, computerUnits);
            System.out.print("Computer:");
            tempComputer.secondPhase(tempPlayer, computerUnits, playerUnits);
            
            if((difference(playerUnits) > totalDeath1) && !tempComputer.isDead){
                for(int i = 0; i < difference(playerUnits)-totalDeath1;i++){
                    tempComputer.increaseLevel();
                }
            }
            if((difference(computerUnits) > totalDeath2) && !tempPlayer.isDead){
                for(int i = 0; i < difference(computerUnits)-totalDeath2;i++){
                    tempPlayer.increaseLevel();
                }
            }
        }
        else{
            System.out.println("Battle ended in phase 1");
            is = false;
        }
        if(!(tempComputer.isDead) && !(tempPlayer.isDead)){
            totalDeath1 = difference(playerUnits);
            totalDeath2 = difference(computerUnits);
            System.out.print("\nPlayer:");
            tempPlayer.thirdPhase(tempComputer, playerUnits, computerUnits);
            System.out.print("Computer:");
            tempComputer.thirdPhase(tempPlayer, computerUnits, playerUnits);
             if((difference(playerUnits) > totalDeath1) && !tempComputer.isDead){
            for(int i = 0; i < difference(playerUnits)-totalDeath1;i++){
                tempComputer.increaseLevel();
            }
        }
        if((difference(computerUnits) > totalDeath2) && !tempPlayer.isDead){
            for(int i = 0; i < difference(computerUnits)-totalDeath2;i++){
                tempPlayer.increaseLevel();
            }
        }
        }
        else if(is){
            System.out.println("Battle ended in phase 2");
            is = false;
        }
        if(tempPlayer.isDead){
            if(!(tempComputer.isDead)){
               
                tempComputer.increaseLevel();;
            }
        }
        if(tempComputer.isDead){
            if(!(tempPlayer.isDead)){
                
                tempPlayer.increaseLevel();;
            }
        }
        if(is){
            System.out.println("Battle ended in phase 3");
        }
        playerUnits.add(tempPlayer);
        computerUnits.add(tempComputer);

    }
    public boolean finishGame(ArrayList<Unit> list,ArrayList<Unit> list2){
        boolean first = true;
        boolean second = true;
        for(int i = 1; i < list.size();i++){
            if(list.get(i).isDead == false){
                first = false;
            }
        }
        for(int i = 1; i < list.size();i++){
            if(list2.get(i).isDead == false){
                second = false;
            }
        }
        if(first || second){
            return true;
        }
        else{
            return false;
        }
    }
    public String displayHand(ArrayList<Unit> list){
        String text = "";
        for(int i = 0; i < list.size(); i++){
            int k = i+ 1;
            text += k + ". " + list.get(i).getInfo() + "\n";
        }
        return text;
    }
    public int difference(ArrayList<Unit> a){
        int count = 0;
        for(int i = 0; i < a.size();i++){
            if(a.get(i).isDead){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int turn = 1;
        Arena arena = new Arena();
        while(!(arena.finishGame(arena.playerUnits,arena.computerUnits))){
            System.out.println("Turn:" + turn);
            System.out.println("Computer's Unit:");
            System.out.println(arena.displayHand(arena.computerUnits));
            System.out.println("Player's Unit");
            System.out.println(arena.displayHand(arena.playerUnits));
            

            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int choose;
            do{ 
                System.out.print("Which unit you choose:");
                choose = scanner.nextInt();
                choose--;
                if(arena.playerUnits.get(choose).isDead){
                    System.out.println("Not valid Index");
                }
            }while(arena.playerUnits.get(choose).isDead);
            
            System.out.println("You choose " + arena.playerUnits.get(choose).name + ", " + arena.playerUnits.get(choose).getInfo());
            int randIndex;
            do{
                randIndex = random.nextInt(arena.computerUnits.size());
            }while(arena.computerUnits.get(randIndex).isDead);
            System.out.println("Computer chooses " + arena.computerUnits.get(randIndex).name + ", " + arena.computerUnits.get(randIndex).getInfo());
            arena.battle(choose, randIndex);
            

            turn++;
        }
        boolean playerWin = true;
        boolean computerWin = true;
        
        for(int i = 0; i < 7;i++){
            if(!(arena.computerUnits.get(i).isDead)){
                playerWin = false;
            }

        }
        for(int i = 0; i < 7;i++){
            if(!(arena.playerUnits.get(i).isDead)){
                computerWin = true;
            }

        }
        if(playerWin && computerWin){
            System.out.println("It finished in a tie");
        }
        else if ( playerWin){
            System.out.println("Player wins");
        }
        else if( computerWin){
            System.out.println("Computer wins");
        }
        
    }

}
