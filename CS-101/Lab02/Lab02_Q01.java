import java.util.Scanner;

/**
 * Lab02_Q01
 */
public class Lab02_Q01 {

    public static void main(String[] args) {
        double number;
        double outcome;
        String wrongInput;

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a real number:");
        

        if ( !scanner.hasNextDouble() ) {
        wrongInput = scanner.nextLine();
        System.out.println("Invalid input - value must be numeric...");
        System.out.printf("You entered: %s",wrongInput);
        
        }
        else {
            number = scanner.nextDouble();


            if ( number > 15 ) {
                outcome = Math.sqrt(Math.pow(number,5)+1);
                System.out.println("------------------------");
                System.out.printf("f(x) = %.2f",outcome);

            }
            else if ( number >= 0 ) {
                outcome = Math.pow(Math.E,number)-15;
                System.out.println("------------------------");
                System.out.printf("f(x) = %.2f",outcome);
            }
            else {
                outcome = number / ( number += 10);
                System.out.println("------------------------");
                System.out.printf("f(x) = %.2f",outcome);

            }

            





        }

        scanner.close();
    }
}