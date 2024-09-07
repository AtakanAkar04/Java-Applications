import java.util.Scanner;

public class Lab04_Q3 {
    public static void main(String[] args) {
        String word;
        String convertedWord;

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("\nEnter word to convert:");
            word = scanner.nextLine();
            convertedWord = "";

            if (!word.equalsIgnoreCase("exit")){
                for ( int i = 0; i < word.length(); i++){
                    if (Character.isLetter(word.charAt(i))){
                        
                        if ( word.indexOf(word.charAt(i)) == i && word.indexOf(word.charAt(i),i+1) == -1){
                            convertedWord += "(";
                        }
                        else{
                            convertedWord += ")";
                        }
                    }
                    else{
                        convertedWord = convertedWord + "*";
                    }
                    
                    


                }
                System.out.printf("Original word: %-10sConverted word: %s",word,convertedWord);
            }

            




        }while( !word.equalsIgnoreCase("exit"));
        
    scanner.close();
    }
}
