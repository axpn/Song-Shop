package models;

import utils.Utilities;

import java.util.Objects;

public class Artist {


    //TODO The artist name (String artistName)  in the system is entered by the user.
    //     Default value is "".
    //     When creating the Artist, truncate the name to 15 characters.
    //     When updating an existing Artist, only update the name if it is 15 characters or less.

    //TODO The verified status (boolean verified)  Default is false.

    //TODO Add the constructor, Artist(String, boolean), that adheres to the above validation rules

    //TODO Add a getter and setter for each field, that adheres to the above validation rules

    //TODO Add a generated equals method.

    //TODO The toString should return the string in this format:
    //      Taylor Swift is a verified artist  OR
    //      Shane Hennessy is not a verified artist


    //Declare two private properties in the class Artist and define the initial value
    private String artistName = "";//When creating the Artist, truncate the name to 15 characters.When updating an existing Artist, only update the name if it is 15 characters or less.
    private boolean verified = false;//

    //constructor,Artist(String,boolean),adheres to the validation
    //Refer to Utilities in the flash of Lab 5.1
    public Artist(String artistName,boolean verified){
        if (artistName.length() > 15){
            this.artistName = Utilities.truncateString(artistName,15);
        }
        else {
            this.artistName = artistName;
        }
        this.verified = verified;
    }
    //Getter and Setter
    public String getArtistName(){
        return artistName;
    }
    public void setArtistName(String artistName){
        this.artistName = artistName;
    }
    public boolean isVerified(){
        return verified;
    }
    public void setVerified(boolean verified){
        this.verified = verified;
    }
    //System-generated equal method
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Artist artist = (Artist) object;
        return verified == artist.verified && Objects.equals(artistName, artist.artistName);
    }
    //ToString method
    //The ternary expression was learned from CSDN(A programming forum)
    public String toString(){
        return artistName + (verified ? "is a verified artist" : "is not a verified artist");
    }

}
