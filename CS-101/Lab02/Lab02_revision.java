import java.util.Scanner;

/**
 * Lab02_revision
 */
public class Lab02_revision {

    public static void main(String[] args) {
        String word;
        char firstLetter;
        char firstMiddleLetter;
        char secondMiddleLetter;
        char lastLetter;
        int firstMiddle;
        int secondMiddle;
        boolean isLower;
        int difFMiddleFirst;
        int difLastFirst;
        int difSMiddleFirst;
        
        

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string:");
        word = scanner.nextLine();

        if ( word.length() < 4 ) {
            System.out.println("Length of string not sufficient");

        }
        else if (!(word.length()%2==0)){
            System.out.println("String legnth is not even.");
        
        }
        else {
            secondMiddle = word.length()/2;
            firstMiddle = word.length()/2-1;
            firstLetter = word.charAt(0);
            lastLetter = word.charAt(word.length()-1);
            secondMiddleLetter = word.charAt(secondMiddle);
            firstMiddleLetter = word.charAt(firstMiddle);
            isLower = Character.isLowerCase(firstLetter) && Character.isLowerCase(lastLetter) && Character.isLowerCase(firstMiddleLetter) && Character.isLowerCase(secondMiddleLetter) ;
            if ( !isLower ) {
                System.out.println("Characters not lowercase letters...");
            }
            else {
                difLastFirst = Math.abs(firstLetter-lastLetter);
                difFMiddleFirst = Math.abs(firstMiddleLetter-firstLetter);
                difSMiddleFirst = Math.abs(secondMiddleLetter-firstLetter);
                

                if ((difLastFirst <= 1 && !(difFMiddleFirst<=1) && !(difSMiddleFirst<=1))) {
                    if((Math.abs(lastLetter-firstMiddleLetter)>=2)&&(Math.abs(lastLetter-secondMiddleLetter)>=2)){
                        System.out.printf("first:%c first middlee:%c second middle:%c last:%c",firstLetter,firstMiddleLetter,secondMiddleLetter,lastLetter);
                        System.out.println("\nString is speacial: true");
                    }
                    else {
                        System.out.printf("first:%c first middle:%c second middle:%c last:%c",firstLetter,firstMiddleLetter,secondMiddleLetter,lastLetter);
                        System.out.println("\nString is speacial: false");

                    }
                }
                else if ((!(difLastFirst <= 1) && (difFMiddleFirst<=1) && !(difSMiddleFirst<=1))) {
                    if((Math.abs(firstMiddleLetter-lastLetter)>=2)&&(Math.abs(firstMiddleLetter-secondMiddleLetter)>=2 )){
                        System.out.printf("first:%c first middle:%c second middle:%c last:%c",firstLetter,firstMiddleLetter,secondMiddleLetter,lastLetter);
                        System.out.println("\nString is speacial: true");
                        
                    }
                    else {
                        
                        System.out.printf("first:%c first midlle:%c second midle:%c last:%c",firstLetter,firstMiddleLetter,secondMiddleLetter,lastLetter);
                        System.out.println("\nString is speacial: false");
                    }
                }   
                else if ((!(difLastFirst <= 1) && !(difFMiddleFirst<=1) && (difSMiddleFirst<=1))){
                    if((Math.abs(secondMiddleLetter-lastLetter)>=2)&&(Math.abs(secondMiddleLetter-firstMiddleLetter)>=2)){
                        System.out.printf("first:%c first middle:%c second middle:%c last:%c",firstLetter,firstMiddleLetter,secondMiddleLetter,lastLetter);
                        System.out.println("\nString is speacial: true");


                    }
                    else{
                        System.out.printf("first:%c first middle:%c second middle:%c last:%c",firstLetter,firstMiddleLetter,secondMiddleLetter,lastLetter);
                        System.out.println("\nString is speacial: false");

                    }



                }
                else{
                    System.out.printf("first:%c first middle:%c second middle:%c last:%c",firstLetter,firstMiddleLetter,secondMiddleLetter,lastLetter);
                    System.out.println("\nString is speacial: false");


                }
            }
                
                

               

        }
        scanner.close();
        
    }

        
}
