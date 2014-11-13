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
import edu.illinois.cs.chara.charaapp.holders.DataHolder;
import edu.illinois.cs.chara.charaapp.loaders.StudentLoader;
import edu.illinois.cs.chara.charaapp.objects.StudentListElement;

/**
 * Created by Stephen on 10/22/2014.
 */
public class QueueStudentListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<List<StudentListElement>> {

    private StudentListAdapter adapter;
    private String queueId;

    public static QueueStudentListFragment newInstance() {
        return new QueueStudentListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_queue_student_list, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new StudentListAdapter(this.getActivity());
        getListView().setAdapter(adapter);
        Bundle args = this.getActivity().getIntent().getExtras();
        queueId = args.getString("queue_id");
        this.getLoaderManager().initLoader(0, null, this).forceLoad();
    }

    @Override
    public void onResume() {
        super.onResume();
        // TODO: This is a lazy way to notify that the student list has changed.  Fix this in the future.
        adapter.notifyDataSetChanged();
    }

    @Override
    public Loader<List<StudentListElement>> onCreateLoader(int id, Bundle args) {
        return new StudentLoader(this.getActivity(), queueId);
    }

    @Override
    public void onLoadFinished(Loader<List<StudentListElement>> loader, List<StudentListElement> data) {
        DataHolder holder = DataHolder.getInstance();
        holder.setStudents(queueId, data);
        adapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<List<StudentListElement>> loader) {

    }
}
