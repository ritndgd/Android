package edu.ritwijsn.cs478.project3_a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /*Activity that sends broadcast*/
    private static final String INTENT_HOTEL = "INTENT_HOTEL";
    private static final String INTENT_RESTAURANT = "INTENT_RESTAURANT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Function on button hotel click*/
    public void onButtonHotelClick(View view){
        Intent intent = new Intent(INTENT_HOTEL);
        sendOrderedBroadcast(intent, null);//Ordered ordered broadcast
    }

    /*Function on button restaurant click*/
    public void onButtonRestaurantClick(View view){
        Intent intent = new Intent(INTENT_RESTAURANT);
        sendOrderedBroadcast(intent, null);
    }
}
