import java.util.ArrayList;

public class Archer extends Unit {
    public Archer(){
        level = 1;
        name = "Archer";
        health = getMaxHealth();
    }

   

    @Override
    public int getAttack() {
        
        return level + 1;
    }

    @Override
    public int getMaxHealth() {
        
        return level + 1;
    }

    
    @Override
    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        arenaOpponent.damage(getAttack());
        System.out.println("Archer damaged arena opponent by " + getAttack());
        
    }

    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        Unit selected = getRandomUnit(enemyWaiting,false);
        selected.damage(getAttack());
        System.out.println("Archer damaged waiting " + selected.name + " by " + getAttack());

        
    }

    @Override
    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        if(health == getMaxHealth()){
            System.out.println("Archer's health is already full");
        }
        else{
            if(!isDead){
                System.out.println("Archer increased his health by 1");
            }
            else{
                System.out.println("Archer couldn't heal himself since he is dead");
            }
        }
        this.heal(1);

    }
    
    
}
