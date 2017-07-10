package edu.ritwijsn.cs478.project3_app3;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Ritwij on 30-Oct-16.
 */

public class HotelImageFragment extends Fragment {

    private ImageView imgView = null;
    private int currentPosition = -1;
    private int arrayLength;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);//To retain the fragment when configuration changes
    }

    // To create the view for the Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.img_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imgView = (ImageView) getActivity().findViewById(R.id.img_fragment);
        arrayLength = HotelViewerActivity.hotelImageList.length;
    }

    // To show the full size image at the position
    void showImageAtPosition(int position) {
        if (position < 0 || position >= arrayLength)
            return;
        currentPosition = position;
        imgView.setImageResource(HotelViewerActivity.hotelImageList[currentPosition]);
    }
}
