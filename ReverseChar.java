//Name: Wyatt Bechtle
//Date: 30 April 2023
//Program: ReverseChar Class

//Algorithm
//---------
//Step 1) Display program explanation.
//Step 2) Get user input.
//Step 3) Validate the input.
//Step 4) Display reversed string via recursion.
//Step 4) Prompt user to quit or go again.
import java.util.Scanner;

//This class is used to prompt a user for a string that is 3 to 5 (inclusive) words in
//in length and then recursively reverses the string and display it to the screen.
public class ReverseChar {
    public static void main(String[] args) {

        //Instantiate scanner object.
        Scanner input = new Scanner(System.in);

        //Declare variables to hold user input to iterate program.
        String choice;

        //Display program explanation.
        System.out.println("\nGreetings...\n" + 
                            "This programs takes a short sentence (3 to 5 words)\n" +
                            "and displays the sentence in reverse order via recursion.");

        do {
            //Prompt the user to enter a sentence.
            System.out.print("\nEnter a short sentence (3 to 5 words): ");
            String sentence = input.nextLine();

            //Declare and initialize variable to control input validation loop.
            boolean inValid = true;

            //Loop used to validate user input.
            do {
                //Split sentence into individual words.
                String [] wordStrings = sentence.split(" ");

                //Count words to verify within 3 to 5 words(inclusive).
                int wordCount = wordStrings.length;

                //If within valid range, end validation loop.
                if (wordCount < 6 && wordCount > 2) {
                    inValid = false;
                }
                //Invalid input, display error and prompt user to input again.
                else {
                    //Display error and prompt the user to enter a sentence.
                    System.out.print("\nERROR: Sentence out of range...");
                    System.out.print("\nEnter a short sentence (3 to 5 words): ");
                    sentence = input.nextLine();
                }
            } while (inValid);

            //Display the reversed sentence recursively.
            System.out.print("\nThe recursively reversed string is: ");
            reverseDisplay(sentence);

            //New line.
            System.out.println();

            //Loop is used to get user to input "y" or "Y" to continue or "n" or "N" to exit.
            do {

                System.out.print("\nWould you like to continue (Y/N)? ");
                choice = input.nextLine();//Get user input.
    
                //Display error if input does not meet prompt expectations.
                if (!(choice.equalsIgnoreCase("Y") || 
                choice.equalsIgnoreCase("N"))) {
                    System.out.println("\nInvalid input...\nPlease input (Y/N)");
                }
                } while (!(choice.equalsIgnoreCase("Y") || 
                choice.equalsIgnoreCase("N"))); //Iterate while invalid input.

        } while (choice.equalsIgnoreCase("Y"));//Iterate while choice is "Y/y"

        //Display good-bye.
        System.out.println("\nGood-Bye...");
    }

    //This method takes a string value and recursively reverses it and then displays the
    //value to the screen.
    public static void reverseDisplay(String value) {

        //Base case.
        if (value.length() == 0) {
            return;//Tail recursion.
        } 
        //Recursive case.
        //Display char at max index, recursively call reversDisplay passing the substring
        //of the original string minus the char that was displayed in the previous statement.
        else {
            System.out.print(value.charAt(value.length() - 1));
            reverseDisplay(value.substring(0, value.length() - 1));
        }
    }
}
