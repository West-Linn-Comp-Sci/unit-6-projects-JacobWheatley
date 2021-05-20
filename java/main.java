

import java.util.Scanner;  // Import the Scanner class
import java.util.Collections;

public class main {     
    
    public static void main(String[] args) {
        MusicLib myMusicLib = new MusicLib();
        
        Boolean showMenuAgain = false;
        do{            
            showMenuAgain = myMusicLib.DisplayMenu();            
        } while (showMenuAgain);
           
        System.out.println("Goodbye! Have a nice day!");
    }
    
    
}
