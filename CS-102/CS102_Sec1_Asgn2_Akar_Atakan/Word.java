
import java.util.ArrayList;
import java.util.Random;
public class Word {

    private String text;
    private ArrayList<Word> canBeFollowedBy;


    public Word(String text){
        this.text = text;
        canBeFollowedBy = new ArrayList<Word>();
    }
    public void addFollowedBy(Word w){
        canBeFollowedBy.add(w);
    }
    public String listToString(){
        String listRep = "";
        for(int i= 0; i < canBeFollowedBy.size();i++){
            listRep += canBeFollowedBy.get(i) + " ";
        }
        return listRep;
    }
    public String getText(){
        return text;
    }
    public void setText(String t){
        text = t;
    }
    public String toString(){
        return text;
    }
    public ArrayList<Word> getCanBeFollowedBy(){
        return canBeFollowedBy;
    }
    public boolean isEndingWord(){
        for(int i = 0; i < canBeFollowedBy.size(); i++){
            if(canBeFollowedBy.get(i).text.equals(WordBag.endingWord.text)){
                return true;
            }
        }
        return false;
    }
    public Word getRandomWord(){
        Random rand = new Random();
        int randIndex = rand.nextInt(this.canBeFollowedBy.size());
        return canBeFollowedBy.get(randIndex);
    }
    public boolean doesExist(Word w){
        for(int i = 0; i < canBeFollowedBy.size(); i++){
            if(this.canBeFollowedBy.get(i).getText().equals(w.text)){
                return false;
            }
        }
        return true;
    }
    


    


}
