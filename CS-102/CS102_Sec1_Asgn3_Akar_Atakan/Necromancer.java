import java.util.ArrayList;
import java.util.Random;

public class Necromancer extends Unit{

    public Necromancer(){
        level = 1;
        
        health = getMaxHealth();
        name = "Necromancer";
    }
   
    @Override
    public int getAttack() {
        
        return level;
    }

    @Override
    public int getMaxHealth() {
       
        return level + 1;
    }
    @Override
    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        arenaOpponent.damage(getAttack());
        System.out.println("Necromancer damaged arena opponent by " + getAttack());
        
    }

    @Override
    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        Unit temp = getRandomUnit(allyWaiting, true);
        if(temp != null){
            temp.revive();
            System.out.println("Necromancer revived " + temp.name);
        }
        else{
            this.damage(1);
            System.out.println("Necromencer decreased his health by 1 ");
        }
        
    }

    @Override
    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        arenaOpponent.decreaseLevel();
        
    }
    
}
