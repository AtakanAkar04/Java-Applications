import java.util.Scanner;

/**
 * Lab05_Q1
 */
public class Lab05_Q1 {
    public static int persistence(int num){
        int product;
        int time;
        time = 0;

        while ( num >= 10){
            product = 1;
            while ( num >= 10){
                product *= num % 10;
                num /= 10;
            }
            product *= num;

            num = product;
            time ++;
        }
        return time;

    }
    public static void main(String[] args) {
        int number;
        int persistenceNumber;
        boolean isPositive;

        Scanner scanner = new Scanner(System.in);
        
        isPositive = false;
        number = 0;
        do{
            System.out.print("Please enter e positive integer:");

            if ( scanner.hasNextInt() ){
                number = scanner.nextInt();
                if ( number > 0){
                    isPositive = true;
                }
            }
            else{
                scanner.next();
            }
        }while( !isPositive );
        
        persistenceNumber = persistence(number);
        System.out.printf("multiplicative persistance of %d is %d",number,persistenceNumber);
    scanner.close();
    }  
}