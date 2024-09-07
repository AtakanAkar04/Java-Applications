import java.util.Arrays;
import java.util.Scanner;

public class Lab07_Q2 {
    public static int[] arrivals = {9,5,8,7,9,7,8};
    public static int[] departures = {12,7,11,12,10,9,10};
    public static String[] names = {"Elif","Eren","Alona","Jen","Mark","Mel","Ender"};

    public static int bestTimeToAttend(int first,int second,String name){
            int bestTime;
            int maxFriends;
            int avoidIndex;
            int iterator;
            boolean isTrue;

            iterator = 0;
            maxFriends = 0;
            bestTime = 0;
            avoidIndex = 0;
            isTrue = false;

            while ( iterator < names.length && !isTrue){
                if ( name.equals(names[iterator])){
                    avoidIndex = iterator;
                    isTrue = true;
                }
                iterator++;
            }
            for ( int j = first; j < second; j++){
                int count = 0;
                for ( int k = 0; k < arrivals.length; k++ ){
                    if ( (j - arrivals[avoidIndex] < 0 || j >= departures[avoidIndex] ) && arrivals[k] - j <= 0 && departures[k] - j > 0 ){
                        count ++;
                    }
                }
                if ( count > maxFriends){
                    maxFriends = count;
                    bestTime = j;
                }
            }
            if ( maxFriends > 0){
                return bestTime;
            }
            else{
                return -1;
            }  
    }
    public static void main(String[] args) {
        int start;
        int end;
        String avoid;
        int bestTime;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter friend you wish to aviod:");
        avoid = scanner.nextLine();
        System.out.print("Enter time interval you are available:");
        start = scanner.nextInt();
        end = scanner.nextInt();


        bestTime = bestTimeToAttend(start, end, avoid);
        System.out.printf("Best time to attend to avoid %s and to see the most friends is: %d",avoid,bestTime);

    }
}