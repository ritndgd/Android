package edu.ritwijsn.cs478.project2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {
    GridView gridView;

    public static String [] prgmNameList={"Hyndai", "Honda", "Chrysler", "BMW", "Mercedes","Dodge", "Nissan", "GMC", "Jeep", "Toyota"};
    public static int [] prgmImages= {R.drawable.hyundai_elantra, R.drawable.honda_civic, R.drawable.chrysler_200, R.drawable.bmw, R.drawable.mercedes, R.drawable.dodge_caravan, R.drawable.nissan_altima_black, R.drawable.gmc_terrain, R.drawable.jeep_renegade, R.drawable.toyota_rav4};
    public static String [] urls = {"https://www.hyundaiusa.com/", "http://www.honda.com/","http://www.chrysler.com/en/", "http://www.bmwusa.com/", "https://www.mbusa.com/mercedes/index","http://www.dodge.com/", "https://www.nissanusa.com/", "http://www.gmc.com/", "http://www.jeep.com/en/", "http://www.toyota.com/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView =(GridView) findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this, prgmNameList,prgmImages);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), FullScreenActivity.class);
                // passing array index
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        registerForContextMenu(gridView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo contextMenuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        Intent intent;
        switch (item.getItemId()){
            case R.id.cm_item0:
                intent = new Intent(MainActivity.this, FullScreenActivity.class);
                intent.putExtra("position", contextMenuInfo.position);
                startActivity(intent);
                break;
            case R.id.cm_item1:
                Uri uri = Uri.parse(urls[contextMenuInfo.position]);
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(intent);
                break;
            case R.id.cm_item2:
                intent = new Intent(MainActivity.this, TextListActivity.class);
                intent.putExtra("position", contextMenuInfo.position);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }


}
