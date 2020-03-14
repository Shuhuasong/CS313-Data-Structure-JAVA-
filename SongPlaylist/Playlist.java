package SongPlaylist;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Playlist {

    LinkedList<SongEntry> playlist = new LinkedList<SongEntry>();
    static  SongEntry headNode;
    int size = playlist.size();

    public static char printMenu(String playlistTitle, Scanner scnr) {
        LinkedList<SongEntry> playlist = new LinkedList<SongEntry>();
        char option =' ';

            System.out.println(playlistTitle+ "PLAYLIST MENU");
            System.out.println("a - Add song");
            System.out.println("d - Remove song");
            System.out.println("c - Change position of song");
            System.out.println("s - Output songs by specific artist");
            System.out.println("t - Output total time of playlist (in seconds)");
            System.out.println("o - Output full playlist");
            System.out.println("q - Quit");
            System.out.println();
            System.out.println();
            while(option != 'a' || option != 'd'|| option != 'c'|| option != 's' || option != 't'  || option != 'o'){
                System.out.println("Choose an option:");
                option = scnr.next().charAt(0);
            }
            switch(option) {
                case 'a':
                    insertAtEnd(scnr);
                    break;
                case 'd':
                    removeNode(scnr);
                    break;
//                case 'c':
//                      changePosition(playlist,scnr);
//                    break;
                case 's':
                    printArtist(scnr);
                    break;
                case 't':
                    printTotalTimeOfPlaylist();
                    break;
                case 'o':
                    playList(playlistTitle, headNode);
                    break;
                case 'q':
                     System.exit(0);
                default:
                    System.out.println("Invalid input");
                    break;

            }

        return option;
    }

    public static void playList(String title, SongEntry head) {
        System.out.println(title+ "- OUT FULL PLAYLIST");
        int size = 1;
        SongEntry currentNode;
        currentNode = head.getNext();
        while(currentNode != null){
            System.out.println(size++ + ".");
            currentNode.printPlaylistSongs();
            currentNode = currentNode.getNext();
        }
    }

//    public static void changePosition(LinkedList<SongEntry> playList, Scanner scnr){
//        int currPosition;
//        int newPosition;
//        System.out.println("CHANGE POSITION OF SONG");
//        System.out.println("Enter song's current position:");
//        currPosition = scnr.nextInt();
//        System.out.println(currPosition);
//        System.out.println("Enter new position for song:");
//        newPosition = scnr.nextInt();
//        System.out.println(newPosition);
//        if(newPosition>size){
//
//        }
//    }


    public static void insertAtEnd(Scanner scnr){
        String uniqueid, songName, artistName;
        int songLength;
        System.out.println("ADD SONG");
        System.out.println("Enter song's unique ID:");
        uniqueid = scnr.nextLine();
        System.out.println("Enter song's name");
        songName = scnr.nextLine();
        System.out.println("Enter artistName's name");
        artistName = scnr.nextLine();
        System.out.println("Enter song's length (in seconds):");
        songLength = scnr.nextInt();
        SongEntry newNode = new SongEntry(uniqueid,songName,artistName,songLength);
        SongEntry currentNode;
        currentNode = headNode;
        if(currentNode == null){
            headNode = newNode;
            headNode.setNext(null);
        }
        else
            {
                currentNode.setNext(newNode);
                currentNode = newNode;
            }
    }

    public static void removeNode( Scanner scnr){
        String id;
        String songName="";
        System.out.println("REMOVE SONG");
        System.out.println("Enter song's unique ID:");
        id = scnr.nextLine();
        if(headNode == null){ return; }

        SongEntry currentNode = headNode;
        while(currentNode !=null){

            if(currentNode.getID() == id){
                songName = currentNode.getSongName();
                SongEntry next = currentNode.getNext().getNext();
                currentNode.setNext(next);
            }
            currentNode = currentNode.getNext();
        }
        System.out.println(songName + "removed");
    }

    public static void printArtist( Scanner scnr){
        String artistName;
        System.out.println("OUTPUT SONGS BY SPECIFIC ARTIST");
        System.out.println("Enter artist's name:");
        artistName = scnr.nextLine();
        SongEntry currentNode;
        currentNode = headNode;
        while(currentNode != null){
            if(currentNode.getArtistName().equals(artistName)){
                //System.out.println(LinkedList.indexOf(currentNode.getID()));
                currentNode.printPlaylistSongs();
            }
            currentNode = currentNode.getNext();
        }
    }

    public static void printTotalTimeOfPlaylist(){
        System.out.println("OUTPUT TOTAL TIME OF PLAYLIST (IN SECONDS)");
        SongEntry currentNode = headNode;
        int totalTime = 0;
        while(currentNode != null){
            totalTime += currentNode.getSongLength();
            currentNode = currentNode.getNext();
        }
        System.out.println("Total time:" + totalTime + "seconds");
    }
//    public void insertAfter(SongEntry newNode){
//        SongEntry tempNode;
//        tempNode = this.
//    }

    public static void main (String[] args){
        LinkedList<SongEntry> playlist = new LinkedList<SongEntry>();
        SongEntry headNode;
        SongEntry currNode;
        SongEntry lastNode;

        headNode = new SongEntry();
        lastNode = headNode;
        Scanner  scnr = new Scanner(System.in);
        System.out.println("Enter playlist's title:");
        String playlistTitle = scnr.nextLine();
        printMenu(playlistTitle,scnr);
    }

}
