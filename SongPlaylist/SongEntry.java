package SongPlaylist;

public class SongEntry {
    private String uniqueId;
    private String songName;
    private String artistName;
    private int    songLength;
    private SongEntry nextNode;

    public SongEntry(){
         uniqueId = "none";
         songName = "none";
         artistName = "none";
         songLength = 0;
         nextNode = null;
    }

    public SongEntry(String uniqueIdInit, String songNameInit, String artistNameInit, int songLengthInit){
        uniqueId = uniqueIdInit;
        songName = songNameInit;
        artistName = artistNameInit;
        songLength = songLengthInit;
        nextNode = null;
    }

    public SongEntry(String uniqueIdInit, String songNameInit, String artistNameInit, int songLengthInit, SongEntry nextNodeRef){
        uniqueId = uniqueIdInit;
        songName = songNameInit;
        artistName = artistNameInit;
        songLength = songLengthInit;
        nextNode = nextNodeRef;
    }

    public void insertAfter(SongEntry currNode){
        SongEntry tempNode;
        tempNode = this.nextNode;
        this.nextNode = currNode;
        currNode.nextNode = tempNode;
    }
    public void setNext(SongEntry nextNode){
        this.nextNode = nextNode;
    }

    public String getID() { return uniqueId; }
    public String getSongName() { return songName; }
    public String getArtistName() { return artistName; }
    public int getSongLength() { return songLength; }
    public SongEntry getNext() { return nextNode; }
    public void printPlaylistSongs(){
        System.out.println("Unique ID: " + uniqueId);
        System.out.println("Song Name: " + songName);
        System.out.println("Artist Name: " + artistName);
        System.out.println("Song Length (in seconds) : " + songLength );

    }
}
