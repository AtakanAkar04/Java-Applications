import java.util.Scanner;

public class Lab05_Q3 {
    public static void displayMenu(){
        System.out.println("\n1 - Find Probability of Same Birthday");
        System.out.println("2 - Draw Chart");
        System.out.println("3 - Convert Word");
        System.out.println("4 - QUIT");
    }

    public static int getChoice(){
        int selection;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter choice:");
        selection = scanner.nextInt();
        return selection;
    }

    public static double sameBirthday( int size ){
        double product;
        double probability;

        product = 1;

        for ( int i = 0; i < size; i++){
            product *= (360.0 - i) / 360.0;

        }
        probability = 1 - product;
        return probability;
    }

    public static int findMax( int numToFindMax){
        int maxInt;
        int checkedInt;
        maxInt = 0;
        while ( numToFindMax > 0){
            checkedInt = numToFindMax % 10;
            numToFindMax /= 10;
            if ( checkedInt >= maxInt){
                maxInt = checkedInt;
            }
        }
        return maxInt;
    }

    public static void displayChart( String data){
        int reviewNum;
        int valueOfChar;
        int valueOfString;
        int maxDigit;

        reviewNum = 1;
        valueOfString = Integer.parseInt(data); 
        maxDigit = findMax(valueOfString);

            do{
                System.out.printf("%8s %d","review",reviewNum);
                reviewNum++;
            }while ( reviewNum <= data.length());
            do{
               System.out.println("");
               for (int m = 0; m < data.length(); m++) {

                valueOfChar = data.charAt(m) - 48;

                if ( maxDigit - valueOfChar <= 0){
                    System.out.printf("%10s","***");
                }
                else{
                    System.out.printf("%10s","   ");
                }
               }
                maxDigit--;
            }while( maxDigit > 0 );    
    }

    public static boolean isValidNumeric( String data){
        int checkChar;
        boolean valid;
        valid = true;
        checkChar = 0;
        while ( checkChar < data.length() && valid ){
            if ( !Character.isDigit(data.charAt(checkChar))){
                valid = false;
            }
            checkChar++;
        }
        return valid;
    }

    public static int countLetter( String toCount, int indexToControl){
        int count;
        count = 0;
        for ( int m = 0; m < toCount.length(); m++){
            if ( toCount.charAt(m) == toCount.charAt(indexToControl)){
                count++;
            }
        }
        return count;
    }

    public static String convertWord( String text ){
        String convertedWord;
        convertedWord = "";
        for ( int i = 0; i < text.length(); i++){
            if ( Character.isLetter(text.charAt(i))){
                if ( countLetter(text,i) == 1 ){
                    convertedWord += "(";
                }
                else{
                    convertedWord += ")";
                }
            }
            else{
                convertedWord += "*";
            }
        }
        return convertedWord;
    }
    public static void main(String[] args) {
        int choice;
        int groupSize;
        String wordToChange;

        Scanner input = new Scanner(System.in);

        choice = 0;

        while ( choice != 4){
            displayMenu();
            choice = getChoice();

            if ( choice == 1){
                System.out.print("Enter the group size:");
                groupSize = input.nextInt();
                System.out.printf("The probability of two people in a group of %d having the same birthday is %.2f\n",groupSize,sameBirthday(groupSize));
            }
            else if ( choice == 2){
                String chartData;
                System.out.print("Enter chart data:");
                
                chartData = input.next();
                if ( !isValidNumeric(chartData)){
                    System.out.println("\nInvalid chart data!");
                }
                else {
                    displayChart(chartData);
                }

            }
            else if ( choice == 3){
                System.out.print("Enter word to convert:");
                wordToChange = input.next();
                System.out.printf("Original word: %s Converted word: %s",wordToChange,convertWord(wordToChange));

            }
            else if ( choice == 4){
                System.out.println("GOODBYE!");
            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }
}
