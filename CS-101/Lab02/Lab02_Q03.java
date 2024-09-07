import java.util.Scanner;

public class Lab02_Q03 {
    public static void main(String[] args) {
        String word;
        char firstLetter;
        char middleLetter;
        char lastLetter;
        int middle;
        boolean isLower;
        int difMiddleFirst;
        int difLastFirst;
        
        

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string:");
        word = scanner.nextLine();

        if ( word.length() < 3 ) {
            System.out.println("Length of string not sufficient");

        }
        else {
            
            middle = word.length()/2;
            firstLetter = word.charAt(0);
            lastLetter = word.charAt(word.length()-1);
            middleLetter = word.charAt(middle);
            isLower = (Character.isLowerCase(firstLetter))&&(Character.isLowerCase(lastLetter))&&(Character.isLowerCase(middleLetter));
            if ( !isLower ) {
                System.out.println("Characters not lowercase letters...");
            }
            else {
                difLastFirst = Math.abs(firstLetter-lastLetter);
                difMiddleFirst = Math.abs(middleLetter-firstLetter);
                

                if ((difLastFirst <= 1 && !(difMiddleFirst<=1))) {
                    if(Math.abs(lastLetter-middleLetter)>=2){
                        System.out.printf("first:%c middle:%c last:%c",firstLetter,middleLetter,lastLetter);
                        System.out.println("\nString is special: true");
                        
                    }
                    else {
                        System.out.printf("first:%c middle:%c last:%c",firstLetter,middleLetter,lastLetter);
                        System.out.println("\nString is speacial: false");   
                    }
                }
                else if ((!(difLastFirst<=1) && (difMiddleFirst<=1))) {
                    if(Math.abs(middleLetter-lastLetter)>=2) {
                        System.out.printf("first:%c middle:%c last:%c",firstLetter,middleLetter,lastLetter);
                        System.out.println("\nString is special: true");
                  
                    }
                    else {
                        System.out.printf("first:%c middle:%c last:%c",firstLetter,middleLetter,lastLetter);
                        System.out.println("\nString is speacial: false");
                  
                    }
                        
                }
  
                
                else {
                    System.out.printf("first:%c middle:%c last:%c",firstLetter,middleLetter,lastLetter);
                    System.out.println("\nString is speacial: false");
       
                }
                

               

            }

        
        }

        scanner.close();
    }

}