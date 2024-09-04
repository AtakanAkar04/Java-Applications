import java.util.ArrayList;

public class Rogue extends Unit{

   public Rogue(){
        level = 1;
        health = getMaxHealth();
        name = "Rogue";
   }

    @Override
    public int getAttack() {
        
        return level + 2;
    }

    @Override
    public int getMaxHealth() {
        return level;
    }

  
    @Override
    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        arenaOpponent.damage(getAttack());
        System.out.println("Rogue damaged arena opponent by " + getAttack());
    }
    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        arenaOpponent.damage(getAttack());
        System.out.println("Rogue damaged arena opponent by " + getAttack());
        
    }

    @Override
    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        Unit selected = getRandomUnit(enemyWaiting, false);
        if(selected != null){
            selected.damage(getAttack());
            System.out.println("Rogue damaged " + selected.name + " by " + getAttack());
        }
        else{
            System.out.println("Rogue couldn't atack to any enemy since all are dead");
        }
        
    }
    
}
