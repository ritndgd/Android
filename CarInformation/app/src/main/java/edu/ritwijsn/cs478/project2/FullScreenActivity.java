package edu.ritwijsn.cs478.project2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * Created by Ritwij on 02-Oct-16.
 */

public class FullScreenActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_full_screen);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        final int position = i.getExtras().getInt("position");
        Log.i("Main Activity", Integer.toString(MainActivity.prgmImages[position]));

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(MainActivity.prgmImages[position]);

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse (MainActivity.urls[position]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(intent);
            }
        });
    }
}
