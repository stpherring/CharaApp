package edu.illinois.cs.chara.charaapp.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.adapters.TAListAdapter;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueTAListFragment extends ListFragment {

    public static QueueTAListFragment newInstance() {
        return new QueueTAListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_queue_ta_list, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<String> data = makeFakeData();
        TAListAdapter adapter = new TAListAdapter(this.getActivity());
        adapter.setData(data);
        getListView().setAdapter(adapter);
    }

    private List<String> makeFakeData() {

        List<String> data = new ArrayList<String>();
        for(int i = 0; i < 2; i++) {
            data.add("Avi Prasad");
        }

        return data;
    }
}
