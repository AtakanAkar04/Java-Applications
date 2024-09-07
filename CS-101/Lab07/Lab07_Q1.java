import java.util.Arrays;
import java.util.Scanner;
public class Lab07_Q1 {
    public static int[] arrivals = {9,5,8,7,9,7,8};
    public static int[] departures = {12,7,11,12,10,9,10};
    public static String[] names = {"Elif","Eren","Alona","Jen","Mark","Mel","Ender"};


    public static int[] friendsAttending(int first, int second){
        int[] list = new int[second-first];
        int total;
        int index;
        index = 0;
        for ( int i = first; i < second; i ++){
            total = 0;
            for ( int j = 0; j < arrivals.length; j++){
                if ( i - arrivals[j] >= 0 && departures[j] - i >0 ){
                    total++;
                }
            }
            
            list[index] = total;
            index++;
        }
        return list;
    }
    public static void main(String[] args) {
        int arrivalTime;
        int departureTime;
        int maxIndex;
        int maxFriend;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter time interval you are available:");
        arrivalTime = scanner.nextInt();
        departureTime = scanner.nextInt();
        int[] timeArray = Arrays.copyOf(friendsAttending(arrivalTime, departureTime),departureTime-arrivalTime);
        maxIndex = 0;
        maxFriend = 0;

        for ( int j = 0; j < timeArray.length; j++){
            if ( timeArray[j] > maxFriend){
                maxFriend = timeArray[j];
                maxIndex = j;
            }
        }
        System.out.println();
        for ( int i = 0; i < timeArray.length; i++){
            System.out.printf("\nAt %d pm, %d friends will be at the party",arrivalTime+i,timeArray[i]);
        }
        System.out.println("\nBest time to attends is: " + (arrivalTime + maxIndex));


    }
    
}