package models;

import utils.Utilities;

import java.util.Objects;

public class Song {

    //TODO The song id (int songId) is between 1000 to 9999(both inclusive).  Default is 9999.

    //TODO The song name (String name).
    //     Default value is "".
    //     When creating the song, truncate the name to 20 characters.
    //     When updating an existing song, only update the name if it is 20 characters or less.

    //TODO The song's artist (Artist artist)
    //    You should have already written the Artist class
    //     When creating the song, you should have the artist object as a parameter

    //TODO The length of the song in seconds (int length) is between 1 and 600. Default is 1.

    //TODO Add the constructor, Song(int, String, Artist), that adheres to the above validation rules

    //TODO Add a getter and setter for each field, that adheres to the above validation rules

    //TODO Add a generated equals method.

    //TODO The toString should return the string containing each of the field values including the use of the artist's toString()

    //Declare four private properties in Song class and set the default of song id is 9999,
    //the default of song name is "",the default of length is 1
    private int songId = 9999;//The song id is between 1000 to 9999(both inclusive).
    private String name = ""; //When creating the song, truncate the name to 20 characters.When updating an existing song, only update the name if it is 20 characters or less.
    private Artist artist;
    private int length = 1;//The length of the song in seconds (int length) is between 1 and 600.


    //Constructor Song(int,String,Artist,int) adheres to the validation
    public Song(int songId, String name, String artistName, boolean verified, int length) {
        if (Utilities.validRange(songId, 1000, 9999)) {
            this.songId = songId;
        }

        if (name.length() > 20) {
            this.name = Utilities.truncateString(name, 20);
        } else {
            this.name = name;
        }

        setArtist(new Artist(artistName, verified));

        if (Utilities.validRange(length, 1, 600)) {
            this.length = length;
        }
    }

    //Getters and Setters
    public int getSongId() {
        return songId;
    }

    public void setSongId(int i) {
        if (Utilities.validRange(songId, 1000, 9999)) {
            this.songId = songId;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String string) {
        if (name.length() <= 20) {
            this.name = name;
        }

    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int i) {
        if (Utilities.validRange(length, 1, 600)) {
            this.length = length;
        }
    }

    public String getArtistName() {
        return artist.getArtistName();
    }

    public boolean isVerified() {
        return artist.isVerified();
    }

    //System-generated equal method
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Song song = (Song) object;
        return songId == song.songId && length == song.length && Objects.equals(name, song.name) && Objects.equals(artist, song.artist);
    }

    //ToString method
    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", name='" + name + '\'' +
                ", artist=" + artist.toString() +
                ", length=" + length +
                '}';
    }

    public void setArtist(boolean verified) {
    }

    public void setArtist(String artistName) {
    }
}