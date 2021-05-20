/*
 Design and implement a program that can store the data of a personal music library. 
A standard music library consists of of 10 albums and keeps track of the total play time and number of song tracks in the library. 
The total number of albums in a library can be doubled by the user if desired. An album has a title and artist, a certain number of tracks, and the total play time of the album. 
A new music library does not have any albums associated with it so a user must be able to add and remove albums.

Use object oriented design strategies and include toString methods for any non-client classes. (
Remember: the goal of this assignment is to demonstrate your understanding of using arrays to store objects, it is possible to complete this assignment using ArrayLists but we will only be using arrays in this assignment.)
 */
import java.util.*;
public class MusicLibrary
{
    public static void main(String[] args){
        System.out.println("Welcome to my Music Library creator x 2 (if you want to)");
        
        Album albumArray[] = new Album[10]; //create an array of 10 Albums
        Album albumArray2[] = new Album[10]; //create an array of 10 Albums
        
        for (int i = 0; i < 10; i++) { //instanciate objects (read... actually build em)
            Album a = new Album();
            Album b = new Album();
            albumArray[i] = a;
            albumArray2[i] = b;
        }
    
        //get Music Libray #1
        for(int i=0; i != 10; i++){
            System.out.println("Getting Album Details for 1st Music Library, Album #" + (i+1) + " of 10 ");
           getAlbumDetails(albumArray[i]);
        }
        
        System.out.println("Created a Music Library! Do you want to create another? [y for YES]: ");
        Scanner userInput = new Scanner(System.in);
        String nuver = userInput.nextLine();
        
        if (nuver.equals("Y") || nuver.equals("y")){
            for(int i=0; i != 10; i++){
                System.out.println("Getting Album Details for 2nd Music Library, Album #" + (i+1) + " of 10 ");
                getAlbumDetails(albumArray2[i]);
            }
        }
        
        //now display info back to user
        for(int i = 0; i != 10; i++){
             System.out.println("Music Library 1, Album #" + (i+1));
             System.out.println(" Title--" + albumArray[i].getAlbumTitle());
             System.out.println(" Artist--" + albumArray[i].getAlbumArtist());
             System.out.println(" Number of tracks--" + albumArray[i].getNumberOfTracks());
             System.out.println(" Album Length--" + albumArray[i].getAlbumLength());
             
             if (nuver.equals("Y") || nuver.equals("y")){
                 System.out.println("Music Library 2, Album #" + (i+1));
                 System.out.println(" Title--" + albumArray2[i].getAlbumTitle());
                 System.out.println(" Artist--" + albumArray2[i].getAlbumArtist());
                 System.out.println(" Number of tracks--" + albumArray2[i].getNumberOfTracks());
                 System.out.println(" Album Length--" + albumArray2[i].getAlbumLength());
             }
        }
    
    
    }
      
    //gets the album details and sets the album to the datails of the album passed in
    public static void getAlbumDetails(Album myAlbum){
        try
        {
             Scanner userInput = new Scanner(System.in);  // Create a Scanner object
             System.out.println("Enter the album title");
             myAlbum.setAlbumTitle(userInput.nextLine());
             
             System.out.println("Enter Artist name: ");
             myAlbum.setAlbumArtist(userInput.nextLine());
             
             System.out.println("Enter number of tracks in Album: ");
             myAlbum.setNumberOfTracks(Integer.parseInt(userInput.nextLine()));
             
             System.out.println("Enter Length of Album:");
             myAlbum.setAlbumLength(Integer.parseInt(userInput.nextLine()));
        }
        catch (Exception e) // entering invalid value should not crash stupid program
        {
            System.out.println("!!! ERROR !!!: COULD NOT SAVE DATA! SOME INFORMATION FOR ALBUM WAS NOT SAVED!!!");
        }
    }
}

