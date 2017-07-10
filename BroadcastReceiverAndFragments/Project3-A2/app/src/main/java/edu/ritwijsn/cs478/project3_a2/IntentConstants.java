package edu.ritwijsn.cs478.project3_a2;

/**
 * Created by Ritwij on 26-Oct-16.
 * Constants to compare the intents being passed by the broadcast.
 */

public class IntentConstants {
    private static final String INTENT_HOTEL = "INTENT_HOTEL";
    private static final String INTENT_RESTAURANT = "INTENT_RESTAURANT";

    public static String getIntentHotel() {
        return INTENT_HOTEL;
    }
    public static String getIntentRestaurant() {
        return INTENT_RESTAURANT;
    }
}
