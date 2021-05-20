/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwheatley
 */
public class Album {
    // instance variables - replace the example below with your own
    private String albumTitle;
    private String albumArtist;
    private int numberOfTracks;
    private int runtime;
   
    public Album()
    {
        this.ClearAlbum();
    }
    
    public void ClearAlbum() //clears values... this is how music lib knows it can reuse an album
    {
        albumTitle = "Empty";
        albumArtist = "Empty";
        numberOfTracks = 0;
        runtime = 0;
    }
    
    public Boolean IsEmpty()
    {
        return (albumTitle.equals("Empty")); 
    }
    
    //getter and setter set for albumTitle
    public String GetAlbumTitle(){
     return albumTitle;  
    }
   
    public void SetAlbumTitle(String albumTitle){
      this.albumTitle = albumTitle;
    }
   
    //getter and setter set for album artist
    public String GetAlbumArtist(){
     return albumArtist;  
    }
   
    public void SetAlbumArtist(String albumArtist){
     this.albumArtist = albumArtist;  
    }
   
    public int GetNumberOfTracks(){
     return numberOfTracks;  
    }
   
    public void SetNumberOfTracks(int numberOfTracks){
     this.numberOfTracks = numberOfTracks;  
    }
   
    public int GetAlbumRunTime(){
     return runtime;  
    }
   
    public void SetAlbumRunTime(int runtime){
     this.runtime = runtime;  
    }
    
    public void ShowInfo()
    {
        System.out.println("-----------------");
        System.out.println("Album");
        System.out.println("   Title = " + this.albumTitle);
        System.out.println("   Artist = " + this.albumArtist);
        System.out.println("   Number of tracks = " + this.numberOfTracks);
        System.out.println("   Runtime = " + this.runtime);
        System.out.println("-----------------");
    }
}
