package edu.ritwijsn.cs478.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ritwij on 02-Oct-16.
 */

public class TextListAdapter extends BaseAdapter{
    private static ArrayList<DealerInformation> searchArrayList;

    private LayoutInflater mInflater;

    public TextListAdapter(Context context, ArrayList<DealerInformation> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_row_view, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtaddress = (TextView) convertView.findViewById(R.id.address);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.phone);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtaddress.setText(searchArrayList.get(position).getAddress());
        holder.txtPhone.setText(searchArrayList.get(position).getPhone());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtaddress;
        TextView txtPhone;
    }
}
