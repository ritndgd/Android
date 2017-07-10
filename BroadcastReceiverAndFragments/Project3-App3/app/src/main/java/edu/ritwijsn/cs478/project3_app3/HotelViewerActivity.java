package edu.ritwijsn.cs478.project3_app3;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by Ritwij on 30-Oct-16.
 * This is the activity to view the Hotels list in the fragment
 */

public class HotelViewerActivity extends AppCompatActivity implements HotelListFragment.ListSelectionListener{

    private final HotelImageFragment hotelImageFragment = new HotelImageFragment();
    private FragmentManager fragmentManager;
    private FrameLayout hotelListFrameLayout, hotelImageFrameLayout;
    private static int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;

    public static String[] HotelArray = {"The Langham, Chicago\n330 N Wabash Ave, Chicago, IL 60611",
            "The Guesthouse\n4872 N Clark St, Chicago, IL 60640",
            "Four Seasons\n120 E Delaware Pl, Chicago, IL 60611 ",
            "The Peninsula Chicago\n108 E Superior St, Chicago, IL 60611",
            "The Talbott Hotel\n20 E Delaware Pl, Chicago, IL 60611",
            "Park Hyatt Chicago\n800 N Michigan Ave, Chicago, IL 60611",
            "Palomar Chicago, a Kimpton Hotel\n505 N State St, Chicago, IL 60654"};
    public static int[] hotelImageList = {R.drawable.the_langham_chicago,R.drawable.the_guesthouse,R.drawable.four_seasons,
        R.drawable.the_peninsula_chicago, R.drawable.talbott, R.drawable.park_hyatt, R.drawable.palomar_chicago};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_fragment_activity);
        // Obtain references to the HotelListFragment and HotelImageFragment
        hotelListFrameLayout = (FrameLayout) findViewById(R.id.hotel_name_container);
        hotelImageFrameLayout = (FrameLayout) findViewById(R.id.hotel_img_container);
        fragmentManager = getFragmentManager();

        // Begin the transaction by calling beginTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HotelListFragment hotelListFragment = new HotelListFragment();
        fragmentTransaction.replace(R.id.hotel_name_container, hotelListFragment);
        fragmentTransaction.commit();

        //Add a backstackchangelistener to the fargment
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        setLayout();
                    }
                });
    }

    // This method is called when the user makes a selection in the list of Hotel
    @Override
    public void onListSelection(int index) {
        if (!hotelImageFragment.isAdded()) {
            // Begin a new FragmentTransaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.hotel_img_container, hotelImageFragment);
            fragmentTransaction.addToBackStack(null);// Add FragmentTransaction to the backstack
            fragmentTransaction.commit();
            fragmentManager.executePendingTransactions();
        }
        // To display the fullzise image of the list item being selected,
        hotelImageFragment.showImageAtPosition(index);

    }

    //To add the option menu and inflate the same
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /*This is used to add the functionality to respond to user selection of options menu*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Begin HotelViewerActivity on click
        if (id == R.id.optionChosenHotel) {
            Intent i=new Intent(HotelViewerActivity.this, HotelViewerActivity.class);
            startActivity(i);
        }
        //Begin RestaurantViewerActivity on click
        if (id == R.id.optionChosenRestaurant) {
            Intent i=new Intent(HotelViewerActivity.this, RestaurantViewerActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setLayout();
    }

    @Override
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }
    }

    private void setLayout() {
        if (!hotelImageFragment.isAdded()) {
            hotelListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));//To occupy full width of the layout
            hotelImageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT));
        } else {
            //If orientation is landscape then set the following configuations
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

                hotelListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT, 1f));// To occupy only 1/3 of the entire width of layout
                hotelImageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT, 2f));//To occupy  2/3 of the width of layout
            }else{
                hotelListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT));
                hotelImageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
            }
        }
    }
}
