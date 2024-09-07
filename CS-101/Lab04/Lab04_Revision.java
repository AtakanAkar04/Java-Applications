import java.util.Scanner;

public class Lab04_Revision {
   public static void main(String[] args) {
    String word;
    String convertedString;
    char convertedChar;
    char specialChar;
    int distanceToA;
    int codeOfChar;
    boolean isLower;

    
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter word to convert:");
    word = scanner.nextLine();
    isLower = true;
    convertedString = "";

    for ( int checkChar = 0; checkChar <  word.length(); checkChar++){
        if ( !Character.isLowerCase(word.charAt(checkChar))){
            isLower = false;
        }

    }
    if ( !isLower){
        System.out.println("Invalid input! Only enter lowercase letters.");

    }
    else{
        System.out.println("Length: " + word.length());
        if ( word.length() % 2 == 0){
            specialChar = word.charAt(0);

        }
        else{
            specialChar = word.charAt (word.length() / 2 );

        }
        System.out.println("Special letter: " + specialChar);
        distanceToA = specialChar - 'a';
        
        for ( int convertedLetter = 0; convertedLetter < word.length(); convertedLetter++){
            if ( word.charAt(convertedLetter) == specialChar){
                convertedString += "(";
            

            }
            else{
                codeOfChar = word.charAt(convertedLetter) + distanceToA;
                if ( codeOfChar > 122){
                    codeOfChar -= 26;
                    convertedChar = (char)codeOfChar;
                    convertedString += convertedChar;

                }
                else{
                    convertedChar = (char)codeOfChar;
                    convertedString += convertedChar;

                }
                
            }

        }
        System.out.println( convertedString);
    }
    scanner.close();
   }
}
