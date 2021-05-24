import java.util.*;

public class main {
    public static void main(String[] args) {
        String name = "";
        double value = 0;
        
        Scanner userInput = new Scanner(System.in); 
        Purse myPurse = new Purse();
        
        do{            
            try
            {                                                           
                System.out.println("Enter coin name (or Done to be DONE)");   
                name = userInput.nextLine();                    
                
                if(! name.equals("Done")){                   
                    System.out.println("Enter coin value");   
                    value = Double.parseDouble(userInput.nextLine());
                                        
                    Coin c = new Coin(value, name);                                                   

                    //DEBUG
                    //System.out.println("1st Coin name = " + c.getName() + ", value  = " + c.getValue());                                         
                    myPurse.add(c);
                }
            } catch (Exception e) { //stop it crashing when i enter name for age again
                System.out.println("ERROR: Sheeeeeeeeesh " + e.toString());   
            }            
        } while(! name.equals("Done"));
        
        System.out.println("Total value of Purse =  " + myPurse.getTotal());   
        
        System.out.println("Testing count.. Enter coin name to count in Purse ");   
        name = userInput.nextLine();                                    
        System.out.println("Enter coin value");   
        value = Double.parseDouble(userInput.nextLine());                                        
        Coin e = new Coin(value, name);                  
        
        System.out.println("Number of coins in purse matching inputs is " + myPurse.count(e));        
        
    }
    
    
}// A Coin represents a real world coin such as a "quarter" which 

// has a value of 0.25, a "half dollar" which has value of 0.50, etc. 

// A class invariant holds that 0.00 < all coin values <= 1.00 


