import java.util.Scanner;

public class Lab04_Q2 {
    public static void main(String[] args) {
        String word;
        boolean isNumber;
        int checkChar;
        int reviewNum;
        int difFromNine;
        int valueOfChar;
        int sum;
        double average;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter chart data: ");
        word = scanner.nextLine();

        checkChar = 0;
        isNumber = true;
        average = 1;

        do{
            if ( !Character.isDigit(word.charAt(checkChar))){
                isNumber = false ;
            }
            checkChar++;

        }while ( isNumber && checkChar < word.length());

        if ( !isNumber ){
            System.out.println("Invalid chart data!");


        }

        else{
            reviewNum = 1;
            difFromNine = 9;
            do{
                System.out.printf("%8s %d","review",reviewNum);
                reviewNum++;
            }while ( reviewNum <= word.length());
            do{
               System.out.println("");
               for (int m = 0; m<word.length();m++) {

                valueOfChar = word.charAt(m) - 48;

                if ( difFromNine - valueOfChar <= 0){
                    System.out.printf("%10s","***");


                }
                else{
                    System.out.printf("%10s","   ");

                }

               }
                
                

                difFromNine--;
            }while( difFromNine > 0 );
            sum = 0;
            for (int j = 0; j < word.length(); j++){
                valueOfChar = word.charAt(j) - 48;
                sum += valueOfChar;


            }
            average = sum / (double)word.length();
            System.out.printf("\nAverage Review: %.1f ",average);
        }
    scanner.close();
    }
}
