import java.util.ArrayList;
import java.util.Random;

public abstract class Unit{
    protected String name;
    protected int health;
    protected int level;
    protected boolean isDead;
    

    

    public abstract int getAttack();
    public abstract int getMaxHealth();
    public abstract void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting);
    public abstract void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting);
    public abstract void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting);

    
    
    public void damage(int damageAmount){
        health -= damageAmount;
        if(health <= 0){
            isDead = true;
            System.out.print(name + " is dead ");
        }
    }
    public void increaseLevel(){
        level++;
        
        System.out.println(name + " levels up");
    }
    public void decreaseLevel(){
        if(level > 1){
            level--;
            
        }
    }
    public void revive(){
        if(isDead != false){
            isDead = false;
            decreaseLevel();
            health = getMaxHealth();
            
        }
    }
    public void heal(int healAmount){
        for(int i = 0; i < healAmount;i++){
            if(this.getMaxHealth()>health){
                health ++;
            }
        }
    }
    public String getInfo(){
        String details = ""+ name + ", LVL: " + level + ", ATK: " + this.getAttack() + ", HEALTH: " + health + "/" + getMaxHealth() ;
        return details;
    }
    public Unit getRandomUnit(ArrayList<Unit> liste,boolean is){
        boolean doesExits = false;
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        
            for(int i = 0; i < liste.size(); i++){
                if(liste.get(i).isDead == is){
                    doesExits = true;
                    indexes.add(i);
                }
            }
            if(doesExits){
                Random rand = new Random();
                int index = rand.nextInt(indexes.size());
                return liste.get(index);
            }
            else{
                return null;
            }
                
    }
    public String toString(){
        return name;
    }

}