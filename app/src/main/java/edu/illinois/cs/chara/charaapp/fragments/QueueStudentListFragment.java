package edu.illinois.cs.chara.charaapp.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.adapters.StudentListAdapter;
import edu.illinois.cs.chara.charaapp.objects.StudentListElement;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueStudentListFragment extends ListFragment {

    public static QueueStudentListFragment newInstance() {
        return new QueueStudentListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_queue_student_list, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StudentListAdapter adapter = new StudentListAdapter(this.getActivity());
        List<StudentListElement> data = makeFakeData();
        adapter.setData(data);
        getListView().setAdapter(adapter);
    }

    private List<StudentListElement> makeFakeData() {

        List<StudentListElement> data = new ArrayList<StudentListElement>();
        for(int i = 0; i < 10; i++) {
            data.add(new StudentListElement("Greg Jennings", "SC 0220"));
        }

        return data;
    }
}
