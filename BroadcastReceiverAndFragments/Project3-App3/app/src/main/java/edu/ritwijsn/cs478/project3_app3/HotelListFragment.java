package edu.ritwijsn.cs478.project3_app3;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Ritwij on 30-Oct-16.
 * This is to display the list of hotels
 */

public class HotelListFragment extends ListFragment{

    private ListSelectionListener listener = null;
    int position = -1;

    /*This is the callback interface to the Fragment*/
    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        /*To display the list of the hotels from the array given in the HotelViewer*/
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_layout, HotelViewerActivity.HotelArray));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);//To allow only one selection
        getListView().setItemChecked(position, true);
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {

        getListView().setItemChecked(pos, true);
        listener.onListSelection(pos);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (ListSelectionListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnArticleSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
