package edu.ritwijsn.cs478.project3_a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Ritwij on 26-Oct-16.
 * This is the receiver class which receives the intents sent by the application 1
 */

public class ReceiverApp2 extends BroadcastReceiver {

    /*Overridden method onReceive*/
    @Override
    public void onReceive(Context context, Intent intent) {
        //If intent received is Hotel then call the appropriate toast
        if(intent.getAction().equals(IntentConstants.getIntentHotel())){
            Toast.makeText(context,"You will now be seeing Hotels of Chicago",Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(IntentConstants.getIntentRestaurant())){
            Toast.makeText(context,"You will now be seeing Restaurants of Chicago",Toast.LENGTH_SHORT).show();
        }
    }
}
