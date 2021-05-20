
public class Album
{
    // instance variables - replace the example below with your own
    private String albumTitle;
    private String albumArtist;
    private int numberOfTracks;
    private int songLength;
    
    public Album()
    {
        albumTitle = "ERROR: UNKNOWN";
        albumArtist = "ERROR: UNKNOWN";
        numberOfTracks = 0;
        songLength = 0;
    }

    //getter and setter set for albumTitle
    public String getAlbumTitle(){
     return albumTitle;   
    }
    
    public void setAlbumTitle(String albumTitle){
      this.albumTitle = albumTitle;
    }
    
    //getter and setter set for album artist
    public String getAlbumArtist(){
     return albumArtist;   
    }
    
    public void setAlbumArtist(String albumArtist){
     this.albumArtist = albumArtist;   
    }
    
    public int getNumberOfTracks(){
     return numberOfTracks;   
    }
    
    public void setNumberOfTracks(int numberOfTracks){
     this.numberOfTracks = numberOfTracks;  
    }
    
    public int getAlbumLength(){
     return songLength;   
    }
    
    public void setAlbumLength(int songLength){
     this.songLength = songLength;  
    }
}
