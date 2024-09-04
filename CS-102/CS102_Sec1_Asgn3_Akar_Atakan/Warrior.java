import java.util.ArrayList;

public class Warrior extends Unit {
  
    public Warrior(){
        level = 1;
        
        health = getMaxHealth();
        name = "Warrior";
    }
    public int getAttack(){
        return level + 1;
    }
    @Override
    public int getMaxHealth() {
        return level + 2;
    }
    @Override
    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
       System.out.println("Warrior does nothing.");
        
    }
    @Override
    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        arenaOpponent.damage(this.getAttack());
        System.out.println("Warrior damaged arena opponent by " + getAttack());
        
    }
    @Override
    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        arenaOpponent.damage(this.getAttack());
        System.out.println("Warrior damaged arena opponent by " + getAttack());
    }
   
}
