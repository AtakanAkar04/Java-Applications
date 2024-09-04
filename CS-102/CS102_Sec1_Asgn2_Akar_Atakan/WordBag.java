
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WordBag {

    private ArrayList<Word> allWords = new ArrayList<Word>();
    
    static Word startingWord = new Word("<START>");
    static Word endingWord = new Word("<END>");
    
    public WordBag(){
        allWords.add(startingWord);
        allWords.add(endingWord);
    }
    

    public Word findOrCreate(String wordText){
        for(int i = 0; i < allWords.size(); i++){
            if(allWords.get(i).getText().equals(wordText)){
                return allWords.get(i);
            }            
        }
        Word w = new Word(wordText);
        allWords.add(w);
        return w;
    }
    public void processSentence(String sentence){
        sentence = startingWord + " " + sentence;
        sentence = sentence + " " + endingWord;
        String[] words = sentence.split(" ");
        Word previous = startingWord;
        for(int i = 1; i < words.length; i++){
            Word current = findOrCreate(words[i]);
            if(previous.doesExist(current)){
                previous.addFollowedBy(current);
            }
            previous = current;
        }

    }
    public String generateSentence(int softLimit, int hardLimit){
        String sentence = "";
        int wordCounter = 0;
        Word lastAdded = startingWord;
        Word newlyAdded;

        while (wordCounter < hardLimit){
            if(wordCounter < softLimit){
                
                newlyAdded = lastAdded.getRandomWord();
                
                if(newlyAdded.getText().equals(endingWord.getText())){
                    if(lastAdded.getCanBeFollowedBy().size() < 2){
                        return sentence;
                    }
                    else{
                        do{
                            newlyAdded = lastAdded.getRandomWord();
                            
                        }while(newlyAdded.getText().equals(endingWord.getText()));
                    }
                }
                    
                
                sentence += newlyAdded.getText();

                lastAdded = newlyAdded;
                sentence += " ";
                
            }
            else if( wordCounter >= softLimit){
                if(lastAdded.isEndingWord()){
                    return sentence;
                }
                else{
                    
                    sentence += " ";
                
                    
                    newlyAdded= lastAdded.getRandomWord();
                    
                    
                    sentence += newlyAdded.getText();
                    lastAdded = newlyAdded;
                    
                    
                }
            }
            
            wordCounter++;
        }
        return sentence;
    }
    public void writeToTextFile(String outputName, int sentenceCount, int softLimit, int hardLimit){
        for(int i = 0; i < sentenceCount; i++){
            String sen = generateSentence(softLimit, hardLimit);
            try {
                // open the output writer
                FileWriter writer = new FileWriter(outputName,true);

                // write into file
                writer.write(sen);
                writer.write("\n");
                // in the end we need to close the file
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public ArrayList<Word> getList(){
        return allWords;
    }

}


