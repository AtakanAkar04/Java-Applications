import java.util.Scanner;

public class Lab05_Q2 {
    static final String KEY = "a@bpdqi!l1mwnuo0s5t+z2A4B8E3G6WM";

    public static char convertChar( char character){
        char convertedChar;
        String charToConvert;
        charToConvert = "" + character;

        if ( (KEY.indexOf(charToConvert) != -1) && KEY.indexOf(charToConvert) % 2 == 0){
            convertedChar = KEY.charAt(KEY.indexOf(charToConvert)+1);
        }
        else{
            convertedChar = character;
        }
        return convertedChar;
    }

    public static String convertText( String text){
        String convertedText;
        convertedText = "";
        for ( int i = 0; i < text.length(); i++){
            char letter = text.charAt(i);
            convertedText += convertChar(letter);
        }
        return convertedText;
    }

    public static int countNumbers( String wordToCount){
        int count;
        count = 0;
        for ( int j = 0; j < wordToCount.length(); j++){
            if ( Character.isDigit( wordToCount.charAt(j))){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String phrase;
        String convertedPhrase;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a phrase for conversion:");
        phrase = scanner.nextLine();

        if ( phrase.equals("")){
            System.out.println("No phrase entered.");

        }
        else{
            System.out.print("Text you entered: '" + phrase + "'" );
            convertedPhrase = convertText( phrase);
            System.out.print("\nAfter conversion:'" + convertedPhrase + "'");
            if ( convertedPhrase.equals(phrase)){
                System.out.println("\nNo conversion happened.");
            }
            else if ( countNumbers( convertedPhrase) == 0){
                System.out.println("\n!! Attention !! There is no number in this text");
            }
        }
    scanner.close();
    }
}
