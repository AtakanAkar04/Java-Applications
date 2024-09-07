import java.util.Random;
import java.util.Scanner;

public class Lab03Revision {
    public static void main(String[] args) {
        int menuSelection;
        String word;
        int divider;
        String encodedWord;
        int numberOfRandomDigits;
        int randomWordIndex;
        int randomDigit;
        String wordToDecode;
        int placeOfSpace;
        String decodedWord;
        int indexOfControlledChar;
        String lastDecodedWord;
        String encoded2Word;
        int symbolPutter;
        String word2;
        String wordToDecode2;
        String lastDecoded2Word;
        int indexOfControlledChar2;
        String decodedWord2;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        menuSelection = 0;
        word = "";
        encodedWord = "";
        wordToDecode = "";
        wordToDecode2 = "";
        word2 = "";
        lastDecoded2Word = "";
        decodedWord2 = "";

        while ( menuSelection != 5 ){
            System.out.println("\n1)Encode Message");
            System.out.println("2)Decode Message");
            System.out.println("3)Encode2 Message");
            System.out.println("4)Decode2 Message");
            System.out.println("5)Quit");
            System.out.print("Enter choises:");
            menuSelection = scanner.nextInt();

            if ( menuSelection == 1 ){
                word = "";
                numberOfRandomDigits = 1;
                while ( word.length() < 2 ){
                    System.out.print("Enter word to encode:");
                    word = scanner.next();
                    if( word.length() < 2 ){
                    
                    System.out.println("Invalid length word - try again");
                    }
                }
                encodedWord = word;
                while ( numberOfRandomDigits <= word.length() ){
                    randomWordIndex = random.nextInt(word.length());
                    randomDigit = random.nextInt(10);
                    encodedWord = encodedWord.substring(0,randomWordIndex ) + randomDigit + encodedWord.substring(randomWordIndex);
                    numberOfRandomDigits++;

                }
                divider = random.nextInt(1, encodedWord.length());
                encodedWord = encodedWord.substring(divider) + " " +  encodedWord.substring(0, divider);
                System.out.println("Encoded message: " + encodedWord);
                wordToDecode = encodedWord;
                
            }
            else if ( menuSelection == 2){
                if ( word.length() == 0 ){
                    System.out.println("No message to decode....");
                }
                else{
                    placeOfSpace = wordToDecode.indexOf(" ");
                    decodedWord = wordToDecode.substring(placeOfSpace+1) + wordToDecode.substring(0, placeOfSpace);
                    indexOfControlledChar = 0;
                    lastDecodedWord = "";
                    while ( indexOfControlledChar < (decodedWord.length()) ){
                        if( Character.isLetter(decodedWord.charAt(indexOfControlledChar)) ){
                            lastDecodedWord=lastDecodedWord + decodedWord.charAt(indexOfControlledChar);

                        }
                        indexOfControlledChar++;


                    }
                    System.out.println("The decoded message is:" + lastDecodedWord);

                }
            }
            else if ( menuSelection == 3){
                word2 = "";
                while ( word2.length() < 2 ){
                    System.out.print("Enter word to encode:");
                    scanner.nextLine();
                    word2 = scanner.nextLine();
                    if( word2.length() < 2 ){
                    
                    System.out.println("Invalid length word - try again");
                    }
                }
                encoded2Word = "";
                symbolPutter = 0;
                if ( word2.length() == 2){
                    encoded2Word = word2.substring(0, 1) + "*" + word2.substring(1);
                }
                else if ( word2.length() > 2){
                    word2 = word2.substring(word2.length()-2) + word2.substring(0,word2.length()-2);
                    while ( symbolPutter < word2.length()-1 ){
                        if ( Character.isLetter(word2.charAt(symbolPutter)) && Character.isLetter(word2.charAt(symbolPutter+1))){
                            encoded2Word = encoded2Word + word2.charAt(symbolPutter) + "*";

                        }
                        else{
                            encoded2Word = encoded2Word + word2.charAt(symbolPutter);
                        }
                        symbolPutter++;
                    }
                    encoded2Word = encoded2Word + word2.charAt(word2.length()-1);
                }
            System.out.println("Encoded message2: " + encoded2Word);
            wordToDecode2=encoded2Word;  



            }
            else if ( menuSelection == 4 ){
                lastDecoded2Word = "";
                indexOfControlledChar2 = 0;
                decodedWord2 = "";
                if ( word2.length() == 0){
                    System.out.println("No message to decode2....");
                }
                else if ( wordToDecode2.length() == 3){
                    lastDecoded2Word = lastDecoded2Word + wordToDecode2.charAt(0) + wordToDecode2.charAt(2);
                }
                
                if ( wordToDecode2.length() > 3 ){
                    while ( indexOfControlledChar2 < wordToDecode2.length()){
                        if ( Character.isLetter(wordToDecode2.charAt(indexOfControlledChar2)) || Character.isWhitespace(wordToDecode2.charAt(indexOfControlledChar2))){
                            decodedWord2 = decodedWord2 + wordToDecode2.charAt(indexOfControlledChar2);

                        }
                        indexOfControlledChar2++;
                    }
                    
                    lastDecoded2Word = decodedWord2.substring(2) + decodedWord2.substring(0, 2);
                    
                }
                System.out.println("Decoded message2: " + lastDecoded2Word);

            }
            else if ( menuSelection == 5 ){
                System.out.println("Thank you, goodbye!");

            }
            else{
                System.out.println("Invalid choice - try again....");

            }
                  

        }
    }
}
