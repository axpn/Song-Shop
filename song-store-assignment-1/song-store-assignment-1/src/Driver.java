import controllers.Playlist;
import models.Artist;
import models.Song;
import utils.ScannerInput;
import utils.Utilities;

public class Driver {
    //TODO Define an object of the Playlist here.  It should be declared private.
    private Playlist playlist = new Playlist();
    public static void main(String[] args) {
        new Driver();
    }

    //TODO Refer to the tutors instructions for building this class and for the menu.  You are free to deviate in any way
    //     from the Driver menu that is in the tutors instructions, once you have these included:
    //     (with tests still compiling)
    //       - CRUD on Playlist
    //       - Search facility (for Songs)
    //       - Reports
    //       - Persistence
    // Note:  This is the ONLY class that can talk to the user i.e. have System.out.print and Scanner reads in it.

    //----------------------------------------------------------------------------
    // Private methods for displaying the menu and processing the selected options
    //----------------------------------------------------------------------------

    //changed the menu orders
    private int mainMenu() {
        return ScannerInput.readNextInt("""
                ---------------------------------------------------------
                |                      SONGS APP                        |
                ---------------------------------------------------------
                 Song Menu                                             
                  1) Add a Song                                         
                  2) List all Songs
                  3) Update a Song
                  4) Delete a Song
                ---------------------------------------------------------
                  5) Set verified status of a specific song's artist
                  6) Find a specific Song (by code)
                  7) Search for a specific Song (by name)
                  8) Add a like to playlist
                ---------------------------------------------------------
                 Report Menu
                  9) List all Songs by verified artists
                  10) List all Songs over a given length
                  11) List all Songs by a given artist
                  12) Print the average length of songs in the playlist
                  13) Print the total length of songs in the playlist
                ---------------------------------------------------------
                 Setting Menu
                  14) Save
                  15) Load
                  0) Exit 
                ---------------------------------------------------------
                ==>                         
                """
        );
    }
    private void runMenu(){
        int option = mainMenu();
        while (option != 0){
            switch (option){
                case 1 -> addSong();
                case 2 -> listAllSongs();
                case 3 -> updateSong();
                case 4 -> deleteSong();
                case 5 -> setVerifiedStatus();
                case 6 -> findSongById();
                case 7 -> searchSongByName();
                case 8 -> addLikeToPlaylist();
                case 9 -> listSongsByVerifiedArtists();
                case 10 -> listSongsOverGivenLength();
                case 11 -> listOfSongsOfGivenArtist();
                case 12 -> printAverageLength();
                case 13 -> printLengthOfPlaylist();
                case 14 -> save();
                case 15 -> load();
                default -> System.out.println("Invalid option entered: " + option);
            }
            ScannerInput.readNextLine("\nPress enter key to continue...");
            option = mainMenu();
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }

    //------------------------------------
    // Private methods for CRUD on Song
    //------------------------------------
    //method addSong which including songName,songId,artistName,length,verified status
    private void addSong(){
        String name = ScannerInput.readNextLine("Enter the Song Name: ");
        int songId = ScannerInput.readNextInt("Enter the Song Id: ");
        String artistName = ScannerInput.readNextLine("Enter the Song's Artist: ");
        int length = ScannerInput.readNextInt("Enter the length of this song in seconds: ");
        //the method of updating verified status is referred to the code of ShopV6.0
        char isVerified = ScannerInput.readNextChar("Is this song verified?");
        boolean verified = Utilities.YNtoBoolean(isVerified);
        boolean isAdded =  playlist.addSong(new Song(songId,name,artistName,verified,length));
        if (isAdded){
            System.out.println("Song Added Successfully");
        }
        else {
            System.out.println("No Song Added");
        }
    }
    //method listAllSongs which can list all songs the user had typed in in the dialog
    private void listAllSongs(){
        System.out.println("List of Songs are: ");
        System.out.println(playlist.listAllSongs());
    }
    private void updateSong(){
        listAllSongs();
        if (playlist.numberOfSongs() > 0){
            int indexToUpdate = ScannerInput.readNextInt("Enter the index of the song to update ==> ");
            if (playlist.isValidIndex(indexToUpdate)){
                String name = ScannerInput.readNextLine("Enter the Song Name: ");
                int songId = ScannerInput.readNextInt("Enter the Song Id: ");
                String artistName = ScannerInput.readNextLine("Enter the Artist Name: ");
                int length = ScannerInput.readNextInt("Enter the length of this song in seconds");
                char isVerified = ScannerInput.readNextChar("Is this song verified?");
                boolean verified = Utilities.YNtoBoolean(isVerified);
                Song song = new Song(songId,name,artistName,verified,length);
                if (playlist.updateSong(indexToUpdate,song)){
                    System.out.println("Update Successfully");
                }
                else {
                    System.out.println("Update Not Successfully");
                }
            }
            else {
                System.out.println("There are no songs for this index number");
            }
        }
    }
    private void deleteSong(){
        listAllSongs();
        if (playlist.numberOfSongs()>0){
            int indexToDelete = ScannerInput.readNextInt("Enter the index of the song to delete ==>");
            Song songToDelete = playlist.deleteSong(indexToDelete);
            if (songToDelete != null){
                System.out.println("Delete Successfully! Delete song: " + songToDelete.getName());
            }
            else {
                System.out.println("Delete Not Successfully");
            }
        }
    }

    //-----------------------------------------------------------------
    //  Private methods for Search facility
    //-----------------------------------------------------------------


    //-----------------------------
    //  Private methods for Reports
    // ----------------------------


    //---------------------------------
    //  Private methods for Persistence
    // --------------------------------


    //TODO Add a method, load().  The return type is void.
    //    This method uses the XStream component to deserialise the playList object and their associated artists from
    //    an XML file into the Songs array list.


    //TODO Add a method, save().  The return type is void.
    //    This method uses the XStream component to serialise the playList object and their associated artists to
    //    an XML file.
}
