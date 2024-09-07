import java.util.Scanner;

/**
 * Lab04_Q1
 */
public class Lab04_Q1 {

    public static void main(String[] args) {
        int minPeople;
        int maxPeople;
        int groupSize;
        double propability;
        double product;

        Scanner scanner = new Scanner(System.in);
        

        do{
            System.out.print("Enter the minimum and maximum number of people:");
            minPeople = scanner.nextInt();
            maxPeople = scanner.nextInt();
            if ( minPeople >= maxPeople){
                System.out.println("Invalid input - minimum must be less than maximum...");
            }

        }while( minPeople >= maxPeople );

        
        System.out.printf("%-20s%10s","NUMBER OF PEOPLE","PROBABILITY");
        groupSize = minPeople;

        for ( int i = minPeople; i<= maxPeople ; i++){
            product = 1;
            
            for ( double r = 1.0; r < groupSize; r++){
                product *= ( (double)365 - r) / (double)365;
            }
            
            propability = 1.0 - product;

            System.out.printf("\n%-20d%.3f",groupSize,propability);
            groupSize++;
        }
    scanner.close();

    }
}