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
 */

public class RestaurantListFragment extends ListFragment {

    private ListSelectionListener listener = null;
    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    // Called when the user selects an item from the List
    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {

        getListView().setItemChecked(pos, true);
        listener.onListSelection(pos);
    }


    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        /*Set the adapter to display the list*/
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_layout, RestaurantViewerActivity.restaurantArray));
        /*Allow only one item selection*/
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (ListSelectionListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnArticleSelectedListener");
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

