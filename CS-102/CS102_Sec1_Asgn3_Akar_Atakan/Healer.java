import java.util.ArrayList;

public class Healer extends Unit{

   public Healer(){
        level = 1;
        health = getMaxHealth();
        
        name = "Healer";
   }

    @Override
    public int getAttack() {

        return level;
    }

    @Override
    public int getMaxHealth() {
        // TODO Auto-generated method stub
        return level + 2;
    }

     @Override
    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        if(health == getMaxHealth()){
            Unit temp = getRandomUnit(allyWaiting, false);
            if(temp != null){
                temp.heal(level);
                System.out.println("Healer healed " + temp.name + " by " + level );
            }
            else{
                System.out.println("Couldn't heal anyone since there are no alive allies");
            }
        }
        else if(isDead){
            System.out.println("Healer cannot heal self due to being dead");
        }
        else{
            if (health < getMaxHealth()){
                heal(level);
                System.out.println("Healer healed himself by " + level);
            }
                
        }
    }

    @Override
    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        arenaOpponent.damage(getAttack());
        System.out.println("Healer damaged arena opponent by " + getAttack());
        
    }

    @Override
    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {
        Unit temp = getRandomUnit(allyWaiting,true);
        if(temp != null){
            temp.revive();
            System.out.println("Healer revived " + temp.name);
        }
        else{
            System.out.println("Healer couldn't revived anyone becacuse there was no dead ally");
        }
        
    }
    
}
