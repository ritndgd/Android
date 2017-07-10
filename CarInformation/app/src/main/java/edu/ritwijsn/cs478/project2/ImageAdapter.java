package edu.ritwijsn.cs478.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Ritwij on 01-Oct-16.
 */

public class ImageAdapter extends BaseAdapter {
    public String [] result;
    private Context context;
    public int [] imageId;

    private static LayoutInflater inflater = null;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    public ImageAdapter(MainActivity mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        context = mainActivity;
        imageId = prgmImages;
        inflater = ( LayoutInflater ) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return imageId[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.car_list_grid, null);
        holder.tv = (TextView) rowView.findViewById(R.id.textView);
        holder.img =(ImageView) rowView.findViewById(R.id.imageView);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        /*rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });*/

        return rowView;
    }
}
