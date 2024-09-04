import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        WordBag pro = new WordBag();
        Scanner scanner = new Scanner(System.in);

        /*
         * READING FILE
         */

        // as reading a file involves first opening that file there can be exceptions
        // such exceptions should be handled in the code
        // (you will see more of this topic later in the course)
        // however, for now, just know that surrounding the part that can cause exceptions
        // with a try-catch block is one solution for the exceptions
        try {
            // create a new buffered reader with the given file to read its text
            // "sentences.txt" is the name of the file that is included in your project folder
            // you can also write the full path of the file
            BufferedReader reader = new BufferedReader(new FileReader(new File("sentences.txt")));
            
            // read the first line of the text into currentLine
            String currentLine = reader.readLine();

            // unless we encounter a null line
            while (currentLine != null) {
                pro.processSentence(currentLine);
                // print the current line
                

                // and get the next line
                currentLine = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            // in case the file we provide cannot be found, this is the exception we get
            e.printStackTrace();
        } catch (IOException e) {
            // in case there is problem with reading the file, this is the exception we get
            e.printStackTrace();
        }
        System.out.println("Input file \"sentences.txt\" processed.");
        /*
         * WRITING TO FILE
         */

        // similar to reading a file, writing to a file can cause exceptions
        // therefore we need to surround our code in a try-catch block
        int iterator = 1;
        int soft = 0;
        int hard = 0;
        do{
            System.out.print("1. Generate Sentence\n2. Output Sentences to Text File\n3. Exit\nPlease choose an option: ");
            iterator = scanner.nextInt();
            if(iterator == 1){
                System.out.print("\nSoft Limit: ");
                soft = scanner.nextInt();
                System.out.print("\nHard Limit: ");
                hard = scanner.nextInt();
                String sen = pro.generateSentence(soft, hard);
                System.out.println(sen);
            }
            else if(iterator == 2){
                System.out.print("File Name:");
                String name = scanner.next();
                System.out.print("\nSentence Count:");
                int count = scanner.nextInt();
                System.out.print("\nSoft Limit:");
                soft = scanner.nextInt();
                System.out.print("\nHard Limit:");
                hard = scanner.nextInt();
                
                pro.writeToTextFile(name, count, soft, hard);      
            }
            else if(iterator == 3){
                System.out.println("Goodbye!");
            }

        }while(iterator != 3);
        
    }
}
