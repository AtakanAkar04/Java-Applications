import java.util.Scanner;

public class Lab02_Q02 {
    public static void main(String[] args) {
        int smallJars;
        int largeJars;
        int orderSize;
        int smallJarsToUse;
        int largeJarsToUse;
        int max;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the number of small and large jars available and the order size:");
        smallJars = scanner.nextInt();
        largeJars = scanner.nextInt();
        orderSize = scanner.nextInt();

        if ( orderSize < 5 ) {
            System.out.println("Order must be larger than 5 litres");


        }
        else if ( (smallJars + (largeJars * 5)) < orderSize ) {
            System.out.println("You do not have enough jars to complete the order");


        }
        else {
            max = orderSize / 5;
            if(max <= largeJars) {
                if(orderSize <= (max*5+smallJars)){
                    largeJarsToUse = max;
                    smallJarsToUse = orderSize-5*max;
                    System.out.printf("Order of %d litres will contain %d small (1 litre) jars",orderSize,smallJarsToUse);

                }
                else {
                    System.out.println("You do not have enough jars to complete the order");

                }
            }
            else {
                largeJarsToUse = largeJars;
                smallJarsToUse = orderSize-5*largeJarsToUse;
                System.out.printf("Order of %d litres will contain %d small (1 litre) jars",orderSize,smallJarsToUse);
            }


        }

    scanner.close();

        
    }
}
