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
 */

public class RestaurantViewerActivity extends AppCompatActivity implements RestaurantListFragment.ListSelectionListener{

    private final RestaurantImageFragment restaurantImageFragment = new RestaurantImageFragment();
    private FragmentManager fragmentManager;
    private FrameLayout hotelListFrameLayout, hotelImageFrameLayout;
    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;

    public static String[] restaurantArray = {"Joe's Seafood\n60 E Grand Ave, Chicago, IL 60611",
            "Smoque BBQ\n3800 N Pulaski Rd #2, Chicago, IL 60641",
            "Girl & The Goat\n809 W Randolph St, Chicago, IL 60607",
            "Rangoli Classic Indian Dining\n2421 W North Ave, Chicago, IL 60657",
            "Jaipur\n847 W Randolph St, Chicago, IL 60607",
            "Giordano's\n1340 S Michigan Ave, Chicago, IL 60605",
            "Artopolis Chicago\n306 S Halsted St, Chicago, IL 60661"};
    public static int[] restaurantImageList = {R.drawable.joes,R.drawable.smoque,R.drawable.girl_goat, R.drawable.rangoli,
            R.drawable.jaipur, R.drawable.giordanos, R.drawable.artopolis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_fragment_activity);


        // Obtain references to the ListFramelayout and ImageFragmeLayout
        hotelListFrameLayout = (FrameLayout) findViewById(R.id.hotel_name_container);
        hotelImageFrameLayout = (FrameLayout) findViewById(R.id.hotel_img_container);


        // Obtain reference to the FragmentManager
        fragmentManager = getFragmentManager();

        // Start the Fragment Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        RestaurantListFragment rlistf = new RestaurantListFragment();

        // Add the Hotel list Fragment to the list fragment
        fragmentTransaction.replace(R.id.hotel_name_container, rlistf);

        // Commit the transaction
        fragmentTransaction.commit();

        // Layout has to be reset whenever the back stack changes
        // Add a OnBackStackChangedListener for that
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        setLayout();
                    }
                });
    }

    private void setLayout() {

        //Check if HotelImage fragment has been added already
        if (!restaurantImageFragment.isAdded()) {


            //set the Hotel list fragment to occupy full layout
            hotelListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
            hotelImageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT));
        } else {

            //check if the orientation is Landscape
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

                // set the Hotel List layout to occupy only 1/3 of the layout's entire width
                hotelListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT, 1f));

                //set the Hotel image layout to occupy  2/3 of the layout's entire width
                hotelImageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT, 2f));
            }else{


                hotelListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT));
                hotelImageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
            }
        }
    }

    // Called when the user selects an item in the ChicagoTitlesFragment
    @Override
    public void onListSelection(int index) {
        if (!restaurantImageFragment.isAdded()) {
            // Begin a new Fragment Transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();// Add the framelayout to the layout
            fragmentTransaction.add(R.id.hotel_img_container, restaurantImageFragment);
            fragmentTransaction.addToBackStack(null);// Add the created the FragmentTransaction to backstack
            fragmentTransaction.commit();// Commit the FragmentTransaction
            fragmentManager.executePendingTransactions();
        }

        // Show the image at the index mentioned
        restaurantImageFragment.showImageAtPosition(index);

    }

    // To inflate the menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /*Function to perform action based on the option being clicked. Activities are launched accordingly*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Begin HotelViewerActivity
        if (id == R.id.optionChosenHotel) {
            Intent i = new Intent(RestaurantViewerActivity.this, HotelViewerActivity.class);
            startActivity(i);
        }
        //Begin RestaurantViewerActivity
        if (id == R.id.optionChosenRestaurant) {
            Intent i = new Intent(RestaurantViewerActivity.this, RestaurantViewerActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
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
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setLayout();
    }
}
