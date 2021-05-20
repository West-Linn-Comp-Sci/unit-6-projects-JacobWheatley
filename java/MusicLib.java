
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MusicLib {    
    private Album albumArray[] = new Album[20]; //create an array of 20 Albums.. standard sz is 10 but user can go up to 20 
    private int totalRunTime = 0;
    private int totalNumTracks = 0;
    private int totalAlbumSize = 0;
    
    
    
    public MusicLib() //constructor
    {
        for (int i = 0; i < albumArray.length; i++) { //instanciate objects (read... actually build em)
            Album a = new Album();
            albumArray[i] = a;
        }
    }
    
    public Boolean DisplayMenu()
    {
        System.out.println("--------------------");
        System.out.println("Jake's Music Library");
        System.out.println("--------------------");
        System.out.println("Menu options:");
        System.out.println("   1 = Make a new Album");
        System.out.println("   2 = Delete an existing Album");
        System.out.println("   3 = Show Libary Statistics");
        System.out.println("   4 = Show All Albums Details");        
        System.out.println("   5 = Show Details for a particular album");  
        System.out.println("   9 = QUIT");
        System.out.println("   ");
        System.out.println("Enter your choice: ");
        
        try {
            Scanner userInput = new Scanner(System.in);
            int choice = Integer.parseInt(userInput.nextLine());
            
            if(choice == 1) {
                this.AddNewAlbum();
            }
            else if (choice == 2) {
                this.RemoveAlbum();
            }
            else if (choice == 3) {
                this.ShowLibraryStats();
            }
            else if (choice == 4) {
                this.ShowAllAlbumsInfo();
            }
            else if (choice == 5) {
                this.ShowAllAlbumInfoByTitle();
            }
            else if (choice == 9) {
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("!!! ERROR !!!: INPUT INVALID!!! " + e.toString());
            return true;
        }        
        
        return true;
    }
    
    private void ShowAllAlbumsInfo()
    {
        System.out.println("--------------------");
        System.out.println("Showing all albums");
        
        for(int i = 0; i != this.albumArray.length; i++){
             if(this.albumArray[i].IsEmpty() == false)
             {
                 this.albumArray[i].ShowInfo();
             }            
        }       
    }
    
    private void ShowLibraryStats()
    {
        System.out.println("-------------------------");
        System.out.println("Showing Library Stats");
        
        System.out.println("   Total Number of Albums = " + this.totalAlbumSize );
        System.out.println("   Total Number of Tracks = " + this.totalNumTracks );
        System.out.println("   Total Runtime of all Albums = " + this.totalRunTime );
    }
    
    private void ShowAllAlbumInfoByTitle()
    {
        Scanner userInput = new Scanner(System.in);
        String albumTitle = "";
        System.out.println("-------------------------");
        System.out.println("Enter Title of Album: ");
        
        albumTitle = userInput.nextLine();   
        
        int index = this.GetIndexOfAlbum(albumTitle);
        
        if(index == -1)
        {
            System.out.println("ERROR: Could not find Album!!!! ");
            return;
        }
        
        this.albumArray[index].ShowInfo();
    }
    
    private void AddNewAlbum()
    {
        int indexOfNextEmptySlot = -1;
        String albumTitle; 
        String albumArtist;
        int numberOfTracks;
        int albumRuntime;
        
        try { // to get user data
            Scanner userInput = new Scanner(System.in);
            System.out.println("--------------------");
            System.out.println("Enter Album Artist : ");
            albumArtist = userInput.nextLine();
            
            System.out.println("Enter Album Title : ");
            albumTitle = userInput.nextLine();
                                   
            System.out.println("Enter Number of Tracks in Album: ");
            numberOfTracks = Integer.parseInt(userInput.nextLine());
            
            System.out.println("Enter Runtime of Album : ");
            albumRuntime = Integer.parseInt(userInput.nextLine());
        }
        catch(Exception e) {
            System.out.println("!!! ERROR !!! INPUT INVALID!!! " + e.toString());
            return;
        }
                         
        try { // to add the album       
            //Find the 1st Album that is empty for us to add to             
            for(indexOfNextEmptySlot = 0; this.albumArray[indexOfNextEmptySlot].IsEmpty() == false; indexOfNextEmptySlot++)
            {
                if(indexOfNextEmptySlot == this.albumArray.length)
                {
                    System.out.println("ERROR! Could not create new Album! Music Library is full!");
                    return; //
                }            
            }           

            this.albumArray[indexOfNextEmptySlot].SetAlbumArtist(albumArtist);
            this.albumArray[indexOfNextEmptySlot].SetAlbumTitle(albumTitle);
            this.albumArray[indexOfNextEmptySlot].SetNumberOfTracks(numberOfTracks);
            this.albumArray[indexOfNextEmptySlot].SetAlbumRunTime(albumRuntime);
        }
        catch (Exception e)
        {
            System.out.println("!!! ERROR !!! COULD NOT CREATE ALBUM!!! " + e.toString());
            if( albumArray[indexOfNextEmptySlot] != null ) {
                albumArray[indexOfNextEmptySlot].ClearAlbum(); //try to recover
            }
            else {
                System.out.println("!!! ERROR !!! COULD NOT RECOVER FROM ERROR!!! ");
            }
            return; //
        }
        //update lib info
        this.totalAlbumSize += 1;
        this.totalRunTime += albumRuntime;
        this.totalNumTracks += numberOfTracks;   
    }
    
    private int GetIndexOfAlbum(String albumTitle) //return -1 on error
    {
        //Find the 1st Album by title
        for(int i = 0; i != this.albumArray.length; i++){
            if((this.albumArray[i].GetAlbumTitle()).equals(albumTitle))
            { //then we've found the one that we need to remove                
                return i;
            }            
        }
        return -1;
    }
    
    private void RemoveAlbum()
    {
        int indexOfAlbumToClear = -1;
        String albumTitle;
        
        try { // to get user data
            Scanner userInput = new Scanner(System.in);
            System.out.println("--------------------");
            System.out.println("Enter Album Title to REMOVE : ");
            albumTitle = userInput.nextLine();                      
        }
        catch(Exception e) {
            System.out.println("!!! ERROR !!! INPUT INVALID!!! " + e.toString());
            return;
        }
        
        try {
            indexOfAlbumToClear = GetIndexOfAlbum(albumTitle);

            if(indexOfAlbumToClear == -1)
            {
                System.out.println("ERROR! Could not find album " + albumTitle + " to be removed!!");
                return; 
            }
        }
        catch (Exception e)
        {
            System.out.println("!!! ERROR !!! COULD NOT REMOVE ALBUM!!! " + e.toString());           
            return; //
        }
        
        
        //update lib info
        this.totalRunTime -= albumArray[indexOfAlbumToClear].GetAlbumRunTime();
        this.totalNumTracks -= albumArray[indexOfAlbumToClear].GetNumberOfTracks();
        this.totalAlbumSize -= 1;
        
        //cleardata in album
        this.albumArray[indexOfAlbumToClear].ClearAlbum();
    }
}
