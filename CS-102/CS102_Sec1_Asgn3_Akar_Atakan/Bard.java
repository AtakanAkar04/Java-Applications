import java.util.ArrayList;

public class Bard extends Unit{

   public Bard(){
        level = 1;
        health = getMaxHealth();
        name = "Bard";
   }

    @Override
    public int getAttack() {
        
        return level;
    }

    @Override
    public int getMaxHealth() {
        
        return level;
    }
    @Override
    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        arenaOpponent.damage(getAttack());   
        System.out.println("Bard damaged arena opponent by " + getAttack());
    }
    @Override
    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        if(getMaxHealth() == health){
            System.out.println("Bard couldn't heal himself since itt health is full");
        }
        else if(health <= 0){
            System.out.println("Bard couldn't heal himself since he is dead");
            
        }
        else{
            this.heal(1);
            System.out.println("Bard healed himself by 1");
        }
    }

    @Override
    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        getRandomUnit(allyWaiting, false).increaseLevel();
        
    }
    
}
