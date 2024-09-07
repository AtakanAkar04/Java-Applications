import java.util.Random;
import java.util.Scanner;

public class Lab03_Q1 {
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

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        menuSelection = 0;
        word = "";
        encodedWord = "";
        wordToDecode = "";

        while ( menuSelection != 3 ){
            System.out.println("\n1)Encode Message");
            System.out.println("2)Decode Message");
            System.out.println("3)Quit");
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
                            lastDecodedWord = lastDecodedWord + decodedWord.charAt(indexOfControlledChar);

                        }
                        indexOfControlledChar++;


                    }
                    System.out.println("The decoded message is:" + lastDecodedWord);

                }
            }
            else if ( menuSelection == 3 ){
                System.out.println("Thank you, goodbye!");

            }
            else{
                System.out.println("Invalid choice - try again....");

            }
                  

        }
       
    }
}
