package edu.ritwijsn.cs478.project3_app3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.net.Inet4Address;

/**
 * Created by Ritwij on 30-Oct-16.
 */

public class Receiver extends BroadcastReceiver {
    Intent intentToSend;
    @Override
    /*Override onReceive method to check for the appropriate broadcast being received by the application and launch the activity explicitly*/
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(IntentConstants.getIntentHotel())){
            intentToSend = new Intent(context.getApplicationContext(), HotelViewerActivity.class);
        }else if(intent.getAction().equals(IntentConstants.getIntentRestaurant())){
            intentToSend = new Intent(context.getApplicationContext(), RestaurantViewerActivity.class);
        }
        intentToSend.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intentToSend);
    }
}
