package edu.illinois.cs.chara.charaapp.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.adapters.StudentListAdapter;
import edu.illinois.cs.chara.charaapp.loaders.StudentLoader;
import edu.illinois.cs.chara.charaapp.objects.StudentListElement;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueStudentListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<List<StudentListElement>> {

    private StudentListAdapter adapter;

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
        adapter = new StudentListAdapter(this.getActivity());
        getListView().setAdapter(adapter);
        this.getLoaderManager().initLoader(0, this.getActivity().getIntent().getExtras(), this).forceLoad();
    }

    @Override
    public Loader<List<StudentListElement>> onCreateLoader(int id, Bundle args) {
        return new StudentLoader(this.getActivity(), args.getString("queue_id"));
    }

    @Override
    public void onLoadFinished(Loader<List<StudentListElement>> loader, List<StudentListElement> data) {

        adapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<List<StudentListElement>> loader) {

    }
}
