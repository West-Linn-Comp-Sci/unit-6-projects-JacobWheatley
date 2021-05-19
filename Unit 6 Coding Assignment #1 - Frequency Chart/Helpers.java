import java.util.*;

public class Helpers
{
    public int getInput(){
        int validInput = 0;
                
        do
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter numbers. when you want to stop, enter 1: ");
            String strInput = scanner.nextLine();
        
            if (strInput == "0")
            {
                validInput = 0;  
            }
            else
            {
                validInput = Integer.parseInt(strInput);
            } 
            
            if (validInput > 100)
            {
                System.out.println("Sorry! numbers higher than 100 are not supported. Please try again...");
            }
            
        } while(validInput > 100);
        
        return validInput;  // Read user input
    }
}