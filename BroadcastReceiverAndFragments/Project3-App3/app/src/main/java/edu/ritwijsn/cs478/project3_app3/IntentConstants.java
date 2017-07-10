package edu.ritwijsn.cs478.project3_app3;

/**
 * Created by Ritwij on 30-Oct-16.
 * To check for the intents being sent by the application
 */

public class IntentConstants {

    private static final String INTENT_HOTEL = "INTENT_HOTEL";
    private static final String INTENT_RESTAURANT = "INTENT_RESTAURANT";

    public static String getIntentHotel() {
        return INTENT_HOTEL;
    }//Return the Hotel Intent
    public static String getIntentRestaurant() {
        return INTENT_RESTAURANT;
    }//Restaurant Intent
}
