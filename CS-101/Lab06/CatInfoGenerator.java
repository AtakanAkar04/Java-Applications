import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



public class CatInfoGenerator {
    private static final int CAMPUS_RADIUS = 250;
    private static final int MAX_MONTHS = 60;
    private static String[] arrayOfNames = {"Gollum","Spiderman","Mocha","Gora","Zeytin","Spot","Pamuk","Duman","Pasha","Tickles","Kahve","Tekir","Benek","Checkers", "Karamel","Tik Tak", "Havuç", "Blizzard", "Splatter", "Sprite","Hamur","Pofuduk","Popsicle","Ash","Gofret","Latte","Aslan","Patches","Lucky","Fluffy"};
    private static ArrayList<String> catNames = new ArrayList<String>( Arrays.asList( arrayOfNames ));
    
    public static ArrayList<String> getRandomNameList( int num ){  
       /*Implement the method here.....
	    * The method should add num random names from the global static catNames list to a new ArrayList and 
		* return the random list of names. There should be no duplicates, and you should make sure that num is 
		* less than the number of names in the catNames list, if not, num should be set to the size of the 
		* catNames list.*/
        int randName;
        int count;
		ArrayList<String> randomNames = new ArrayList<String>();
        Random random = new Random();
        if ( num > catNames.size()){
            num = catNames.size();
        }
        count=1;
        while ( count <= num) {
            randName = random.nextInt(catNames.size());
            if ( randomNames.indexOf(catNames.get(randName)) == -1){
                randomNames.add(catNames.get(randName));
                count++;
            }
        }
        return randomNames;
    }
	
    public static ArrayList<String> getRandomLocationList( int num ){
        ArrayList<String> randomLocations = new ArrayList<String>();
        int randX;
        int randY;

        Random rand = new Random();
        int locCount = 0; //name counter

        while (  locCount < num ){    
            randX = rand.nextInt( CAMPUS_RADIUS * 2 );
            randY = rand.nextInt( CAMPUS_RADIUS * 2 );
            //if name not already added to list
            if( Math.sqrt( Math.pow(randX - 250 ,2) + Math.pow(randY - 250 ,2)) <= CAMPUS_RADIUS  ){
                randomLocations.add( randX + "," + randY );
                locCount++;
            }
        }
        return randomLocations;
    }
    public static ArrayList<Integer> getRandomMonthList( int num ){
        ArrayList<Integer> randomMonths = new ArrayList<Integer>();
        int month;
    
        Random rand = new Random();

        for ( int i = 0; i < num; i++ ){    
            month = rand.nextInt( MAX_MONTHS );
            randomMonths.add( month );
        }
        return randomMonths;
    }
    public static double calculateDistance(String first,String second){
        double distance;
        double valueOfFirstX;
        double valueOfSecondX;
        double valueOfFirstY;
        double valueOfSecondY;

        valueOfFirstX = Double.parseDouble(first.substring(0,first.indexOf(",")));
        valueOfFirstY = Double.parseDouble(first.substring(first.indexOf(",")+1));
        valueOfSecondX = Double.parseDouble(second.substring(0,second.indexOf(",")));
        valueOfSecondY = Double.parseDouble(second.substring(second.indexOf(",") + 1));
        distance = Math.sqrt(Math.pow(valueOfSecondX-valueOfFirstX,2)+Math.pow(valueOfSecondY-valueOfFirstY,2));
        return distance;
    }
    public static boolean doesIntersect(String first, String second){
        double distance;
        distance = calculateDistance(first, second);

        if( distance <= 100 && !first.equals(second)){
            return true;
        }
        else{
            return false;
        }

    }
    public static int countIntersecting(String loc, ArrayList<String> list){
        int count;
        count = 0;
        for ( int i = 0; i<list.size(); i++){
            if ( doesIntersect(loc,list.get(i)) && !(loc.equals(list.get(i)))){
                count++;
            
            }
        }
        return count;
    }

    public static void displayIntersactions( ArrayList<String> catList, ArrayList<String> locations ,ArrayList<Integer> months ){
        int checker;
        int secChecker;
        int count;
        checker = 0;
        count = 0;
        while ( checker < catList.size()){
            System.out.printf("\n\n%s at location %s for %d months intersects with:",catList.get(checker),locations.get(checker),months.get(checker));
            secChecker = 0;
            count = 0;
            while ( secChecker < catList.size()){
                if ( doesIntersect(locations.get(checker), locations.get(secChecker)) && secChecker != checker){
                    System.out.printf("\n\t%s, at location %s for %d months",catList.get(secChecker),locations.get(secChecker),months.get(secChecker)); 
                    count++;   
                }
                secChecker++;


            }
            if ( count == 0 ){
                System.out.println("NO CATS");   
            }
            checker++;
        }
        
    }
    public static int findMinMonthsAtLocation( String location, ArrayList<String> list,ArrayList<Integer> months){
        int minMonth;
        int minIndex;
        minMonth = MAX_MONTHS;
        minIndex = 0;
        for ( int i = 0; i < list.size(); i++){
            if ( doesIntersect(location,list.get(i))){
                if ( months.get(i) < minMonth){
                    minIndex= i;
                    minMonth = months.get(i);
                }
            }
        }
        return minIndex;

    }
    public static String findRandomLocation(){
        int randX;
        int randY;
        int maxY;
        String location;

        Random random = new Random();
        randX = random.nextInt(251);
        maxY = (int)(Math.sqrt(Math.pow(250,2) - Math.pow(randX,2)));
        if ( maxY == 0){
            randY = 0;
        }
        else{
            randY = random.nextInt(maxY);
        }
        location = randX + "," + randY;
        return location;
    }
    public static void moveCats(ArrayList<String> locations, ArrayList<Integer> months){
        int minIndex;
        
        for ( int i = 0; i< locations.size(); i++){
            while ( countIntersecting(locations.get(i), locations) >= 1){
                minIndex = findMinMonthsAtLocation(locations.get(i), locations, months);
                locations.set(minIndex,findRandomLocation());
                months.set(minIndex,0);
                while(countIntersecting(locations.get(minIndex), locations) >= 2){
                    locations.set(minIndex,findRandomLocation());
                }
            }
        }
        
    }
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> locations = new ArrayList<String>();
        ArrayList<Integer> months = new ArrayList<Integer>();

        names = getRandomNameList(20);
        locations = getRandomLocationList(20);
        months = getRandomMonthList(20);
        System.out.println("Before moving cats:");
        displayIntersactions(names, locations, months);
       
        moveCats(locations, months);
        System.out.println("\nAfter moving cats:");
        displayIntersactions(names, locations, months);
        
        
    }
}
