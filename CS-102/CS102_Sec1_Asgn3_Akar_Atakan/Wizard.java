import java.util.ArrayList;

public class Wizard extends Unit {

   public Wizard(){
        level = 1;
       
        health = getMaxHealth();
        name = "Wizard";
   }

    @Override
    public int getAttack() {
        
        return 1;
    }

    @Override
    public int getMaxHealth() {
        
        return level + 2;
    }
    @Override
    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        System.out.println("Wizard does nothing.");
        
    }
    @Override
    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        System.out.println("Wizard does nothing.");
        
    }

    @Override
    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        
        for(int i = 0; i < enemyWaiting.size(); i++){
            if(!(enemyWaiting.get(i).isDead)){
                enemyWaiting.get(i).damage(getAttack());
                System.out.println("Wizard damaged " + enemyWaiting.get(i).name + " by " + getAttack() );
                
            }

        }
        
        
    }
    
}
