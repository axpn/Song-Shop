package utils;

public class Utilities {
    // This method can judge that if user passed a string value as a parameter which length accord with
    // the request.If NOT ,truncate its length to the max value .If YES,just return its value
    // Refer to Utilities in the flash of Lab 5.1
    public static String truncateString(String stringToTruncate,int maxValueLength){
        if (stringToTruncate.length() <= maxValueLength){
            return stringToTruncate;
        }
        else {
            return stringToTruncate.substring(0,maxValueLength);
        }
    }
    //from the flash of Lab 5.1
    //can make the job of limit a value in a range more easily
    public static boolean validRange(int numberToCheck, int min, int max) {
        return ((numberToCheck >= min) && (numberToCheck <= max));
    }
    //referred to the flash of Lab 5.1
    //can make the job of judge the song's verifiedStatus more easily
    public static boolean YNtoBoolean(char charToSetVerified){
        return ((charToSetVerified == 'y') || (charToSetVerified == 'Y'));
    }
    public static double toTwoDecimalPlaces(double number){
        return (int) (number * 100 ) / 100.0;
    }
}

